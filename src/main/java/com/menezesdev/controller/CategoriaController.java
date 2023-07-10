package com.menezesdev.controller;

import com.menezesdev.models.Categoria;
import com.menezesdev.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = service.find(id);
		return ResponseEntity.ok().body(categoria);
	}
		//return ResponseEntity.badRequest().body(new Error(1, "Error processing request"));
		//return ResponseEntity<>(obj, HttpStatus.OK);


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria) {
		categoria = service.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
		categoria.setId(id);
		categoria = service.update(categoria);
		return ResponseEntity.noContent().build();

	}






	@GetMapping(path = "/teste")
	public Categoria test() {
		return new Categoria(3, "Teste");
	}

	@PostMapping(path = "/testePost")
	public ResponseEntity<Categoria> testPost(@RequestBody Categoria cat){
		System.out.printf(cat.toString());
		return new ResponseEntity<>(cat, HttpStatus.OK);
	}
	@PostMapping(path = "/testPostList")
	public ResponseEntity<List<Categoria>> testPostList(@RequestBody List<Categoria> catList){
		for (int i = 0; i < catList.size(); i++){
		System.out.printf(catList.get(i).toString());
		}

		for (Categoria categoria: catList) {
			System.out.printf(categoria.toString());
		}

		return new ResponseEntity<>(catList, HttpStatus.OK);
	}



}
