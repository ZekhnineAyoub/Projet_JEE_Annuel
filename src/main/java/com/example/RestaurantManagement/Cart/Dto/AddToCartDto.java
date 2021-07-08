package com.example.RestaurantManagement.Cart.Dto;

import com.example.RestaurantManagement.Cart.Model.Cart;
import com.sun.istack.NotNull;

public class AddToCartDto {
    private Long id;
    private @NotNull Long menuId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(Long id, @NotNull Long menuId, @NotNull Integer quantity) {
        this.id = id;
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setId(cart.getId());
        this.setMenuId(cart.getMenuId());
        this.setQuantity(cart.getQuantity());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", quantity=" + quantity +
                ",";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
