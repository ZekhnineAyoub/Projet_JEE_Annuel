package com.example.RestaurantManagement.Repository;


import com.example.RestaurantManagement.Restaurant.Enums.Ratings;
import com.example.RestaurantManagement.Restaurant.Enums.Specialty;
import com.example.RestaurantManagement.Restaurant.Model.Menu;
import com.example.RestaurantManagement.Restaurant.Model.Restaurant;
import com.example.RestaurantManagement.Restaurant.Repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository underTest;

    @Test
    void checkRestaurantByCIty() {
        //given
        List<Long> expectedList = new ArrayList<>();
        Menu menu = new Menu(  1l,
                              "kebab avec fromage",
                               "menu item",
                               8l);

        Restaurant restaurant = new Restaurant(
                "Tacos de paris",
                "Colombe",
                "0622157689",
                Specialty.Kebab,
                Ratings.DeuxEtoiles,
                menu);
        underTest.save(restaurant);
        //when
        expectedList = underTest.GetRestaurantByCIty(restaurant.getLocation());
        //then
        assertThat(expectedList).isNotNull();

    }

    @Test
    void selectExistsName() {
        //given
        Menu menu = new Menu( 1l,
                "kebab avec fromage",
                "menu item",
                8l);

        Restaurant restaurant = new Restaurant(
                "Tacos de paris",
                "Colombe",
                "06625874",
                Specialty.Kebab,
                Ratings.DeuxEtoiles,
                menu);

        //when
        Boolean expected = underTest.SelectExistsName(restaurant.getName());
        //then
        assertThat(expected).isFalse();

    }
}