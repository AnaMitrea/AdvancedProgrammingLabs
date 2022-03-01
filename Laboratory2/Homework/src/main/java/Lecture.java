public class Lecture extends Room{
    private boolean videoProjector;

    public Lecture(String name, int capacity, boolean videoProjector) {
        this.name = name;
        this.capacity = capacity;
        this.roomType = "Lecture Hall";
        this.videoProjector = videoProjector;
    }

    public boolean getVideoProjector() {
        return videoProjector;
    }

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    @Override
    public String toString() {
        return this.getName() + '(' +
                "cap=" + this.getCapacity() +
                ", " + this.getRoomType() +
                ", " +  " Has video projector: " +
                this.getVideoProjector() + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Lecture)) return false;
        Lecture lecture = (Lecture)obj;
        return (this.getName() == lecture.getName());
    }
}
