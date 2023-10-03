package com.example.BlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.BlogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

   public List<Tema>findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}