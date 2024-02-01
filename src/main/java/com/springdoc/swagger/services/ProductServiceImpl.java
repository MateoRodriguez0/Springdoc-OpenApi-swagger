package com.springdoc.swagger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdoc.swagger.models.Producto;
import com.springdoc.swagger.repositories.ProductoRespository;



@Service
public class ProductServiceImpl implements ProductoServices {

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		
		return productoRespository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		
		return productoRespository
				.findById(id)
				.orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		
		productoRespository.deleteById(id);

	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRespository.save(producto);
	}
		
	
	@Autowired
	private ProductoRespository productoRespository;
	



}
