package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.curriculo.entidades.Formacao;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Long> {

}