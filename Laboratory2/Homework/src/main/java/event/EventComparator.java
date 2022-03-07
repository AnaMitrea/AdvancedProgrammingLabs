package event;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {
    /**
     * Method used as a comparator for Collection class. It compares two event.Event objects by their start time.
     *
     * @param o1    First object.
     * @param o2    Second object.
     * @return      0, if start time are equal; 1, if first object starts later; -1, if first object starts earlier.
     */
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
