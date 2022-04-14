import java.util.*;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            for (int index = 1; index <= 10; index++) {
                try {
                    Random rd = new Random();
                    int randomPoint = rd.nextInt(10) + 1;
                    Tile tile = new Tile(c, randomPoint);
                    letters.add(tile);
                } catch (IllegalStateException e) {
                    System.out.println("Element can't be added due to capacity restrictions");
                }
            }
        }
        Collections.shuffle(letters);
    }

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
        //System.out.println("Remains " + letters.size() + " after extraction.");
        return extracted;
    }

    public List<Tile> getLetters() {
        return letters;
    }
}
