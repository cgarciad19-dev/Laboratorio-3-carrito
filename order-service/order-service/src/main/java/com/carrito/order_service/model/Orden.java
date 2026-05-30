package com.carrito.order_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orden {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado = "PENDIENTE";
    private Double total;
    private LocalDateTime fecha = LocalDateTime.now();

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<ItemOrden> items;

    public Long getId() { return id; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public LocalDateTime getFecha() { return fecha; }
    public List<ItemOrden> getItems() { return items; }
    public void setItems(List<ItemOrden> items) { this.items = items; }
}