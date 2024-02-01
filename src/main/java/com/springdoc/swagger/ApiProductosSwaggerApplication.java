package com.springdoc.swagger;

import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springdoc.swagger.models.Producto;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;

@SpringBootApplication
public class ApiProductosSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProductosSwaggerApplication.class, args);
	}

	
	  @Bean
	  OpenAPI springShopOpenAPI() {
		  
		
		 
	      return new OpenAPI(SpecVersion.V31)
	    		  .info(new Info()
	    				  .title("Api Productos - Spring Doc")
	    				  .version("0.0.1-SNAPSHOT")
	    				  .description("Esta es una api que permite realizar operaciones CRUD en una base "
	    				  		+ "de datos de productos en H2 database basado enla especificacion OpenAPI 3.1.0. Con el fin de aprender a documentar "
	    				  		+ "mis APIs desarrolladas con spring boot.")
	    				  .contact(new Contact()
	    						  .name("Mateo Rodriguez")
	    						  .email("mateo204r@gmail.com"))
	    				  )
	    		  ;
	    		
	              
	  }
	  
	  /**
	   * Agregando un nuevo schema a para el request body post de productos
	   * @return
	   */
	  @Bean
	   OpenApiCustomizer consumerTypeHeaderOpenAPICustomizer() {
		  Schema<Producto> schema= new Schema<>();
		  Map<String, Schema> properties= new HashMap<>();
		
		  properties.put("nombre", new Schema().type("string"));
		  properties.put("precio", new Schema().type("number").format("double"));
		  properties.put("fechaDeCreacion", new Schema().type("string").format("date-time"));
		  schema.name("productoSave");
		  schema.type("object");
		  schema.properties(properties);
		  
		  return openApi -> openApi
				  .components(openApi.getComponents())
				  .schema("ProductoSave", schema);
	  }
}
