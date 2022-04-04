package setup;

import game.Game;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> words = new ArrayList<>();
    private final Game game;

    public Board(Game game) {
        game.setGameFinished(false);
        this.game = game;
    }

    public List<String> getWords() {
        return words;
    }

    public Game getGame() {
        return game;
    }

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
