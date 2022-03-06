public class Laboratory extends Room{
    private String operatingSystem;

    public Laboratory(String name, int capacity, String operatingSystem) {
        this.name = name;
        this.capacity = capacity;
        this.roomType = "Lab";
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Method used to display an object.
     *
     * @return  A string representation of the object.
     */
    @Override
    public String toString() {
        return this.getName() + '(' +
                "cap=" + this.getCapacity() +
                ", " + this.getRoomType() +
                ", " + this.getOperatingSystem() + ')';
    }

    /**
     * Overrode method used for comparing two Laboratory objects by their name.
     *
     * @param obj   The object used for comparing.
     * @return      True or false whether the objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Laboratory)) return false;
        Laboratory laboratory = (Laboratory)obj;
        return (this.getName().equals(laboratory.getName()));
    }
}