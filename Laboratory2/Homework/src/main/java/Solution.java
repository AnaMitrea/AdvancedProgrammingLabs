import event.Event;
import event.EventComparator;
import room.Room;
import room.RoomComparator;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Event> sortedEvents;
    private ArrayList<Room> sortedRooms;

    public Solution() {
        this.sortedEvents = new ArrayList<Event>();
        this.sortedRooms = new ArrayList<Room>();
    }

    /**
     * Method used to initialize an array list which contains whether a room.Room object is available or not for using it.
     *
     * @param length    The number of existing rooms.
     * @return          The array list containing only -1 values.
     */
    public ArrayList<Integer> emptyAvailableRooms(int length) {
        ArrayList<Integer> availableRooms = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            availableRooms.add(-1);
        }
        return availableRooms;
    }

    /**
     * Method used for creating a feasible solution to the problem, "trying" to minimize the number of used rooms.
     * The method uses a sorted event list and iterates through it, searching for an available room for the current event.
     *
     * Available room means:
     * -> array list, availableRooms, has '-1' on the searched index
     *      or
     * -> the ending time of the last event is less than or equal to the starting time of the current event.
     * - room type and event type are equal. (C events in room.Lecture halls and L events in Lab rooms).
     * - the capacity of current event is less than or equal to the capacity of the room.
     */
    public void getSolution() {
        ArrayList<Integer> availableRooms = emptyAvailableRooms(sortedRooms.size());

        for(int indexEvent = 0; indexEvent < sortedEvents.size(); indexEvent++) {
            Event event = sortedEvents.get(indexEvent);

            for(int indexRoom = 0; indexRoom < sortedRooms.size(); indexRoom++) {
                Room room = sortedRooms.get(indexRoom);

                if(room.getRoomType().equals( event.checkEventType() )) {
                    if(event.getCapacity() <= room.getCapacity()) {
                        if(availableRooms.get(indexRoom) == -1) {
                            availableRooms.set(indexRoom,event.getEndTime());
                            System.out.println(event.getName() + " -> " + room.getName());
                            break;
                        }
                        else {
                            if(availableRooms.get(indexRoom) <= event.getStartTime()) {
                                availableRooms.set(indexRoom,event.getEndTime());
                                System.out.println(event.getName() + " -> " + room.getName());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Main method which contains the solution of the problem.
     *
     * @param args  The arguments.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        Problem problem = new Problem();
        solution.sortedEvents = problem.getArrayListEvent();

        solution.sortedEvents.sort(new EventComparator());
        System.out.println("\nSorted events by starting time:");
        System.out.println(solution.sortedEvents.toString());

        solution.sortedRooms = problem.getArrayListRoom();
        solution.sortedRooms.sort(new RoomComparator());
        System.out.println("\nSorted rooms by capacity:");
        System.out.println(solution.sortedRooms.toString());

        System.out.println("\nSolution:");
        solution.getSolution();
    }
}