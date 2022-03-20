import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Homework {
    List<Intersection> intersections;
    List<Street> streetList;

    public Homework() {
        intersections = generateIntersections();
        streetList = generateStreets();
    }

    public List<Intersection> generateIntersections() {
        return IntStream.rangeClosed(0, 8).mapToObj(index -> new Intersection("v" + index)).toList();
    }

    public List<Street> generateStreets() {
        Faker faker = new Faker();
        List<Street> streetList = new LinkedList<>();
        for(int index = 0; index <= 15; index++) {
            streetList.add(new Street(faker.address().streetName(), new Random().nextInt((3 - 1) + 1) + 1));
        }
        return streetList;
    }

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
