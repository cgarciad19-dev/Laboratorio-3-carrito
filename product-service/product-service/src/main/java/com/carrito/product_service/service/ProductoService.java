package com.carrito.product_service.service;

import com.carrito.product_service.model.Producto;
import com.carrito.product_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repo;
    public ProductoService(ProductoRepository repo) { this.repo = repo; }

    public List<Producto> listar() { return repo.findAll(); }
    public Producto guardar(Producto p) { return repo.save(p); }
    public Producto buscar(String id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    public void eliminar(String id) { repo.deleteById(id); }
}