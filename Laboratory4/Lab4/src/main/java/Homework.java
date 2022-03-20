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

        City city = new City(streetList,intersections);
        city.filterStream(streetList, 4);
    }
}
