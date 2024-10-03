package com.example.curriculo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curriculo.entidades.Formacao;
import com.example.curriculo.repository.FormacaoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/curriculo/formacoes")
public class FormacaoController {

    @Autowired
    private FormacaoRepository repository;

    @GetMapping
    public List<Formacao> getAllFormacoes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formacao> getFormacaoById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Formacao> createFormacao(@RequestBody Formacao formacao) {
        Formacao saved = repository.save(formacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formacao> updateFormacao(@PathVariable Long id, @RequestBody Formacao formacao) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        formacao.setId(id);
        Formacao updated = repository.save(formacao);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormacao(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
