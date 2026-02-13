package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
//Java docs for this class were generated using Google Gemini Agent on February 13th 2026,
//"I now need to add java docs of the same style as my citylist class to all methods here"
/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * This is the constructor for a City object.
     * @param city The name of the city.
     * @param province The name of the province.
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the name of the city.
     * @return The name of the city.
     */
    public String getCityName(){
        return this.city;
    }

    /**
     * This returns the name of the province.
     * @return The name of the province.
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * This compares two City objects based on their city name.
     * @param o The object to be compared.
     * @return A negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

//Taken from Google Gemini February 13th 2026,
    //"How do I make it so that I can use the contains method without failing tests?"
    /**
     * This checks if two City objects are equal.
     * Two cities are considered equal if they have the same city and province name.
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // 1. Check if it's the exact same object in memory
        if (this == o) return true;
        // 2. Check if the other object is null or of a different class
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Cast the object and compare the fields (city and province)
        City city1 = (City) o;
        return Objects.equals(this.city, city1.getCityName()) &&
                Objects.equals(this.province, city1.getProvinceName());
    }

    //Taken from Google Gemini February 13th 2026,
    //"How do I make it so that I can use the contains method without failing tests?"
    /**
     * This returns the hash code for the City object.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        // This should be generated alongside equals() to ensure consistency
        return Objects.hash(this.city, this.province);
    }
}
