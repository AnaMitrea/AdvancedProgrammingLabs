import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
	
    public Player(String name) { this.name = name; }

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

        if(!(word.equals("") || word.equals(" "))) {
            game.getBoard().addWord(this, word);
            StringBuilder sb = new StringBuilder(word);

            for(int counter = 0; counter < sb.length(); counter++) {
                for(Tile tile : extracted) {
                    if(tile.getLetter() == sb.charAt(counter)) {
                        extracted.remove(tile);
                        break;
                    }
                }
            }
            extracted.addAll(game.getBag().extractTiles(sb.length()));
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
	
    @Override
    public void run() {
        boolean running = true;

        synchronized (game) {
            running = submitWord();
        }
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
}
