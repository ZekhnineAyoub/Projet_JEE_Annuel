package com.example.RestaurantManagement.Cart.Dto;

import com.example.RestaurantManagement.Cart.Model.Cart;
import com.example.RestaurantManagement.Restaurant.Model.Menu;
import com.sun.istack.NotNull;

public class CartDto {
    private Long id;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
    private @NotNull Menu menu;

    public CartDto() {
    }

    public CartDto(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setMenu(cart.getMenu());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", Menu=" + menu.toString() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
