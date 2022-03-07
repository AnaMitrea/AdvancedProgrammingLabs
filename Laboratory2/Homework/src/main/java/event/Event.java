package event;

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
        return  this.name;
    }

    public int getCapacity() {
        return  this.capacity;
    }

    public int getStartTime() {
        return  this.startTime;
    }

    public int getEndTime() {
        return  this.endTime;
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

    /**
     * Method used to display an object.
     *
     * @return  A string representation of the object.
     */
    @Override
    public String toString() {
        return  this.getName() + "(" +
                "size=" +  this.getCapacity() +
                ", start=" +  this.getStartTime() +
                ", end=" +  this.getEndTime() +
                ')';
    }

    /**
     * Method used for checking the type of event.Event object.
     *
     * @return  A string containing the type (room.Lecture Hall or room.Laboratory).
     */
    public String checkEventType() {
        if(this.getName().charAt(0) ==  'C') {
            return "room.Lecture Hall";
        }
        else
            return "Lab";
    }
}
