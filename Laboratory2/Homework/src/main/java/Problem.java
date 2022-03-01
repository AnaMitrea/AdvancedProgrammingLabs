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

        System.out.print("Rooms: ");
        for(Room room : problem.roomsList) {
            System.out.print(room.toString());
            System.out.print(" ");
        }

    }
}
