import java.util.Arrays;
import java.util.Scanner;

public class App {
    static int getLength(Scanner scanner) {
        System.out.print("enter length of matrix array: ");
        return scanner.nextInt();
    }

    static void enterValuesInMatrixArray(int[][] matrixInputArray, Scanner scanner) {
        for (int rowIndex = 0; rowIndex < matrixInputArray.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixInputArray[rowIndex].length; columnIndex++) {
                System.out.print("enter value at matrixInputArray[" + rowIndex + "][" + columnIndex + "]: ");
                matrixInputArray[rowIndex][columnIndex] = scanner.nextInt();
            }
        }
    }

    static void printValues(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 1. ask user to enter rows and columns(row no == column no)
        int length = getLength(scanner);

        // 2. create a two dimensional matrix array
        int[][] matrixInputArray = new int[length][length];

        // 3. ask user to enter values in the matrix array
        enterValuesInMatrixArray(matrixInputArray, scanner);

        // 4. call arrangeElements method and pass the matrix array
        int[] resultantArray = arrangeElements(matrixInputArray);
        // 5. print the elements from the single dimensional array as returned by the
        // method
        printValues(resultantArray);
    }

    /*
     * 
     * * this method accepts a two dimensional matrix array and returns a single
     * dimensional arrary with the same length and elements but organized in the
     * following manner
     * 
     * lowest value of matrix array in the middle
     * next highest value on the right side of the middle position
     * next highest on the left side of the middle position R->L
     */
    private static int[] arrangeElements(int[][] matrixArray) {
        int[] single = copyElementsToArray(matrixArray);
        Arrays.sort(single);

        int[] result = new int[single.length];
        int midIndex = result.length / 2;
        int leftIndex = midIndex - 1;
        int rightIndex = midIndex + 1;

        result[midIndex] = single[0];
        for (int i = 1; i < single.length; i++) {
            if (i % 2 != 0) {
                result[rightIndex] = single[i];
                rightIndex++;
            } else {
                result[leftIndex] = single[i];
                leftIndex--;
            }
        }
        return result;
    }

    static int[] copyElementsToArray(int[][] matrix) {
        int totalElements = matrix.length * matrix.length;
        int[] singleDimArray = new int[totalElements];
        int index = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                singleDimArray[index] = matrix[rowIndex][columnIndex];
                index++;
            }
        }
        return singleDimArray;
    }
}
