package com.carrito.cart_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrito implements Serializable {
    private String id;
    private List<ItemCarrito> items = new ArrayList<>();

    public Carrito() {}
    public Carrito(String id) { this.id = id; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<ItemCarrito> getItems() { return items; }
    public void setItems(List<ItemCarrito> items) { this.items = items; }
    public Double getTotal() {
        return items.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
    }
}
