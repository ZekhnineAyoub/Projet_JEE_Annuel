package com.example.RestaurantManagement.Restaurant.Service;

import com.example.RestaurantManagement.Restaurant.Model.Menu;
import com.example.RestaurantManagement.Restaurant.Model.Restaurant;
import com.example.RestaurantManagement.Restaurant.Repository.MenuRepository;
import com.example.RestaurantManagement.Restaurant.exeption.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<Menu> GetAllMenus() {

        return  menuRepository.findAll();
    }

    public Optional<Menu> GetMenuById(Long id) {

        return menuRepository.findById(id);
    }
}
