import java.util.Arrays;
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
			
			System.out.println("i = " + i + ":");
			for (int j = 0; j < word.length; j++) {
				Random r = new Random();
				int randomIndex = r.nextInt(givenLetters.length);
				
				System.out.print("RandomIndex= " + randomIndex + " ; ");
				
				word[j] = givenLetters[randomIndex].charAt(0);
			}
			System.out.print("\n");
			wordsString[i] = new String(word);
		}
		return wordsString;
	}
	

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument " + i + " : " + args[i]);
		}
		
		if (validateInput(args) == true)
		{
			int n, p;
			n = Integer.parseInt(args[0]);
			p = Integer.parseInt(args[1]);
			
			System.out.println("n = " + n + " and p = " + p);
			
			String[] givenLetters = Arrays.copyOfRange(args, 2,args.length);  // copying args[2]-args[length] to givenLetters
			for(int i = 0; i < givenLetters.length; i++) {
				System.out.println(givenLetters[i]);
			}
			
			String[] wordsString = createWords(n, p, givenLetters);
			
			for(int i = 0; i < wordsString.length; i++) {
				System.out.println(wordsString[i]);
			}
			
		}
		else {
			System.out.println("Invalid arguments.");
		}
	}

}
