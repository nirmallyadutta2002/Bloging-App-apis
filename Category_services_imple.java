package com.api.blog.services.imple;
import com.api.blog.entitey.Category;
import com.api.blog.exception.ResourceNotfoundexception;
import com.api.blog.paylode.Category_dto;
import com.api.blog.repo.Category_repo;
import com.api.blog.services.Category_services;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class Category_services_imple implements Category_services {
   @Autowired
   private  Category_repo category_repo;
   @Autowired
   private ModelMapper modelMapper;
    @Override
    public Category_dto createCategory(Category_dto categoryDto) {
        Category category=dtotocategory(categoryDto);
        Category category1=this.category_repo.save(category);
        return categorytoDto(category1);
    }
    @Override
    public Category_dto updateCategory(Category_dto categoryDto, int id) {
      Category  category = this.category_repo.findById(id).
              orElseThrow(()->new ResourceNotfoundexception("Category","c_id",id));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
      Category update_catagory=this.category_repo.save(category);
      Category_dto category_dto=this.modelMapper.map(update_catagory, Category_dto.class);
        return category_dto;
    }

    @Override
    public void deleteCategory(int id) {
   Category category=this.category_repo.findById(id).
           orElseThrow(()->new ResourceNotfoundexception("Category","c_id",id));
           this.category_repo.delete(category);
    }

    @Override
    public List<Category_dto> getAllCategories() {
        List<Category>gt=this.category_repo.findAll();
        List<Category_dto>categoryDtos=gt.stream().map(i->categorytoDto(i)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public Category_dto getCategoryById(int id) {
        Category category=this.category_repo.findById(id).orElseThrow(()->new ResourceNotfoundexception("Category","c_id",id));
        Category_dto category_dto=this.categorytoDto(category);
        return category_dto;
    }
    Category_dto categorytoDto(Category category){

        Category_dto category_dto=modelMapper.map(category, Category_dto.class);
        return  category_dto;
    }
    Category dtotocategory(Category_dto category_dto){
        Category category=modelMapper.map(category_dto, Category.class);
        return  category;
    }
}
