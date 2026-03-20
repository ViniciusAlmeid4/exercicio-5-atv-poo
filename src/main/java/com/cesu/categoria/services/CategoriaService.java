package com.cesu.categoria.services;

import com.cesu.categoria.models.Categoria;
import com.cesu.categoria.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository cr;

    public Optional<Categoria> get(Long id) {
        return cr.findById(id);
    }

    public List<Categoria> getAll() {
        return cr.findAll();
    }

    public Categoria create(Categoria c) {
        return cr.save(c);
    }

    public void delete(Long id) {
        cr.deleteById(id);
    }
}
