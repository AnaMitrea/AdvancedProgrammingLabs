import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {

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
