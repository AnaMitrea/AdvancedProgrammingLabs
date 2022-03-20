public class Street {
    private String name;
    private int length;
    private int nrAdjacentStreets;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
        this.nrAdjacentStreets = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNrAdjacentStreets() {
        return nrAdjacentStreets;
    }

    public void setNrAdjacentStreets(int nrAdjacentStreets) {
        this.nrAdjacentStreets = nrAdjacentStreets;
    }

    @Override
    public String toString() {
        return "St(" + name + ", " + length +  "km)";
    }
}
