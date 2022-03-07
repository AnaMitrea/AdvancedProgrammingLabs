package room;

public abstract class Room {
    protected String name;
    protected int capacity;
    protected String roomType;

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getCapacity();

    public abstract void setCapacity(int capacity);

    public abstract String getRoomType();

    public abstract void setRoomType(String roomType);
}
