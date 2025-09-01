
// import java.io.InputStream;
// import java.io.PrintStream;
import java.util.Scanner;

public class App {
    static String getSentence(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        return sentence;
    }

    static String convertToUpperCase(String sentence) {
        if (!sentence.isEmpty()) {
            String uppercaseSentence = sentence.toUpperCase();
            return uppercaseSentence;
        } else
            return sentence;
    }

    public static void main(String[] args) throws Exception {
        // InputStream inputStream = System.in;
        // Scanner scanner = new Scanner(inputStream);

        Scanner scanner = new Scanner(System.in);
        String sentence = getSentence(scanner);
        String result = convertToUpperCase(sentence);
        System.out.println("Uppercase: " + result);
        scanner.close();
    }
}
