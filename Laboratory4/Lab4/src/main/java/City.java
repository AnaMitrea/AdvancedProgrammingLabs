import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    public Map<Intersection, List<Street>> cityMap;

    public City(List<Street> streetList, List<Intersection> intersections) {
        this.cityMap = new HashMap<>();

        cityMap.put(intersections.get(0), Arrays.asList(streetList.get(0), streetList.get(1), streetList.get(2)));
        cityMap.put(intersections.get(1), Arrays.asList(streetList.get(0), streetList.get(3), streetList.get(4)));
        cityMap.put(intersections.get(2), Arrays.asList(streetList.get(1), streetList.get(4), streetList.get(5), streetList.get(6), streetList.get(7)));
        cityMap.put(intersections.get(3), Arrays.asList(streetList.get(2), streetList.get(7), streetList.get(8)));
        cityMap.put(intersections.get(4), Arrays.asList(streetList.get(3), streetList.get(9), streetList.get(10), streetList.get(11)));
        cityMap.put(intersections.get(5), Arrays.asList(streetList.get(6), streetList.get(8), streetList.get(11), streetList.get(14)));
        cityMap.put(intersections.get(6), Arrays.asList(streetList.get(5), streetList.get(12), streetList.get(13)));
        cityMap.put(intersections.get(7), Arrays.asList(streetList.get(9), streetList.get(12), streetList.get(15)));
        cityMap.put(intersections.get(8), Arrays.asList(streetList.get(10), streetList.get(13), streetList.get(14), streetList.get(15)));

        streetList.get(0).setNrAdjacentStreets(4);
        streetList.get(1).setNrAdjacentStreets(6);
        streetList.get(2).setNrAdjacentStreets(4);
        streetList.get(3).setNrAdjacentStreets(5);
        streetList.get(4).setNrAdjacentStreets(6);
        streetList.get(5).setNrAdjacentStreets(6);
        streetList.get(6).setNrAdjacentStreets(7);
        streetList.get(7).setNrAdjacentStreets(6);
        streetList.get(8).setNrAdjacentStreets(5);
        streetList.get(9).setNrAdjacentStreets(5);
        streetList.get(10).setNrAdjacentStreets(6);
        streetList.get(11).setNrAdjacentStreets(6);
        streetList.get(12).setNrAdjacentStreets(5);
        streetList.get(13).setNrAdjacentStreets(5);
        streetList.get(14).setNrAdjacentStreets(6);
        streetList.get(15).setNrAdjacentStreets(5);
    }

    @Override
    public String toString() {
        return "CityMap: " + cityMap;
    }

    public void filterStream(List<Street> streetList, int length) {
        System.out.println();
        streetList.stream()
                .filter(str -> str.getLength() >= length)
                .filter(str -> str.getNrAdjacentStreets() >= 3)
                .forEach(System.out::println);
    }

}
