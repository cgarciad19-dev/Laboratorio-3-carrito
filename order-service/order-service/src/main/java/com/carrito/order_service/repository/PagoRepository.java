package com.carrito.order_service.repository;

import com.carrito.order_service.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagoRepository extends JpaRepository<Pago, Long> {}