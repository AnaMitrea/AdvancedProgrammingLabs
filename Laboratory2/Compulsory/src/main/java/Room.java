public class Room {
    private String name;
    private int capacity;
    private Type propertyType;

    public Room(String name, int capacity, Type propertyType) {
        this.name = name;
        this.capacity = capacity;
        this.propertyType = propertyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Type propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return  name + '(' +
                "cap=" + capacity +
                ')';
    }
}
