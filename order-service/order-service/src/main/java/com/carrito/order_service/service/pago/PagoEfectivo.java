package com.carrito.order_service.service.pago;

import com.carrito.order_service.model.Orden;
import com.carrito.order_service.model.Pago;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component("EFECTIVO")
public class PagoEfectivo implements PagoStrategy {
    @Override
    public Pago procesar(Orden orden) {
        Pago pago = new Pago();
        pago.setOrden(orden);
        pago.setMonto(orden.getTotal());
        pago.setMetodo("EFECTIVO");
        pago.setEstado("PENDIENTE_COBRO");
        pago.setReferencia("EFE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        return pago;
    }
}