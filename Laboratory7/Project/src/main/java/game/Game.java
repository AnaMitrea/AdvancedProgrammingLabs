package game;

import player.Player;
import setup.Bag;
import setup.Board;
import setup.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag(this);
    private final Board board = new Board(this);
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();
    private boolean gameFinished = false;

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean getGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public void addPlayer(Player player) {
        try {
            if(players.contains(player)) {
                throw new Exception("Player already exists in the game!");
            }
            players.add(player);
            player.setGame(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        List<Thread> threadList = new ArrayList<>();
        for(Player player: players) {
            threadList.add(new Thread(player));
        }
        for(Thread thread : threadList) {
            thread.start();
        }
    }
}
