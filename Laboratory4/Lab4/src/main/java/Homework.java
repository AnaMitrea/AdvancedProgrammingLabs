import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Homework {

    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Intersection> intersections = IntStream.rangeClosed(0, 8).mapToObj(index -> new Intersection("v" + index)).toList();
        System.out.println("Intersections: \n" + intersections);

        List<Street> streetList = new LinkedList<>();
        for(int index = 0; index <= 15; index++) {
            streetList.add(new Street(faker.address().streetName(), new Random().nextInt((5 - 1) + 1) + 1));
        }
        System.out.println("Unsorted streetList: \n" + streetList);

        City city = new City();
        city.createCityMap(streetList,intersections);
        System.out.println(city);

        System.out.println("Filtering...");
        /*
        intersections.stream()
                .filter(v -> city.getCityMap().get(v).contains(streetList.get(2)))
                .forEach(System.out::println);
        */
        System.out.println("Filtering... Only intersections which join >=4 streets");
        intersections.stream()
                .filter(v -> city.computeNumberOfStreets(city.getCityMap().get(v)) >=4)
                .forEach(System.out::println);
    }
}
