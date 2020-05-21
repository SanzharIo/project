package com.example.task.Controllers;

import com.example.task.Service.CategoryService;
import com.example.task.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private CategoryService categoryService;
    private SectionService sectionService;

    @Autowired
    public MainController(CategoryService categoryService, SectionService sectionService) {
        this.categoryService = categoryService;
        this.sectionService = sectionService;
    }

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    //There the category action begins
    @GetMapping(path = "/categories")
    public String categoriesList(){
        return "categories";
    }

   //There the category action begins
    @GetMapping(path = "/sections")
    public String sectionsList() {
        return "sections";
    }



}
