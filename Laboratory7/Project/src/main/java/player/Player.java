package player;

import game.Game;
import setup.Tile;

import java.util.ArrayList;
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

    public void setName(String name) {
        this.name = name;
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

    public String readWord(List<Tile> extracted) {
        System.out.println("[" + name + "]-Your letters are " + extracted);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Submit word: ");
        return scanner.nextLine();
    }

    public boolean verifySubmitedWord(List<Tile> extracted, String word) {
        StringBuilder sb = new StringBuilder(word);


        return true;
    }


    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        String word = readWord(extracted);

        while(word.equals("") || word.equals(" ")) {
            extracted = game.getBag().extractTiles(7);
            word = readWord(extracted);
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
        while(!game.getGameFinished()) {
            running = true;
            synchronized (game) {
                if(!submitWord()) {
                    game.setGameFinished(true);
                    System.out.println("Game finished!");
                    return;
                }
            }
       }
        running = false;
    }
}
