package com.example.RestaurantManagement.Cart.Service;

import com.example.RestaurantManagement.Cart.Dto.AddToCartDto;
import com.example.RestaurantManagement.Cart.Dto.CartDto;
import com.example.RestaurantManagement.Cart.Model.Cart;
import com.example.RestaurantManagement.Cart.Model.CartCost;
import com.example.RestaurantManagement.Cart.Repository.CartRepository;
import com.example.RestaurantManagement.Restaurant.Model.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto){
        Cart cart = getAddToCartFromDto(addToCartDto);
        cartRepository.save(cart);
    }

    private Cart getAddToCartFromDto(AddToCartDto addToCartDto) {
        Cart cart = new Cart(addToCartDto);
        return cart;
    }

    public CartCost listCartItems() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }
        double totalCost = 0;
        for (CartDto cartDto:cartItems){
            totalCost += (cartDto.getMenu().getMenu_price()* cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }


    public static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }


    public void updateCartItem(AddToCartDto cartDto, Optional<Menu> menu){
        Cart cart = getAddToCartFromDto(cartDto);
        cart.setQuantity(cartDto.getQuantity());
        cart.setId(cartDto.getId());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

  public void deleteCartItem(int id) {
        if (!cartRepository.existsById(id))
            System.out.println("Cart id is invalid : " + id);
        cartRepository.deleteById(id);

    }


}
