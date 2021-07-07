package com.example.RestaurantManagement.Cart.Controller;

import com.example.RestaurantManagement.Authentification.appuser.AppUserService;
import com.example.RestaurantManagement.Cart.Dto.AddToCartDto;
import com.example.RestaurantManagement.Cart.Model.CartCost;
import com.example.RestaurantManagement.Cart.Service.CartService;
import com.example.RestaurantManagement.Restaurant.Model.Menu;
import com.example.RestaurantManagement.Restaurant.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AppUserService authenticationService;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody AddToCartDto addToCartDto) {

        cartService.addToCart(addToCartDto);

        return new ResponseEntity(addToCartDto.toString(), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartCost> getCartItems() {
        CartCost cartCost = cartService.listCartItems();
        return new ResponseEntity(cartCost,HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity updateCartItem(@RequestBody AddToCartDto cartDto){

        Optional<Menu> menu = menuService.GetMenuById(cartDto.getMenuId());

        cartService.updateCartItem(cartDto,menu);
        return new ResponseEntity(cartDto.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity deleteCartItem(@PathVariable("cartItemId") int itemID) {
        cartService.deleteCartItem(itemID);
        return new ResponseEntity(itemID, HttpStatus.OK);
    }

}

