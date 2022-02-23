import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Homework {
	
	public static boolean isNumber(String input) {
		try {
			@SuppressWarnings("unused")
			int number = Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException excep) {
			System.out.print(" - Input string isn't an integer.");
		}
		return false;
	}
	
	public static boolean isCharacter(char input) {
		if ((input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z')) {
			return true;
		}
		return false;
	}
	
	public static boolean validateInput(String[] input) {
		if (isNumber(input[0]) == false || isNumber(input[1]) == false)
			return false;
		for (int i = 2; i < input.length; i++) {
			if (input[i].length() > 1 ) // if input[i] has more than 1 characters
				return false;
			
			if (isCharacter(input[i].charAt(0)) == false) // if input[i] is an alphabet letter
				return false;
		}
		return true;
	}
	
	
	public static String[] createWords(int numberOfWords, int lengthOfWords, String[] givenLetters) {
		String[] wordsString = new String[numberOfWords];
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[lengthOfWords];
			
			//System.out.println("i = " + i + ":");
			for (int j = 0; j < word.length; j++) {
				Random r = new Random();
				int randomIndex = r.nextInt(givenLetters.length);
				//System.out.print("RandomIndex= " + randomIndex + " ; ");
				
				word[j] = givenLetters[randomIndex].charAt(0);
			}
			//System.out.print("\n");
			wordsString[i] = new String(word);
		}
		
		return wordsString;
	}
	
	public static void printWords(String[] wordsString) {
		System.out.print("\nGenerated string of words: ");
		for (int i = 0; i < wordsString.length; i++) {
			System.out.print(wordsString[i] + " ");
		}
	}
	
	
	public static boolean checkNeighborWords(String wordOne, String wordTwo) {
		for (int i = 0; i < wordOne.length(); i++) {
			char letter = wordOne.charAt(i);
			for (int j = 0; j < wordTwo.length(); j++) {
				if (letter == wordTwo.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean[][] createMatrixOfNeighbors(String[] wordsString) {
		int stringLength = wordsString.length;
		boolean[][] matrixOfNeighbors = new boolean[stringLength][stringLength];
		
		for (int i = 0; i < stringLength; i++) {
			for (int j = 0; j < stringLength; j++) {
				if (i == j) {
					matrixOfNeighbors[i][j] = true;
				}
				else {
					if (checkNeighborWords(wordsString[i], wordsString[j]) == true)
						matrixOfNeighbors[i][j] = true;
					else
						matrixOfNeighbors[i][j] = false;
				}
			}
		}
		return matrixOfNeighbors;
	}
	
	public static void printMatrix(boolean[][] matrixOfNeighbors) {
		int matrixLength = matrixOfNeighbors.length;
		
		System.out.println("\n\nChecking for neighbors...");
		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				System.out.print(matrixOfNeighbors[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static ArrayList<ArrayList<String>> createNeighborList(String[] wordsString, boolean[][] matrixOfNeighbors) {
		ArrayList<ArrayList<String>> neighborList = new ArrayList<ArrayList<String>>();
		int n = wordsString.length;
		
		for (int i = 0; i < n; i++) {
			ArrayList<String> listForEachWord = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				if (matrixOfNeighbors[i][j] == true && i != j) {
					listForEachWord.add(wordsString[j]);
				}
			}
			neighborList.add(listForEachWord);
		}
		
		return neighborList;
	}
	

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument " + i + " : " + args[i]);
		}
		
		if (validateInput(args) == true)
		{
			int n = Integer.parseInt(args[0]); // n words
			int p = Integer.parseInt(args[1]); // p characters in each word
			System.out.println("n = " + n + " and p = " + p);
			
			String[] givenLetters = Arrays.copyOfRange(args, 2,args.length);  // copying args[2]-args[length] to givenLetters
			System.out.print("Given letters: ");
			for (int i = 0; i < givenLetters.length; i++) {
				System.out.print(givenLetters[i] + " ");
			}
			System.out.println();
			
			String[] wordsString = createWords(n, p, givenLetters);		
			boolean[][] matrixOfNeighbors = createMatrixOfNeighbors(wordsString);
					
			ArrayList<ArrayList<String>> neighborList = createNeighborList(wordsString, matrixOfNeighbors);
			
			
			if (n <= 30_000) {
				printWords(wordsString);
				printMatrix(matrixOfNeighbors);
				System.out.println("List: " + neighborList);
			}
			
		}
		else {
			System.out.println("Invalid arguments.");
		}
		
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
	}

}
