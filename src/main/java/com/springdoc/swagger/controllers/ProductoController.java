package com.springdoc.swagger.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdoc.swagger.models.Producto;
import com.springdoc.swagger.services.ProductoServices;

@RestController
public class ProductoController {

	
	@GetMapping(value = "/list")
	public List<Producto> listar(){
		return productoServices.findAll();
	}
	
	@GetMapping(value = "/view/{id}")
	public Producto detalle(@PathVariable(name = "id") Long id){
		return productoServices.findById(id);
	}
	
	
	@PostMapping(value="/save")
	public ResponseEntity<Producto> saveProduct(@RequestBody Producto producto){
		
		return new ResponseEntity<Producto>(productoServices.save(producto)
				,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Producto> updateProduct(@RequestBody Producto producto){
		return ResponseEntity
				.ok(productoServices.save(producto));
		
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delteProduct(@PathVariable(name = "id")Long id) {
		productoServices.deleteById(id);
		return ResponseEntity
				.noContent().build();
		
		
	}
	


	@Autowired
	private ProductoServices productoServices;
}
