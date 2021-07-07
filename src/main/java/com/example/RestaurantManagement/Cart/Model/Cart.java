package com.example.RestaurantManagement.Cart.Model;

import com.example.RestaurantManagement.Cart.Dto.AddToCartDto;
import com.example.RestaurantManagement.Cart.Dto.CartDto;
import com.example.RestaurantManagement.Restaurant.Model.Menu;

import javax.persistence.*;
import java.util.Date;


@Entity
    @Table(name="cart")
    public class Cart {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "menu_id")
        private Long menuId;

        @Column(name = "created_date")
        private Date createdDate;

        @ManyToOne
        @JoinColumn(name = "menu_id", referencedColumnName = "id", insertable = false, updatable = false)
        private Menu menu;


        private int quantity;

        public Cart(AddToCartDto addToCartDto) {
        }


        public Cart(CartDto cartDto, Menu menu){
            this.menuId = cartDto.getId();
            this.quantity = cartDto.getQuantity();
            this.menu = menu;
            this.createdDate = new Date();
        }
        public Cart(CartDto cartDto){
            this.menuId = cartDto.getId();
            this.quantity = cartDto.getQuantity();
            this.createdDate = new Date();
        }

        public Cart(Long menuId, int quantity) {
            this.menuId = menuId;
            this.createdDate = new Date();
            this.quantity = quantity;
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

        public Date getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }

        public Menu getMenu() {
            return menu;
        }

        public void setProduct(Menu menu) {
            this.menu = menu;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

