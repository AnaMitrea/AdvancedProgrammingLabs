package game;

import player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Board {
    /**
     * Keep a list of strings.
     */
    private final List<String> words = new ArrayList<>();

    /**
     * This method adds the words formed to the list.
     *
     * @param player
     * @param word
     */
    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    /**
     * String conversion.
     *
     * @return String This returns a String format.
     */
    @Override
    public String toString() {
        return words.toString();
    }
}
