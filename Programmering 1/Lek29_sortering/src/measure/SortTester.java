package measure;

import model.Customer;
import sortering.SelectionSort;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortTester {

    public static void main(String[] args) {
        
        int testSize = 4000;
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

//        System.out.println(bigList);
        
        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationMilliSeconds()));
        
        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationMilliSeconds()));
        
        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationMilliSeconds()));



    }


}
