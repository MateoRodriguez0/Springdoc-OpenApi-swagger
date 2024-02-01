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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Productos",description = "Todo sobre los prodcutos")
public class ProductoController {

	@Operation(description = "Lista todos los productos disponibles ")
	@GetMapping(value = "/list")
	public List<Producto> listar(){
		return productoServices.findAll();
	}
	

	@Operation(description = "Obtiene un productos por id",
			parameters = {@Parameter(name = "id",description = "Es el id del producto que será buscado")})
	@GetMapping(value = "/view/{id}")
	public Producto detalle(@PathVariable(name = "id") Long id){
		return productoServices.findById(id);
	}
	

	@Operation(description = "Crea y guarda un nuevo producto",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
			content = @Content(mediaType = "application/json",schema = 
			@Schema(ref = "#/components/schemas/ProductoSave"))))
	@PostMapping(value="/save")
	public ResponseEntity<Producto> saveProduct(@RequestBody  Producto producto){
		
		return new ResponseEntity<Producto>(productoServices.save(producto)
				,HttpStatus.CREATED);
	}
	

	@Operation(description = "Actualiza el producto",
			parameters = {@Parameter(name = "id",description = "Es el id del producto que será actualizado")}
			)
	@PutMapping(value="/update")
	public ResponseEntity<Producto> updateProduct(@RequestBody Producto producto){
		return ResponseEntity
				.ok(productoServices.save(producto));
		
	}
	

	@Operation(description = "Elimina un producto por id",
			parameters = {@Parameter(name = "id",description = "Es el id del producto que será eliminado")})
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delteProduct(@PathVariable(name = "id")Long id) {
		productoServices.deleteById(id);
		return ResponseEntity
				.noContent().build();
		
		
	}
	


	@Autowired
	private ProductoServices productoServices;
}
