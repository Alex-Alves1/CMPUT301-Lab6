package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks the membership of a city in a citylist
     *
     * @param city
     * This is the city to check membership of
     *
     * @return Boolean, whether or not the list contains the city, true if so,
     * false if not
     */
    public Boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Check if a city is present in the list. If it does then remove it from the list,
     *  if not then **throw an exception**
     *
     * @param city
     * This is the city
     *
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * Return how many cities are in the list
     *
     * @return integer count of cities in the list
     */
    public int countCities() {
        return cities.size();
    }


}
