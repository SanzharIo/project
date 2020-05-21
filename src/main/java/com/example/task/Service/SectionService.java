package com.example.task.Service;

import com.example.task.Entity.Category;
import com.example.task.Entity.Section;
import com.example.task.Repo.CategoryRepo;
import com.example.task.Repo.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SectionService {

    private CategoryRepo categoryRepo;
    private SectionRepo sectionRepo;

    @Autowired
    public SectionService(CategoryRepo categoryRepo, SectionRepo sectionRepo) {
        this.categoryRepo = categoryRepo;
        this.sectionRepo = sectionRepo;
    }

    public void create(String name){
        Set<Category> categories = new HashSet<>();
        System.out.println(name);
        sectionRepo.save(new Section(null,name,null,null,null,categories));
    }

    public void update(Long id,String name){
        Section section = sectionRepo.getOne(id);
        section.setName(name);
        System.out.println(name);
        sectionRepo.save(section);
    }

    public void delete(Long id){
        Section section = sectionRepo.getOne(id);
        section.setDeletedAt(LocalDateTime.now());
        sectionRepo.save(section);
    }

    public Section getSection(Long id){
        return sectionRepo.getOne(id);
    }

    public List<Section> getAll(){
        return sectionRepo.findAllByDeletedAtNull();
    }

}
