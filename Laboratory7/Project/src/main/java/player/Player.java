package player;

import game.Game;
import setup.Tile;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String readWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Submit word: ");
        return scanner.nextLine();
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        System.out.println("[" + name + "]-Your letters are " + extracted);
        String word = readWord();

        while(word.equals("") || word.equals(" ")) {
            extracted = game.getBag().extractTiles(7);

            System.out.println("[" + name + "]-Your letters are " + extracted);
            word = readWord();

            if (extracted.isEmpty()) {
                game.setGameFinished(true);
                return false;
            }
        }
        game.getBoard().addWord(this, word);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void run() {
        running = true;

        synchronized (game) {
            submitWord();
        }

        running = false;
    }
}
