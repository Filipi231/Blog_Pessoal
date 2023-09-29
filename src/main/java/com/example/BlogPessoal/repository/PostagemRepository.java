package com.example.BlogPessoal.repository;

import com.example.BlogPessoal.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<Postagens,Long>{

}