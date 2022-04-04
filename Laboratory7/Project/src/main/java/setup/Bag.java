package setup;

import game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();
    private final Game game;

    public Bag(Game game) {
        this.game = game;
        for(char c = 'a'; c <= 'z'; c++) {
            for(int counter = 1; counter <= 10; counter++) {
                Random rd = new Random();
                int randomPoint = rd.nextInt(10) + 1;
                Tile tile = new Tile(c,randomPoint);
                letters.add(tile);
            }
        }
        Collections.shuffle(letters);
    }

    //TODO : Each player extracts 7 tiles from the bag
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for(int index = 0; index < howMany; index++) {
            if(letters.isEmpty()) {
                game.setGameFinished(true);
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

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return "Bag(" + letters + ')';
    }
}
