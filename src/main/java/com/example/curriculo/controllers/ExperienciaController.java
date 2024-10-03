package com.example.curriculo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curriculo.entidades.Experiencia;
import com.example.curriculo.repository.ExperienciaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/curriculo/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository repository;

    @GetMapping
    public List<Experiencia> getAllExperiencias() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getExperienciaById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Experiencia> createExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia saved = repository.save(experiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        experiencia.setId(id);
        Experiencia updated = repository.save(experiencia);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperiencia(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
