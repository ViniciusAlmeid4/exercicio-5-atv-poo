package com.cesu.categoria.controllers;

import com.cesu.categoria.models.Categoria;
import com.cesu.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService cs;

    @GetMapping("/{id}")
    public Optional<Categoria> get(@PathVariable Long id) {
        return cs.get(id);
    }

    @GetMapping("")
    public List<Categoria> getAll() {
        return cs.getAll();
    }

    @PostMapping("")
    public ResponseEntity<Categoria> create(@RequestBody Categoria c){
        Categoria created = cs.create(c);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cs.delete(id);
        return ResponseEntity.noContent().build();
    }
}
