import java.util.*;
import java.util.stream.IntStream;

public class Compulsory {
    public static void main(String[] args) {
        List<Intersection> intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(index -> new Intersection("v" + index)).toList();
        System.out.println("Intersections: " + intersections);

        List<Street> streetList = new LinkedList<>();
        for(int index = 0; index < 15; index++) {
            streetList.add(new Street("s" + index, new Random().nextInt((3 - 1) + 1) + 1));
        }
        System.out.println("Unsorted streetList: " + streetList);

        List<Street> sortedStreetList = new LinkedList<>(streetList);
        sortedStreetList.sort(((u, v) -> u.getLength().compareTo(v.getLength())));
        System.out.println("\nSorted streetList: " + sortedStreetList);

        Set<Street> streetHashSet = new HashSet<>(streetList);
        System.out.println("\nStreet set: " + streetHashSet);
        streetHashSet.add(new Street("s0",2));
    }
}
