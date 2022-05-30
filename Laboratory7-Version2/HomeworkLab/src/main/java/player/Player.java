package player;

import bag.Tile;
import dictionary.MockDictionary;
import game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Player implements Runnable {
    /**
     * Holds the name of the player.
     */
    private String name;
    /**
     * Holds a Game object.
     */
    private Game game;
    /**
     * Holds a MockDictionary object.
     */
    private MockDictionary mockDictionary;
    /**
     * Holds a variable used for thread.
     */
    private boolean running;
    /**
     * Keep the score for each player.
     */
    private int score;
    /**
     * Keep a list of letters drawn by each player.
     */
    private List<Tile> extracted;

    /**
     * Class constructor specifying the name of the player,the score, the list of letters.
     */
    public Player(String name) {
        this.extracted = new ArrayList<>();
        this.name = name;
        this.score = 0;
        this.mockDictionary = new MockDictionary();
    }

    /**
     * By this method the player enters the word from the keyboard
     *
     * @return String This returns a String format.
     */
    public String readWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Submit word: ");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * By this method the player submit the word .
     *
     * @return boolean This returns a boolean format.
     */
    private boolean submitWord() {
        boolean condition = true;
        if (extracted.isEmpty()) {
            game.setGameFinished(true);
            return false;
        }
        List<Tile> copyOfExtracted = new ArrayList<>(extracted);

        System.out.println("[" + name + "]-Your letters are " + extracted);
        String word = readWord();
        StringBuilder newWord = new StringBuilder(word);

        for (int index = 0; index < newWord.length(); index++) {
            boolean ok = false;

            for (Tile tile : extracted) {
                char character = newWord.charAt(index);
                character = Character.toUpperCase(character);
                if (tile.getLetter() == character) {
                    ok = true;
                    extracted.remove(tile);
                    break;
                }
            }
            if (!ok) {
                System.out.println("Invalid letter.");
                condition = false;
                break;
            }
        }

        if (condition) {
            if (!word.equals("") && !word.equals(" ")) {
                if (mockDictionary.isWord(word)) {
                    game.getBoard().addWord(this, word);
                    this.score = score + mockDictionary.getDictionary().get(word);
                    System.out.println("\n" + name + " submitted " + word + ".\n");
                }
                List<Tile> newExtracted = game.getBag().extractTiles(word.length());
                if (newExtracted.isEmpty()) {
                    game.setGameFinished(true);
                    return false;
                }

                extracted.addAll(newExtracted);
            } else {
                game.getBag().getLetters().addAll(copyOfExtracted);
                this.extracted = game.getBag().extractTiles(7);
                if (extracted.isEmpty()) {
                    game.setGameFinished(true);
                    return false;
                }
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * By this method the player waits for his turn.
     *
     * @param indexPlayer This is the first parameter to waitTurn() method.
     */
    public void waitTurn(int indexPlayer) {
        synchronized (game) {
            game.notifyAll();
            while (game.getCurrentTurn() != indexPlayer && game.getCurrentTurn() != -1) {
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * The method used to synchronize players.
     */
    @Override
    public void run() {
        boolean running = true;

        int indexPlayer = game.getPlayers().indexOf(this);

        while (running) {
            waitTurn(indexPlayer);
            if (game.getCurrentTurn() == -1) {
                running = false;
            } else {
                running = submitWord();
            }

            int currentTurn = game.getCurrentTurn();
            currentTurn = (currentTurn + 1) % game.getPlayers().size();
            game.setCurrentTurn(currentTurn);
        }
    }

    /**
     * This is a method called Getter that is used to get the name.
     *
     * @return String This returns a String format.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a method called Setter that is used to set the Game.
     *
     * @param game This is the first parameter to setGame() method.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * This is a method called Getter that is used to get the running.
     *
     * @return boolean This returns a boolean format.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * This is a method called Setter that is used to set the running.
     *
     * @param running This is the first parameter to setRunning() method.
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * This is a method called Getter that is used to get the score.
     *
     * @return int This returns a int format.
     */
    public int getScore() {
        return score;
    }

    /**
     * This is a method called Setter that is used to set the score.
     *
     * @param score This is the first parameter to setScore() method.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * This is a method called Getter that is used to get the dictionary.
     *
     * @return MockDictionary This returns a MockDictionary format.
     */
    public MockDictionary getMockDictionary() {
        return mockDictionary;
    }

    /**
     * This is a method called Setter that is used to set the dictionary..
     *
     * @param mockDictionary This is the first parameter to setMockDictionary method.
     */
    public void setMockDictionary(MockDictionary mockDictionary) {
        this.mockDictionary = mockDictionary;
    }

    /**
     * This is a method called Getter that is used to get the extractedList.
     *
     * @return List<Tile> This returns a List<Tile> format.
     */
    public List<Tile> getExtracted() {
        return extracted;
    }

    /**
     * This is a method called Setter that is used to set the extracted.
     *
     * @param extracted This is the first parameter to setExtracted() method.
     */
    public void setExtracted(List<Tile> extracted) {
        this.extracted = extracted;
    }
}
