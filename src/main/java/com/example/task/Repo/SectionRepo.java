package com.example.task.Repo;


import com.example.task.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepo extends JpaRepository<Section, Long> {
    List<Section> findAllByDeletedAtNull();
}
