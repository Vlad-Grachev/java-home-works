package hw3;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void fillArray(int[] arr){
        Random random = new Random();
        int maxval = (arr.length < 1000) ? 10000 : Integer.MAX_VALUE / 4;
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(maxval * 2) - maxval;
    }

    public static void bubbleSort(int[] arr){
        int temp;
        for(int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+ 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        int k, temp;
        for (int i = 0; i < arr.length; i++) {
            k = i; temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < temp){
                    k = j;
                    temp = arr[j];
                }
            }
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] arr1, arr2, arr3;

        if(args.length > 0)
            n = Integer.parseInt(args[0]);

        arr1 = new int[n];
        fillArray(arr1);
        arr2 = arr1.clone();
        arr3 = arr1.clone();

        long startTime = System.nanoTime();
        bubbleSort(arr1);
        long bsTime = System.nanoTime() - startTime;
        System.out.println("Bubble sort time: "
                + String.format("%.4f", bsTime / 1000000000.0) + " sec");

        startTime = System.nanoTime();
        selectionSort(arr2);
        long ssTime = System.nanoTime() - startTime;
        System.out.println("Selection sort time: "
                + String.format("%.4f", ssTime / 1000000000.0) + " sec");

        startTime = System.nanoTime();
        Arrays.sort(arr3);
        long qsTime = System.nanoTime() - startTime;
        System.out.println("Quick sort time: "
                + String.format("%.4f", qsTime / 1000000000.0) + " sec");
        String f, l;
        if(qsTime < ssTime) {
            if (qsTime < bsTime) {
                f = "Quick sort";
                l = ssTime < bsTime ? "Bubble sort" : "Selection sort";
            }
            else {
                f = "Bubble sort";
                l = "Selection sort";
            }
        }
        else {
            if (ssTime < bsTime){
                f = "Selection sort";
                l = qsTime < bsTime ? "Bubble sort" : "Quick sort";
            }
            else{
                f = "Bubble sort";
                l = "Quick sort";
            }
        }
        System.out.println("Fastest: " + f);
        System.out.println("Longest: " + l);
    }
}
