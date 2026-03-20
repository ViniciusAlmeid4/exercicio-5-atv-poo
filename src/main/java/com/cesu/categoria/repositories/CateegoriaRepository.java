package com.cesu.categoria.repositories;

import com.cesu.categoria.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateegoriaRepository extends JpaRepository<Categoria, Long> {
}
