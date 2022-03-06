import java.util.ArrayList;

public class Problem {
    private ArrayList<Room> roomsList;
    private ArrayList<Event> eventsList;

    /**
     * Method used to add Room objects to a list.
     * Adding an object is possible only if the object doesn't already exist in the list.
     *
     * @param obj   Room object to be added in the list.
     */
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

    /**
     * Method used to add Event object to a list.
     * Adding an object is possible only if the object doesn't already exist in the list.
     * 
     * @param obj   Event object to be added in the list.
     */
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
        System.out.println();
    }

    public void printEvents() {
        System.out.print("Events: ");
        for(Event event : eventsList) {
            System.out.print(event.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public ArrayList<Room> getArrayListRoom() {
        return this.roomsList;
    }

    public ArrayList<Event> getArrayListEvent() {
        return this.eventsList;
    }

    /**
     * Method used as a constructor which shows how an instance of a problem looks.
     */
    public Problem() {
        System.out.println("Created an instance.");
        this.roomsList = new ArrayList<Room>();
        this.eventsList = new ArrayList<Event>();

        Room room1 = new Laboratory("401",30,"Linux");
        Room room2 = new Laboratory("403",30,"Windows 10");
        Room room3 = new Laboratory("405",30,"Windows 7");
        Room room4 = new Lecture("309",100,true);

        this.addRoom(room1);
        this.addRoom(room2);
        this.addRoom(room3);
        this.addRoom(room4);

        Event event1 = new Event("C1",100,8,10);
        Event event2 = new Event("C2",100,10,12);
        Event event3 = new Event("L1",30,8,10);
        Event event4 = new Event("L2",30,8,10);
        Event event5 = new Event("L3",30,10,12);

        this.addEvent(event1);
        this.addEvent(event2);
        this.addEvent(event3);
        this.addEvent(event4);
        this.addEvent(event5);
    }
}
