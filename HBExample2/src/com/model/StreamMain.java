package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    static List<Place> places = new ArrayList<>();

    static class Place {
        String country;
        String city;

        Place(String country, String city) {
            this.country = country;
            this.city = city;
        }

        @Override
        public String toString() {
            return country + ", " + city;
        }
    }

    public static List<Place> getPlaces() {
        places.add(new Place("Nepal", "Kathmandu"));
        places.add(new Place("Nepal", "Pokhara"));
        places.add(new Place("India", "Chennai"));
        places.add(new Place("USA", "New York"));

        return places;
    }

    public static void main(String[] args) {
        List<Place> myPlaces = getPlaces();
        System.out.println("Places from Nepal:");

        myPlaces.stream()
                .filter((p) -> p.country.equals("Nepal")) 
                .map((p) -> p.toString().toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));
    }
}
