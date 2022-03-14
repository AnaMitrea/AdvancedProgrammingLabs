import java.util.*;
import java.util.stream.IntStream;

public class Compulsory {
    public static void main(String[] args) {
        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);

        List<Street> streetList = new LinkedList<>();
        for(int i = 0; i < 15; i++) {
            streetList.add(new Street("s" + i, new Random().nextInt((3 - 1) + 1) + 1));
        }
        System.out.println("Unsorted streetList: " + streetList);

        List<Street> sortedStreetList = new LinkedList<>(streetList);
        sortedStreetList.sort(((u, v) -> u.getLength().compareTo(v.getLength())));
        System.out.println("\nSorted streetList: " + sortedStreetList);

        Set<Street> streetHashSet = new HashSet<>(sortedStreetList);
        System.out.println("\nStreet set: " + streetHashSet);
    }
}
