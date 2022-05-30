package dictionary;

import bag.Bag;
import bag.Tile;

import java.io.*;
import java.util.Hashtable;

/**
 * @author Mitrea Ana-Maria
 * @author Ungureanu Diana-Cristina
 * @version 1.32
 * @since 2022-18-21
 */
public class MockDictionary {
    /**
     * Holds a HashTable.
     */
    private Hashtable<String, Integer> dictionary = new Hashtable<>();
    private Bag bag;

    /**
     * Class constructor creating a Bag object.
     */
    public MockDictionary() {
        this.bag = new Bag();
        readFromFile();
    }

    /**
     * This method reads dictionary words from the file.
     */
    public void readFromFile() {
        try {
            File file = new File("words.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                dictionary.put(line.toUpperCase(), getPoints(line));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calculates the score for a word
     */
    public int getPoints(String line) {
        int points = 0;
        StringBuilder sb = new StringBuilder(line);
        for (int index = 0; index < sb.length(); index++) {
            char character = sb.charAt(index);
            for (Tile tile : bag.getLetters()) {
                if (character == tile.getLetter()) {
                    points += tile.getPoints();
                    break;
                }
            }
        }
        return points;
    }

    /**
     * This method tests whether the word exists in the dictionary.
     */
    public boolean isWord(String str) {
        return dictionary.containsKey(str);
    }

    /**
     * This is a method called Getter that is used to get the dictionary.
     *
     * @return Hashtable<String, Integer> This returns a Hashtable<String, Integer> format.
     */
    public Hashtable<String, Integer> getDictionary() {
        return dictionary;
    }

    /**
     * This is a method called Setter that is used to set the dictionary.
     *
     * @param Hashtable<String, Integer> dictionary This is the first parameter to setDictionary() method.
     */
    public void setDictionary(Hashtable<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }
}
