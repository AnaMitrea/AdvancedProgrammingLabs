import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Homework {

    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Intersection> intersections = IntStream.rangeClosed(0, 8).mapToObj(index -> new Intersection("v" + index)).toList();

        List<Street> streetList = new LinkedList<>();
        for(int index = 0; index <= 15; index++) {
            streetList.add(new Street(faker.address().streetName(), new Random().nextInt((3 - 1) + 1) + 1));
        }

        City city = new City(streetList,intersections);
        System.out.println("\nCityMap: " + city.cityMap);
        city.filterStream(streetList, 4);

        List<Street> sortedStreetList = new LinkedList<>(streetList);
        sortedStreetList.sort(((u, v) -> Integer.compare(u.getLength(),v.getLength())));
        //System.out.println("\nSorted streetList: " + sortedStreetList);

        Kruskal kruskal = new Kruskal(city.cityMap);
        System.out.println("MST: " + kruskal.kruskalAlgorithm(sortedStreetList));

    }
}
