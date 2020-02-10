package sort;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] originalArry = RandomArray.generateArray(1000000);
        int n = originalArry.length;
        int writeNum = 1;
        Scanner input = new Scanner(System.in);

        String loop = "Y";

        try {
            originalArry = RandomArray.generateArray(n);
        } catch (Exception e) {
            System.out.println("Failed to generate array.\n\n");
        } finally {
            System.out.println("An array of " + Integer.toString(n) + " generated successfully!\n\n");
        }

        try {
            RandomArray.writeArrToFile("StartArray", originalArry);
        } catch (Exception e) {
            System.out.println("IO Exception writing array to file.\n\n");
        } finally {
            System.out.println("Array successfully written to file.\n\n");
        }

        while(loop.toUpperCase().contains("Y")) {
            System.out.println("Enter 'Hoare' or 'Lomuto' for partitioning type:\n");
            String sort = input.nextLine();
            System.out.println("Enter 'Left' 'Right' or 'Median' for pivot type:\n");
            String pivot = input.nextLine();
            System.out.println("Enter minimum partition size before using insertion sort:\n");
            int minPartSize = input.nextInt();
            input.nextLine();

            int[] sorted = RandomArray.duplicateArray(originalArry);

            Sort ob = new Sort();

            long initTime = System.nanoTime();

            ob.sort(sorted, 0, n - 1, sort, pivot, minPartSize);

            long finalTime = System.nanoTime();

            System.out.println("Sorting time in nanoseconds:\n" + Long.toString(finalTime - initTime) + "\n\n");

            System.out.println("Print the array to console?\n");
            String prnt = input.nextLine();
            if(prnt.toUpperCase().contains("Y"))
            RandomArray.printArray(sorted);

            System.out.println("Write the array to file?\n");
            String wrt = input.nextLine();
            if(wrt.toUpperCase().contains("Y")) {
                try {
                    RandomArray.writeArrToFile(sort + "_" + pivot + "_" + writeNum, sorted);
                } catch (Exception e) {
                    System.out.println("IO Exception writing array to file.\n\n");
                } finally {
                    writeNum++;
                }
            }
            System.out.println("\nWould you like to run again?:\n");
            loop = input.nextLine();
        }
    }
}

