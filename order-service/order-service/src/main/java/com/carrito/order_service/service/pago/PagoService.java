package com.carrito.order_service.service.pago;

import com.carrito.order_service.model.Orden;
import com.carrito.order_service.model.Pago;
import com.carrito.order_service.repository.PagoRepository;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PagoService {
    private final Map<String, PagoStrategy> estrategias;
    private final PagoRepository pagoRepository;

    public PagoService(Map<String, PagoStrategy> estrategias, PagoRepository pagoRepository) {
        this.estrategias = estrategias;
        this.pagoRepository = pagoRepository;
    }

    public Pago procesarPago(Orden orden, String metodo) {
        PagoStrategy estrategia = estrategias.get(metodo.toUpperCase());
        if (estrategia == null)
            throw new IllegalArgumentException("Método de pago no soportado: " + metodo);
        Pago pago = estrategia.procesar(orden);
        return pagoRepository.save(pago);
    }
}