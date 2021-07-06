package com.example.RestaurantManagement.Restaurant.Repository;

import com.example.RestaurantManagement.Restaurant.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
