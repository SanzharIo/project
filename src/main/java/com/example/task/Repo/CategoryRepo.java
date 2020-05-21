package com.example.task.Repo;

import com.example.task.Entity.Category;
import com.example.task.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findAllByDeletedAtNull();

}
