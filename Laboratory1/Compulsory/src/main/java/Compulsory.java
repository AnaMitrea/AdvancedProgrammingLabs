public class Compulsory {
    public static int sumOfDigits(int n) {

        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);   // 1_000_000 (literal) = 1000000 (nr)
        int multiplier = n * 3;

        String binaryNumber = "10101";
        int decimalNumber = Integer.parseInt(binaryNumber, 2);
        multiplier = multiplier + decimalNumber;

        String hexadecimalNumber = "FF";
        decimalNumber = Integer.parseInt(hexadecimalNumber, 16);
        multiplier = multiplier + decimalNumber;

        multiplier = multiplier * 6;

        int sumOfDigits = sumOfDigits(multiplier);
        while (sumOfDigits > 9) {
            sumOfDigits = sumOfDigits(sumOfDigits);
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[sumOfDigits]);
    }
}