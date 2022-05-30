package game.timekeeper;

import game.Game;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class TimeKeeper implements Runnable {
    /**
     * Holds a Game object.
     */
    private final Game game;

    /**
     * Class constructor specifying the game object.
     */
    public TimeKeeper(Game game) {
        this.game = game;
    }

    /**
     * The method used to elapse the time in the game.
     */
    @Override
    public void run() {
        long start = System.nanoTime();
        while (true) {
            long end = System.nanoTime();

            long elapsedTime = (end - start) / 1_000_000_000;

            if (game.getGameFinished()) {
                System.out.println("Game duration: " + elapsedTime + " seconds");
                return;
            }

            if (elapsedTime > 10) {
                System.out.println("\nTime Limit Exceeded - 30 seconds");
                break;
            }

        }
        System.exit(0);
    }
}