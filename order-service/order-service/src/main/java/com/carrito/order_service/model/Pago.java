package com.carrito.order_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String metodo;
    private Double monto;
    private String estado;
    private String referencia;
    private LocalDateTime fecha = LocalDateTime.now();

    @OneToOne
    private Orden orden;

    public Long getId() { return id; }
    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public LocalDateTime getFecha() { return fecha; }
    public Orden getOrden() { return orden; }
    public void setOrden(Orden orden) { this.orden = orden; }
}