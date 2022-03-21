package solution;

import algorithm.kruskal.Kruskal;
import graph.*;
import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Homework {
    List<Intersection> intersections;
    List<Street> streetList;

    /**
     * Main constructor used for calling the generating methods for the streets and intersections.
     */
    public Homework() {
        intersections = generateIntersections();
        streetList = generateStreets();
    }

    /**
     * Method used for generating the list of intersections. In total: 9 intersections with indexes starting from 0 and ending with 8.
     * @return  List of intersections.
     */
    public List<Intersection> generateIntersections() {
        Faker faker = new Faker();
        return IntStream.rangeClosed(0, 8).mapToObj(index -> new Intersection(faker.address().streetAddressNumber())).toList();
    }

    /**
     * Method used for generating the list of streets. The street addresses are randomly generated using an external library - Faker.<br>
     * In total: 16 streets, using indexes starting from 0 and ending with 15 to identify them more easily.
     * @return      The list of streets.
     */
    public List<Street> generateStreets() {
        Faker faker = new Faker();
        List<Street> streetList = new LinkedList<>();
        for(int index = 0; index <= 15; index++) {
            streetList.add(new Street(faker.address().streetName(), new Random().nextInt((3 - 1) + 1) + 1));
        }
        return streetList;
    }

    /**
     * Method used for sorting (ascending) a list of streets by their lengths.
     * @param streetList        The list of streets.
     * @return                  The sorted list.
     */
    public List<Street> sortStreetList(List<Street> streetList) {
        List<Street> sortedStreetList = new LinkedList<>(streetList);
        sortedStreetList.sort(((u, v) -> Integer.compare(u.getLength(),v.getLength())));
        return sortedStreetList;
    }

    public static void main(String[] args) {
        Homework homework = new Homework();

        City city = new City(homework.streetList, homework.intersections);
        System.out.println("\nCityMap: " + city.cityMap);

        city.filterStream(homework.streetList, 4);

        List<Street> sortedStreetList = homework.sortStreetList(homework.streetList);

        Kruskal kruskal = new Kruskal(city.cityMap);
        System.out.println("Minimum cost using only: " + kruskal.kruskalAlgorithm(sortedStreetList));
    }
}
