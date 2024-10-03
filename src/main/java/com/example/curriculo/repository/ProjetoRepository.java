package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.curriculo.entidades.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}

