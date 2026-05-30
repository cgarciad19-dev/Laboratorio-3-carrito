package com.carrito.cart_service.model;

import java.io.Serializable;

public class ItemCarrito implements Serializable {
    private String productoId;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioUnitario;

    public ItemCarrito() {}
    public ItemCarrito(String productoId, String nombreProducto, Integer cantidad, Double precioUnitario) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getProductoId() { return productoId; }
    public void setProductoId(String productoId) { this.productoId = productoId; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getSubtotal() { return cantidad * precioUnitario; }
}
