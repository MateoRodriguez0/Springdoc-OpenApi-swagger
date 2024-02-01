package com.springdoc.swagger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdoc.swagger.models.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long> {

}
