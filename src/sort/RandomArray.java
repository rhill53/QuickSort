package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomArray {

    static int[] generateArray(int maxSize) {
        Random rand = new Random();
        int[] arry = new int[maxSize];

        for (int i = 0; i < maxSize; i++){
            arry[i] = rand.nextInt(65535);
        }

        return arry;
    }

    static int[] duplicateArray(int[]inputArry){
        int[]outputArry = new int[inputArry.length];

        for(int i = 0; i < inputArry.length; i++){
            outputArry[i] = inputArry[i];
        }

        return outputArry;
    }

    static void writeArrToFile(String filename, int[]arry) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));

        for (int i = 0; i < arry.length; i += 1000){
            for(int j = 0; j < 1000; j++){
                outputWriter.write(String.format("%04X ", arry[i + j]));
            }
            outputWriter.newLine();
        }

        outputWriter.flush();
        outputWriter.close();
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; i += 1000) {
            System.out.print("Row " + Integer.toString(i/1000)+ " index " + Integer.toString(i) + ": ");
            for (int j = 0; j < 1000; j++) {
                System.out.print( String.format("%04X ", arr[i + j]));
            }
            System.out.print("\n");
        }
    }

}
