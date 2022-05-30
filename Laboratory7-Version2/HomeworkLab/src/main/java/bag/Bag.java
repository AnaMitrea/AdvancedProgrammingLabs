package bag;

import java.util.*;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Bag {
    /**
     * Keep a list of letters drawn by each player.
     */
    private final List<Tile> letters = new ArrayList<>();

    /**
     * Class constructor set the letters.
     */
    public Bag() {
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'A') {
                for (int index = 0; index < 9; index++) {
                    letters.add(new Tile('A', 1));
                }
            }
            if (c == 'B') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('B', 3));
                }
            }
            if (c == 'C') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('C', 3));
                }
            }
            if (c == 'D') {
                for (int index = 0; index < 4; index++) {
                    letters.add(new Tile('D', 2));
                }
            }
            if (c == 'E') {
                for (int index = 0; index < 12; index++) {
                    letters.add(new Tile('E', 1));
                }
            }
            if (c == 'F') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('F', 4));
                }
            }
            if (c == 'G') {
                for (int index = 0; index < 3; index++) {
                    letters.add(new Tile('G', 2));
                }
            }
            if (c == 'H') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('H', 4));
                }
            }
            if (c == 'I') {
                for (int index = 0; index < 9; index++) {
                    letters.add(new Tile('I', 1));
                }
            }
            if (c == 'J') {
                for (int index = 0; index < 1; index++) {
                    letters.add(new Tile('J', 8));
                }
            }
            if (c == 'K') {
                for (int index = 0; index < 1; index++) {
                    letters.add(new Tile('K', 5));
                }
            }
            if (c == 'L') {
                for (int index = 0; index < 4; index++) {
                    letters.add(new Tile('L', 1));
                }
            }
            if (c == 'M') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('M', 3));
                }
            }
            if (c == 'N') {
                for (int index = 0; index < 6; index++) {
                    letters.add(new Tile('N', 1));
                }
            }
            if (c == 'O') {
                for (int index = 0; index < 8; index++) {
                    letters.add(new Tile('O', 1));
                }
            }
            if (c == 'P') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('P', 3));
                }
            }
            if (c == 'Q') {
                for (int index = 0; index < 1; index++) {
                    letters.add(new Tile('Q', 10));
                }
            }
            if (c == 'R') {
                for (int index = 0; index < 6; index++) {
                    letters.add(new Tile('R', 1));
                }
            }
            if (c == 'S') {
                for (int index = 0; index < 4; index++) {
                    letters.add(new Tile('S', 1));
                }
            }
            if (c == 'T') {
                for (int index = 0; index < 6; index++) {
                    letters.add(new Tile('T', 1));
                }
            }
            if (c == 'U') {
                for (int index = 0; index < 4; index++) {
                    letters.add(new Tile('U', 1));
                }
            }
            if (c == 'V') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('V', 4));
                }
            }
            if (c == 'W') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('W', 4));
                }
            }
            if (c == 'X') {
                for (int index = 0; index < 1; index++) {
                    letters.add(new Tile('X', 8));
                }
            }
            if (c == 'Y') {
                for (int index = 0; index < 2; index++) {
                    letters.add(new Tile('Y', 4));
                }
            }
            if (c == 'Z') {
                for (int index = 0; index < 1; index++) {
                    letters.add(new Tile('Z', 10));
                }
            }
        }
        Collections.shuffle(letters);
    }

    /**
     * This method draws the letters for each player
     */
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int index = 0; index < howMany; index++) {
            if (letters.isEmpty()) {
                break;
            }
            Random rd = new Random();
            int randomIndex = rd.nextInt(letters.size());

            extracted.add(letters.get(randomIndex));
            letters.remove(randomIndex);
        }
        System.out.println("Remains " + letters.size() + " after extraction.");
        return extracted;
    }

    public List<Tile> getLetters() {
        return letters;
    }
}
