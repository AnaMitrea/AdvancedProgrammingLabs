import java.util.ArrayList;

public class Problem {
    public ArrayList<Room> roomsList;
    public ArrayList<Event> eventsList;


    public void addRoom(Room obj) {
        for(Room room : roomsList) {
            if(room.equals(obj)) {
                System.out.println("Can't add room " + obj.getName());
                return;
            }
        }
        roomsList.add(obj);
        System.out.println("Added room " + obj.getName());
    }

    public void addEvent(Event obj) {
        for(Event event : eventsList) {
            if(event.equals(obj)) {
                System.out.println("Can't add event " + obj.getName());
                return;
            }
        }
        eventsList.add(obj);
        System.out.println("Added event " + obj.getName());
    }

    public void printRooms() {
        System.out.print("Rooms: ");
        for(Room room : roomsList) {
            System.out.print(room.toString());
            System.out.print(" ");
        }
    }

    public void printEvents() {
        System.out.print("Events: ");
        for(Event event : eventsList) {
            System.out.print(event.toString());
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.roomsList = new ArrayList<Room>();
        problem.eventsList = new ArrayList<Event>();

        Room room1 = new Laboratory("401",30,"Linux");
        Room room2 = new Laboratory("403",30,"Windows 10");
        Room room3 = new Laboratory("405",30,"Windows 7");
        Room room4 = new Lecture("309",100,true);

        problem.addRoom(room1);
        problem.addRoom(room2);
        problem.addRoom(room3);
        problem.addRoom(room4);

        problem.printRooms();

        Event event1 = new Event("C1",100,8,10);
        Event event2 = new Event("C2",100,10,12);
        Event event3 = new Event("L1",30,8,10);
        Event event4 = new Event("L2",100,8,10);
        Event event5 = new Event("L3",100,10,12);

        problem.addEvent(event1);
        problem.addEvent(event2);
        problem.addEvent(event3);
        problem.addEvent(event4);
        problem.addEvent(event5);

        problem.printEvents();
    }
}
