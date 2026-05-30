package com.carrito.order_service.controller;

import com.carrito.order_service.model.*;
import com.carrito.order_service.service.OrdenService;
import com.carrito.order_service.service.pago.PagoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenController {
    private final OrdenService ordenService;
    private final PagoService pagoService;

    public OrdenController(OrdenService ordenService, PagoService pagoService) {
        this.ordenService = ordenService;
        this.pagoService = pagoService;
    }

    @PostMapping
    public Orden crear(@RequestBody List<ItemOrden> items) {
        double total = items.stream().mapToDouble(ItemOrden::getSubtotal).sum();
        return ordenService.crear(items, total);
    }

    @GetMapping("/{id}")
    public Orden ver(@PathVariable Long id) { return ordenService.buscar(id); }

    @PostMapping("/{id}/pago")
    public Pago pagar(@PathVariable Long id, @RequestParam String metodo) {
        Orden orden = ordenService.buscar(id);
        return pagoService.procesarPago(orden, metodo);
    }
}