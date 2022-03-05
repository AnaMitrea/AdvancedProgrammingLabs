import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        if(o1.getStartTime() == o2.getStartTime())
            return 0;
        else if(o1.getStartTime() > o2.getStartTime())
            return 1;
        else
            return -1;
    }
}
