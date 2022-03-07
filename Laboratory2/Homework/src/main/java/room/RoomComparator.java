package room;

import room.Room;

import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {
    /**
     * Method used as a comparator for Collection class. It compares two room.Room objects by their maximum capacity.
     *
     * @param o1    First object.
     * @param o2    Second object.
     * @return      0, if capacities are equal; 1, if first object has bigger capacity; -1, if second object has bigger capacity.
     */
    @Override
    public int compare(Room o1, Room o2) {
        if(o1.getCapacity() == o2.getCapacity())
            return 0;
        else if(o1.getCapacity() > o2.getCapacity())
            return 1;
        else
            return -1;
    }
}
