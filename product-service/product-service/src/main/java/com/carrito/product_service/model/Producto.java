package com.carrito.product_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double p) { this.precio = p; }
    public Integer getStock() { return stock; }
    public void setStock(Integer s) { this.stock = s; }
}
