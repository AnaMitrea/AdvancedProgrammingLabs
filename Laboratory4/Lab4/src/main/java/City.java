import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public void createCityMap(List<Street> streetList, List<Intersection> intersections) {
        cityMap.put(intersections.get(0), Arrays.asList(streetList.get(0), streetList.get(1), streetList.get(2)));
        cityMap.put(intersections.get(1), Arrays.asList(streetList.get(0), streetList.get(3), streetList.get(4)));
        cityMap.put(intersections.get(2), Arrays.asList(streetList.get(1), streetList.get(4), streetList.get(5), streetList.get(6), streetList.get(7)));
        cityMap.put(intersections.get(3), Arrays.asList(streetList.get(2), streetList.get(7), streetList.get(8)));
        cityMap.put(intersections.get(4), Arrays.asList(streetList.get(3), streetList.get(9), streetList.get(10), streetList.get(11)));
        cityMap.put(intersections.get(5), Arrays.asList(streetList.get(6), streetList.get(8), streetList.get(11), streetList.get(14)));
        cityMap.put(intersections.get(6), Arrays.asList(streetList.get(5), streetList.get(12), streetList.get(13)));
        cityMap.put(intersections.get(7), Arrays.asList(streetList.get(9), streetList.get(12), streetList.get(15)));
        cityMap.put(intersections.get(8), Arrays.asList(streetList.get(10), streetList.get(13), streetList.get(14), streetList.get(15)));
    }

    @Override
    public String toString() {
        return "CityMap: " + cityMap;
    }
}
