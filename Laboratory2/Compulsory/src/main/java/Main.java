import java.util.ArrayList;

public class Main {
    public static ArrayList<Room> createRooms(ArrayList<Room> rooms) {
        Room room1 = new Room("401",30,Type.Laboratory);
        Room room2 = new Room("403",30,Type.Laboratory);
        Room room3 = new Room("405",30,Type.Laboratory);
        Room room4 = new Room("309",100,Type.Course);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        return rooms;
    }

    public static ArrayList<Event> createEvents(ArrayList<Event> events) {
        Event event1 = new Event("C1",100,8,10);
        Event event2 = new Event("C2",100,10,12);
        Event event3 = new Event("L1",30,8,10);
        Event event4 = new Event("L2",100,8,10);
        Event event5 = new Event("L3",100,10,12);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
        return events;
    }

    public static void printRooms(ArrayList<Room> rooms) {
        System.out.print("Rooms: ");
        for(Room room : rooms) {
            System.out.print(room.toString() + " ");
        }
        System.out.println();
    }

    public static void printEvents(ArrayList<Event> events) {
        System.out.print("Events: ");
        for(Event event : events) {
            System.out.print(event.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Room> rooms= new ArrayList<Room>();
        rooms = createRooms(rooms);
        printRooms(rooms);

        ArrayList<Event> events = new ArrayList<Event>();
        events = createEvents(events);
        printEvents(events);
    }
}