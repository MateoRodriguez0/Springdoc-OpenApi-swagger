## SpringDoc with OpenApi in Spring Boot 3.2.1

This is a product API with the purpose of learning how to document rest APIs in spring boot with swagger. In this case I used SpringDoc-OpneAPI to use the library annotations and be able to customize the documentation of my API.

```yaml

springdoc:
  api-docs:
    path: /openapi/docs

  swagger-ui:
    path: /openapi

```
### Dependencies
```xml
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
	<version>2.3.0</version>
</dependency>

<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.3.0</version>
</dependency>
```

### creation of schema for the Requestbody of the endpoint localhost:8090/save

``` java
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
``` 

### Example 
![Captura de pantalla 2024-02-01 171519](https://github.com/MateoRodriguez0/Springdoc-OpenApi-swagger/assets/107595139/1ab0f46e-9c0b-46ac-b176-65f066dd509b)
