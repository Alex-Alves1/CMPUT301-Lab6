package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        //check it contains initialization city
        assertTrue(cityList.hasCity(mockCity()));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        //check again after adding a new city
        assertTrue(cityList.hasCity(city));
        City fake_city = new City("Orange Town", "Alberta");
        //check to make sure it returns false for non membership cities
        assertEquals(false,(cityList.hasCity(fake_city)));

    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        //check it contains initialization city
        assertTrue(cityList.hasCity(mockCity()));
        cityList.delete(mockCity());
        //assert it actually deleted the city, and doesnt exist, should throw a new exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(mockCity());
        });
    }

    @Test
    void countCities() {
        CityList cityList = mockCityList();
        //check it returns 1 for count after initial 1 city list
        assertEquals(1, cityList.countCities());
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        //check it counts two cities
        assertEquals(2, cityList.countCities());
        //remove both cities and verify it returns 0
        cityList.delete(mockCity());
        cityList.delete(city);
        assertEquals(0, cityList.countCities());
    }
}