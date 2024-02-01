package com.springdoc.swagger.services;

import java.util.List;
import com.springdoc.swagger.models.Producto;



public interface ProductoServices {

	public List<Producto> findAll();
	public Producto  findById(Long id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
	
}
