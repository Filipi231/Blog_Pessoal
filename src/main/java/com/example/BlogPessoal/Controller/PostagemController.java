package com.example.BlogPessoal.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.BlogPessoal.model.Postagens;
import com.example.BlogPessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

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
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable Long id){
		return PostagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(PostagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagens> post(@Valid @RequestBody Postagens postagens) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(PostagemRepository.save(postagens));
	}
	
	@PutMapping
	public ResponseEntity<Postagens> put(@Valid @RequestBody Postagens postagens) {
		return PostagemRepository.findById(postagens.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(PostagemRepository.save(postagens)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Postagens> postagem = PostagemRepository.findById(id);
		
		if(postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		PostagemRepository.deleteById(id);			
	
	}
}
	

	
	
