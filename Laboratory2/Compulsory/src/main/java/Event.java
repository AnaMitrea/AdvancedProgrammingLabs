public class Event {
    private String name;
    private int capacity;
    private int startTime;
    private int endTime;

    public Event(String name, int capacity, int startTime, int endTime) {
        this.name = name;
        this.capacity = capacity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Events: " +
                name + "(" +
                "size=" + capacity +
                ", start=" + startTime +
                ", end=" + endTime +
                ')';
    }
}
