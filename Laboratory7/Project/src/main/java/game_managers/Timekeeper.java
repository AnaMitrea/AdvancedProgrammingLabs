package game_managers;

public class Timekeeper extends Thread{
    int timeToExist;

    public Timekeeper(int timeInSeconds) {
        this.timeToExist = timeInSeconds;
    }

    @Override
    public void run() {
        while (timeToExist > 0) {
            try {
                Thread.sleep(1000);
                timeToExist--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("timekeeper over");
    }

    public boolean isOver() {
        return timeToExist <= 0;
    }
}
