import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bag {
    private final String letters = null;

    public Bag() {
      /* for (char c = 'a'; c < 'z'; c++) {

        }

       */
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            // extracted.add(poll one tile from the collection);
        }
        return extracted;
    }

}
