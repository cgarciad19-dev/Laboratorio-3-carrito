package com.carrito.order_service.service;

import com.carrito.order_service.model.*;
import com.carrito.order_service.repository.OrdenRepository;
import com.carrito.order_service.service.pago.PagoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepo;

    public OrdenService(OrdenRepository ordenRepo) {
        this.ordenRepo = ordenRepo;
    }

    public Orden crear(List<ItemOrden> items, Double total) {
        Orden orden = new Orden();
        orden.setItems(items);
        orden.setTotal(total);
        items.forEach(i -> i.setOrden(orden));
        return ordenRepo.save(orden);
    }

    public Orden buscar(Long id) {
        return ordenRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }
}