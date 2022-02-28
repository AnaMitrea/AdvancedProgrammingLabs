import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Homework myObj = new Homework();

        long startTime = System.nanoTime();

        if (!myObj.validateInput(args))
        {
            System.out.println("Invalid arguments.");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]); // n words
        int p = Integer.parseInt(args[1]); // p characters in each word

        String[] givenLetters = Arrays.copyOfRange(args, 2,args.length);  // copying args[2]-args[length] to givenLetters
        myObj.printGivenWords(givenLetters);

        ArrayList<String> wordsString = myObj.createWords(n, p, givenLetters);
        boolean[][] matrixOfNeighbors = myObj.createMatrixOfNeighbors(wordsString);
        ArrayList<ArrayList<String>> neighborList = myObj.createNeighborList(wordsString, matrixOfNeighbors);

        if (n <= 30_000) {
            myObj.printHomework(wordsString,matrixOfNeighbors,neighborList);
            myObj.printBonus(wordsString);
        }
        else
        {
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time in nanoseconds: " + timeElapsed);
        }
    }
}
