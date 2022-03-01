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

    @Override
    public String toString() {
        return this.getName() + '(' +
                "cap=" + this.getCapacity() +
                ", " + this.getRoomType() +
                ", " + this.getOperatingSystem() + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Laboratory)) return false;
        Laboratory laboratory = (Laboratory)obj;
        return (this.getName() == laboratory.getName());
    }
}
