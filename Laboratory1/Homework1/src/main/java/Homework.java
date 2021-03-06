import java.util.ArrayList;
import java.util.Random;

public class Homework {
    public boolean isNumber(String input) {
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

    public boolean isCharacter(char input) {
        return (input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z');
    }

    public boolean validateInput(String[] input) {
        if (!isNumber(input[0]) || !isNumber(input[1]))
            return false;
        for (int i = 2; i < input.length; i++) {
            if (input[i].length() > 1 ) // if input[i] has more than 1 characters
                return false;

            if (!isCharacter(input[i].charAt(0))) // if input[i] is an alphabet letter
                return false;
        }
        return true;
    }

    public ArrayList<String> createWords(int numberOfWords, int lengthOfWords, String[] givenLetters) {
        ArrayList<String> wordsString = new ArrayList<String>();

        for (int i = 0; i < numberOfWords; i++) {
            StringBuilder word = new StringBuilder();

            //System.out.println("i = " + i + ":");
            for (int j = 0; j < lengthOfWords; j++) {
                Random r = new Random();
                int randomIndex = r.nextInt(givenLetters.length);
                //System.out.print("RandomIndex= " + randomIndex + " ; ");

                word.append(givenLetters[randomIndex].charAt(0));
            }
            //System.out.print("\n");
            wordsString.add(word.toString());
        }
        return wordsString;
    }

    public void printGivenWords(String[] givenLetters) {
        System.out.print("Given letters: ");
        for (String givenLetter : givenLetters) {
            System.out.print(givenLetter + " ");
        }
        System.out.println();
    }

    public void printWords(String information, ArrayList<String> wordsString) {
        System.out.println(information);
        for (String s : wordsString) {
            System.out.print(s + " ");
        }
    }

    public boolean checkNeighborWords(String wordOne, String wordTwo) {
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

    public boolean[][] createMatrixOfNeighbors(ArrayList<String> wordsString) {
        int stringLength = wordsString.size();
        boolean[][] matrixOfNeighbors = new boolean[stringLength][stringLength];

        for (int i = 0; i < stringLength; i++) {
            for (int j = 0; j < stringLength; j++) {
                if (i == j) {
                    matrixOfNeighbors[i][j] = true;
                }
                else {
                    matrixOfNeighbors[i][j] = checkNeighborWords(wordsString.get(i), wordsString.get(j));
                }
            }
        }
        return matrixOfNeighbors;
    }

    public void printMatrix(boolean[][] matrixOfNeighbors) {
        int matrixLength = matrixOfNeighbors.length;

        System.out.println("\n\nChecking for neighbors...");
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                System.out.print(matrixOfNeighbors[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public ArrayList<ArrayList<String>> createNeighborList(ArrayList<String> wordsString, boolean[][] matrixOfNeighbors) {
        ArrayList<ArrayList<String>> neighborList = new ArrayList<ArrayList<String>>();
        int n = wordsString.size();

        for (int i = 0; i < n; i++) {
            ArrayList<String> listForEachWord = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                if (matrixOfNeighbors[i][j] && i != j) {
                    listForEachWord.add(wordsString.get(j));
                }
            }
            neighborList.add(listForEachWord);
        }
        return neighborList;
    }

    public ArrayList<String> createNoDuplicates(ArrayList<String> wordsString) {
        ArrayList<String> wordList = new ArrayList<String>();

        for(String word : wordsString) {
            if(!wordList.contains(word)) {
                wordList.add(word);
            }
        }
        return wordList;
    }

    public ArrayList<String> dfs(ArrayList<String> wordList, ArrayList<String> visited, boolean[][] matrixOfNeighbors, int position) {
        /*
          Conditii de oprire algoritm:
          1. cautare ultimul cuvant adaugat (wordList[pos]) sa fie egal cu primul cuvant din visited[0] pentru a forma un circuit
          2. cuvant deja existent in visited => circuitul format nu este corect => return empty

          Parcurgerea dfs in matrice:
          - se iau in considerare cuvintele vecine (matrixOfNeighbors[position][i] == true)
               -> fiecare cuvant este adaugat in vectorul visited pentru eliminarea posibilitatii de a fi luat din nou in pasii urmatori
          - update la circuit in functie de lungimea lui
         */

        if(visited.size() != 1) {
            if(visited.indexOf(wordList.get(position)) == 0) {
                return visited;
            }
            else if(visited.indexOf(wordList.get(position)) != (visited.size() - 1))
                return new ArrayList<String>();
        }

        ArrayList<String> bestVisited = new ArrayList<String>(visited);

        for(int i = 0; i < matrixOfNeighbors[position].length; i++) {
            if(matrixOfNeighbors[position][i] == true && i != position) {
                ArrayList<String> newVisited = new ArrayList<String>(visited);
                newVisited.add(wordList.get(i));

                newVisited = dfs(wordList,newVisited,matrixOfNeighbors,i);

                if(newVisited.size() > bestVisited.size()) {
                    bestVisited = newVisited;
                }
            }
        }

        if(bestVisited.get(0).equals(bestVisited.get(bestVisited.size() - 1))) // verificare primul cuvant = ultimul cuvant
            return bestVisited;
        else
            return new ArrayList<String>();
    }

    public void printHomework(ArrayList<String> wordsString, boolean[][] matrixOfNeighbors, ArrayList<ArrayList<String>> neighborList) {
        printWords("Words List: ",wordsString);
        printMatrix(matrixOfNeighbors);
        System.out.println();

        System.out.println("Neighbor List: " + neighborList);
        System.out.println();
    }

    public void printBonus(ArrayList<String> wordsString) {
        ArrayList<String> wordList = createNoDuplicates(wordsString);
        boolean[][] matrixOfNeighbors = createMatrixOfNeighbors(wordList);

        ArrayList<String> bestWordList = new ArrayList<String>();

        for(int i = 0; i < wordList.size(); i++) {
            ArrayList<String> visited = new ArrayList<String>();
            visited.add(wordList.get(i)); // i - pozitia de start in parcurgerea dfs

            visited = dfs(wordList,visited,matrixOfNeighbors,i);

            if(visited.size() > bestWordList.size()) {
                bestWordList = visited;
            }
        }
        int k = bestWordList.size() - 1;
        printWords("Longest circuit found with k = " + k,bestWordList);
        System.out.println();
    }
}
