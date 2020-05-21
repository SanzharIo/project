package com.example.task.Service;

import com.example.task.Entity.Category;
import com.example.task.Entity.Section;
import com.example.task.Repo.CategoryRepo;
import com.example.task.Repo.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private SectionRepo sectionRepo;


    public void create(String name, Long sectionId){
        sectionRepo.getOne(sectionId);
        if (sectionId!=null) {
            categoryRepo.save(new Category(null, name, null, null, null, sectionRepo.getOne(sectionId)));
        }else {

        }
    }

    public void update(Long id,String name,Long sectionId){
        Category category = categoryRepo.getOne(id);
        category.setName(name);
        if (sectionId!=null) {
            Section section = sectionRepo.getOne(id);
            category.setSection(section);
        }
        categoryRepo.save(category);
    }

    public void delete(Long id){
        Category category = categoryRepo.getOne(id);
        category.setDeletedAt(LocalDateTime.now());
        categoryRepo.save(category);
    }

    public Category getCategory(Long id){
        return categoryRepo.getOne(id);
    }

    public List<Category> getAll(){
        return categoryRepo.findAllByDeletedAtNull();
    }
}
