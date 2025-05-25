package com.george.artifactgeorge.repository;

import com.george.artifactgeorge.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}