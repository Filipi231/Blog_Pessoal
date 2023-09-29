package com.example.BlogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogPessoal.model.Postagens;
import com.example.BlogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository PostagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>>getAll(){
		return ResponseEntity.ok(PostagemRepository.findAll());
	}

}
	

	
	
