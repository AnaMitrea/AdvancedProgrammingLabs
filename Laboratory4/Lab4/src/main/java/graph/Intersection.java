package graph;

import java.util.Objects;

public class Intersection {
    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inters(" + name + ")";
    }

    /**
     * Method used for eliminating the possibility to add duplicates by comparing their name and the hash codes.
     * @param o     The object to be compared.
     * @return      A boolean value, true/false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Method used for returning the hash code.
     * @return      Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
