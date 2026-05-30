package com.carrito.product_service.repository;

import com.carrito.product_service.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {}
