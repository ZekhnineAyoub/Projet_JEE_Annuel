package com.example.RestaurantManagement.Cart.Repository;

import com.example.RestaurantManagement.Cart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);

}
