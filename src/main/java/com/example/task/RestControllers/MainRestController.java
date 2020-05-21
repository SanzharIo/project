package com.example.task.RestControllers;

import com.example.task.Entity.Category;
import com.example.task.Entity.Section;
import com.example.task.Repo.CategoryRepo;
import com.example.task.Service.CategoryService;
import com.example.task.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class MainRestController {


    private CategoryService categoryService;
    private SectionService sectionService;

    @Autowired
    public MainRestController(CategoryService categoryService, SectionService sectionService) {
        this.categoryService = categoryService;
        this.sectionService = sectionService;
    }

    //---------------------------------------------------------------------------
    ////There the category action begins
    @ResponseBody
    @GetMapping(path = "/categories")
    public ResponseEntity<List<Category>> allCategories(){
        List<Category> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/addCategory")
    public ResponseEntity<String> addCategory(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "sectionId", required = false)Long sectionId){
        System.out.println(sectionId);
        categoryService.create(name,sectionId);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/updateCategory")
    public ResponseEntity<String> updateCategory(
            @RequestParam(name = "id")Long id,
            @RequestParam(name = "name")String name,
            @RequestParam(name = "sectionId", required = false)Long sectionId){
        categoryService.update(id,name,sectionId);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/delCategory/{id}")
    public ResponseEntity<String> delCategory(
            @PathVariable(name = "id")Long id){
        categoryService.delete(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
//--------------------------------------------------------------------
    ////There the section action begins
    @ResponseBody
    @GetMapping(path = "/sections")
    private ResponseEntity<List<Section>> allSections(){
        return new ResponseEntity<>(sectionService.getAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/addSection/{name}")
    public ResponseEntity<String> addItem(@PathVariable(name = "name") String name){
        sectionService.create(name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/updateSections")
    public ResponseEntity<String> updateSections(
            @RequestParam(name = "id")Long id,
            @RequestParam(name = "name")String name){
        sectionService.update(id,name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @ResponseBody
    @PostMapping(path = "/delSections/{id}")
    public ResponseEntity<String> delSections(
            @PathVariable(name = "id")Long id){
        sectionService.delete(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
