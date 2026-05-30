package com.carrito.cart_service.controller;

import com.carrito.cart_service.model.Carrito;
import com.carrito.cart_service.model.ItemCarrito;
import com.carrito.cart_service.service.CarritoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
    private final CarritoService service;
    public CarritoController(CarritoService service) { this.service = service; }

    @PostMapping
    public Carrito crear() { return service.crear(); }

    @GetMapping("/{id}")
    public Carrito ver(@PathVariable String id) { return service.ver(id); }

    @PostMapping("/{id}/item")
    public Carrito agregarItem(@PathVariable String id, @RequestBody ItemCarrito item) {
        return service.agregarItem(id, item);
    }

    @DeleteMapping("/{id}/item/{productoId}")
    public Carrito eliminarItem(@PathVariable String id, @PathVariable String productoId) {
        return service.eliminarItem(id, productoId);
    }

    @DeleteMapping("/{id}")
    public void vaciar(@PathVariable String id) { service.vaciar(id); }
}