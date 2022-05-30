package solution;

import game.*;
import player.*;
/**
 * The Main class provides for defining objects.
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}

