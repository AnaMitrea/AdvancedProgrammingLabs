package algorithm.kruskal;

import graph.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {
    public Map<Intersection, Intersection> root;
    public Map<Intersection, List<Street>> cityMap;

    /**
     * Method used as a constructor which copies the cityMap and initialise the root list.
     * @param cityMap   Initial cityMap to be copied
     */
    public Kruskal(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
        root = new HashMap<Intersection,Intersection>();

        for(Intersection inters : cityMap.keySet()) {
            root.put(inters,inters);
        }
    }

    /**
     * Method used for setting the root of an intersection.
     * @param inters        Key of the root map
     * @param toBetSet      Graph.Intersection value of the root map
     */
    public void setRoot(Intersection inters, Intersection toBetSet) {
        root.put(inters,toBetSet);
    }

    /**
     * Method used for merging two subtrees by using the root map.
     * @param oldRoot   Old root
     * @param newRoot   New Root
     */
    public void union(Intersection oldRoot, Intersection newRoot) {
        for(Intersection inters : cityMap.keySet()) {
            Intersection rootInters = root.get(inters);
            if(rootInters.equals(oldRoot)) {
                setRoot(inters,newRoot);
            }
        }
    }

    /**
     * Method used for finding the two intersections (nodes) which joins a street (edge).
     * @param street        Graph.Street
     * @return              A list of 2 intersections.
     */
    public List<Intersection> findIntersectionsOfStreet(Street street) {
        List<Intersection> intersectionPair = new ArrayList<>(2);
        Intersection firstInters = null;
        Intersection secondInters = null;

        for(Map.Entry<Intersection,List<Street>> entry: cityMap.entrySet()) {
            Intersection inters = entry.getKey();
            List<Street> streets = entry.getValue();

            if(streets.contains(street)) {
                if(firstInters == null) {
                    firstInters = inters;
                }
                else if(secondInters == null) {
                    secondInters = inters;
                }
                else break;
            }
        }

        intersectionPair.add(0,firstInters);
        intersectionPair.add(1,secondInters);
        return intersectionPair;
    }

    /**
     * algorithm.kruskal.Kruskal algorithm which initially uses a sorted list of streets by their cost (street lengths).
     * @param sortedStreets     Sorted list of streets
     * @return                  The list of chosen streets by the algorithm.
     */
    public List<Street> kruskalAlgorithm(List<Street> sortedStreets) {
        List<Street> chosenStreets = new ArrayList<Street>();

        for(Street street : sortedStreets) {
            List<Intersection> intersectionPair = findIntersectionsOfStreet(street);
            if( !root.get(intersectionPair.get(0)).equals(root.get(intersectionPair.get(1))) ) {
                union(root.get(intersectionPair.get(0)), root.get(intersectionPair.get(1)));
                chosenStreets.add(street);
            }
        }
        return chosenStreets;
    }
}
