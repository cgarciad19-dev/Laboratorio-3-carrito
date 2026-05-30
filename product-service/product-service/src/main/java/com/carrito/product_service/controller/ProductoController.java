package com.carrito.product_service.controller;

import com.carrito.product_service.model.Producto;
import com.carrito.product_service.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService service;
    public ProductoController(ProductoService service) { this.service = service; }

    @GetMapping
    public List<Producto> listar() { return service.listar(); }

    @PostMapping
    public Producto crear(@RequestBody Producto p) { return service.guardar(p); }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable String id) { return service.buscar(id); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) { service.eliminar(id); }
}