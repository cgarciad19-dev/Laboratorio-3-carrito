package com.carrito.cart_service.service;

import com.carrito.cart_service.model.Carrito;
import com.carrito.cart_service.model.ItemCarrito;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CarritoService {
    private static final String PREFIX = "carrito:";
    private final RedisTemplate<String, Object> redisTemplate;

    public CarritoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Carrito crear() {
        String id = UUID.randomUUID().toString();
        Carrito carrito = new Carrito(id);
        redisTemplate.opsForValue().set(PREFIX + id, carrito);
        return carrito;
    }

    public Carrito ver(String id) {
        Carrito carrito = (Carrito) redisTemplate.opsForValue().get(PREFIX + id);
        if (carrito == null) throw new RuntimeException("Carrito no encontrado");
        return carrito;
    }

    public Carrito agregarItem(String carritoId, ItemCarrito item) {
        Carrito carrito = ver(carritoId);
        carrito.getItems().add(item);
        redisTemplate.opsForValue().set(PREFIX + carritoId, carrito);
        return carrito;
    }

    public Carrito eliminarItem(String carritoId, String productoId) {
        Carrito carrito = ver(carritoId);
        carrito.getItems().removeIf(i -> i.getProductoId().equals(productoId));
        redisTemplate.opsForValue().set(PREFIX + carritoId, carrito);
        return carrito;
    }

    public void vaciar(String carritoId) {
        redisTemplate.delete(PREFIX + carritoId);
    }
}