package com.example.RestaurantManagement.Service;


import com.example.RestaurantManagement.Restaurant.Enums.Ratings;
import com.example.RestaurantManagement.Restaurant.Enums.Specialty;
import com.example.RestaurantManagement.Restaurant.Model.Menu;
import com.example.RestaurantManagement.Restaurant.Model.Restaurant;
import com.example.RestaurantManagement.Restaurant.Repository.RestaurantRepository;
import com.example.RestaurantManagement.Restaurant.Service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock private RestaurantRepository restaurantRepository;
    private RestaurantService underTest;

    @BeforeEach
    void setUp() {
        underTest = new RestaurantService(restaurantRepository);
    }


    @Test
    void canGetAllRestaurant() {

        //when
        underTest.GetAllRestaurant();
        //then
        verify(restaurantRepository).findAll();

    }
    @Test
    void CanAddNewRestaurant() {

        //Given
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
        underTest.AddNewRestaurant(restaurant);
        //then
        ArgumentCaptor<Restaurant> restaurantArgumentCaptor = ArgumentCaptor.forClass(Restaurant.class);
        verify(restaurantRepository).save(restaurantArgumentCaptor.capture());

        Restaurant captureRestaurant = restaurantArgumentCaptor.getValue();
        assertThat(captureRestaurant).isEqualTo(restaurant);

    }

    @Test
    void ShouldgetRestaurantById() {
        //Given
        Menu menu = new Menu( 1l,
                "kebab avec fromage",
                "menu item",
                8l);
        Restaurant restaurant = new Restaurant(
                5l,
                "Tacos de paris",
                "Colombe",
                "06625874",
                Specialty.Kebab,
                Ratings.DeuxEtoiles,
                menu);

        //When
        underTest.GetRestaurantById(restaurant.getId());
        //Then
        verify(restaurantRepository).findById(5l);
        //And
        assertThat(restaurant.getPhone_number()).isEqualTo("06625874");
        //And
        assertThat(restaurant.getLocation()).isEqualTo("Colombe");

    }

    @Test
    void ShouldDeletRestaurantById() {
        //Given
        Menu menu = new Menu( 1l,
                "kebab avec fromage",
                "menu item",
                8l);
        Restaurant restaurant = new Restaurant(
                5l,
                "Tacos de paris",
                "Colombe",
                "06625874",
                Specialty.Kebab,
                Ratings.DeuxEtoiles,
                menu);
        //when
        underTest.DeletRestaurantById(restaurant.getId());
        //then
        verify(restaurantRepository).deleteById(restaurant.getId());



    }

    @Test
    void getAllRestaurantProximity() {
        //Given
        Menu menu = new Menu( 1l,
                "kebab avec fromage",
                "menu item",
                8l);
        //And
        Restaurant restaurant = new Restaurant(
                5l,
                "Tacos de paris",
                "Colombe",
                "06625874",
                Specialty.Kebab,
                Ratings.DeuxEtoiles,
                menu);

        //When
        underTest.GetAllRestaurantProximity();
        //Then
        assertThat(restaurant.getLocation()).isEqualTo("Colombe");

    }

}