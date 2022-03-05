import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    private ArrayList<Event> sortedEvents;
    private ArrayList<Room> sortedRooms;

    public Solution() {
        this.sortedEvents = new ArrayList<Event>();
        this.sortedRooms = new ArrayList<Room>();
    }

    public ArrayList<Integer> emptyAvailableRooms(int length) {
        ArrayList<Integer> availableRooms = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            availableRooms.add(-1);
        }
        return availableRooms;
    }

    public void getSolution() {
        ArrayList<Integer> availableRooms = emptyAvailableRooms(sortedRooms.size());

        for(int i = 0; i < sortedEvents.size(); i++) {
            Event event = sortedEvents.get(i);
            for(int j = 0; j < sortedRooms.size(); j++) {
                Room room = sortedRooms.get(j);
                if(room.getRoomType().equals( event.checkEventType() )) { // acelasi tip
                    if(event.getCapacity() <= room.getCapacity()) { //capacitatea eventului nu depaseste capacitatea camerei
                        if(availableRooms.get(j) == -1) {  // e neocupata
                            availableRooms.set(j,event.getEndTime()); // s-a ocupat camera
                            System.out.println(event.getName() + " -> " + room.getName());
                            break;
                        }
                        else {
                            if(availableRooms.get(j) <= event.getStartTime()) { //evenimentele nu se suprapun
                                availableRooms.set(j,event.getEndTime());
                                System.out.println(event.getName() + " -> " + room.getName());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

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

        solution.getSolution();
    }
}
