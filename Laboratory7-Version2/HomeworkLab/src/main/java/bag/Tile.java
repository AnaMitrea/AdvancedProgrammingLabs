package bag;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Tile {
    /**
     * Holds the letters.
     */
    private final char letter;
    /**
     * Holds the points.
     */
    private final int points;

    /**
     * Class constructor specifying the letters and the points.
     */
    public Tile(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    /**
     * This is a method called Getter that is used to get the letters.
     *
     * @return char This returns a char format.
     */
    public char getLetter() {
        return letter;
    }

    /**
     * This is a method called Getter that is used to get the points.
     *
     * @return int This returns a int format.
     */
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "(" + this.letter + ", " + this.points + ")";
    }
}
