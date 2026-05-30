package com.carrito.order_service.service.pago;

import com.carrito.order_service.model.Orden;
import com.carrito.order_service.model.Pago;

public interface PagoStrategy {
    Pago procesar(Orden orden);
}