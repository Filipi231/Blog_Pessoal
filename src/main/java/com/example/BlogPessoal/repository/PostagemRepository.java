package com.example.BlogPessoal.repository;

import com.example.BlogPessoal.model.Postagens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<Postagens,Long>{

	 List<Postagens> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
}