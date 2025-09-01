
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int[] numbers = new int[3];
        Scanner scanner = new Scanner(System.in);

        saveValues(numbers, scanner);
        printValues(numbers);

        // System.out.println("enter length:");
        // int count = scanner.nextInt();
        // String[] names = new String[count];

        int[][] twoDimArr = new int[3][3];

        scanner.close();
    }

    private static void saveValues(int[] numbers, Scanner scanner) {
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("enter value at numbers[" + index + "]: ");
            int num = scanner.nextInt();
            numbers[index] = num;
        }
    }

    private static void printValues(int[] numbers) {
        System.out.println("\nvalues from the numbers\n");
        // foreach loop
        for (int value : numbers) {
            System.out.println("Value: " + value);
        }
    }
}
