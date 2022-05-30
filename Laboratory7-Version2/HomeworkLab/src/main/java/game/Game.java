package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import game.timekeeper.TimeKeeper;
import player.*;
import bag.*;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Game {
    /**
     * Holds the Bag object.
     */
    private final Bag bag = new Bag();
    /**
     * Holds the Board object.
     */
    private final Board board = new Board();
    /**
     * Keep a list of players.
     */
    private final List<Player> players = new ArrayList<>();
    /**
     * Holds a variable used for thread.
     */
    private boolean gameFinished = false;
    /**
     * Holds a variable used for thread.
     */
    private int currentTurn = 0;

    /**
     * This method adds players to the game.
     *
     * @param player This is the first parameter to addPlayer() method.
     */
    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            player.setGame(this);
            player.setExtracted(this.bag.extractTiles(7));
        } else {
            System.out.println("Player " + player.getName() + "already in game.");
        }
    }

    /**
     * The method used to create the threads.
     */
    public void play() {
        TimeKeeper timeKeeper = new TimeKeeper(this);
        Thread tkThread = new Thread(timeKeeper);
        tkThread.start();

        for (Player player : players) {
            Thread t1 = new Thread(player);
            t1.start();
        }

    }

    /**
     * The method used to display the winner.
     */
    public void showWinner() {
        System.out.println(players);
        players.sort(Comparator.comparingInt(Player::getScore));
        System.out.println(players);

        System.out.println("The winner is " + players.get(0).getName() + " having " + players.get(0).getScore() + "!");
        for (int index = 1; index < players.size(); index++) {
            System.out.println(players.get(index).getName() + " score: " + players.get(index).getScore());
        }
    }

    /**
     * This is a method called Getter that is used to get a Bag object.
     *
     * @return Bag This returns a Bag format.
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * This is a method called Getter that is used to get a Board object.
     *
     * @return Board This returns a Board format.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * This is a method called Getter that is used to get the players.
     *
     * @return List<Player>This returns a List<Player> format.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * This is a method called Getter that is used to get the gameFinished.
     *
     * @return boolean This returns a boolean format.
     */
    public boolean getGameFinished() {
        return gameFinished;
    }

    /**
     * This is a method called Setter that is used to set the gameFinished.
     *
     * @param gameFinished This is the first parameter to setGameFinished() method.
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    /**
     * This is a method called Getter that is used to get the turn.
     *
     * @return int This returns an int format.
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * This is a method called Setter that is used to set the currentTurn.
     *
     * @param currentTurn This is the first parameter to setCurrentTurn() method.
     */
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }
}
