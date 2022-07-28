/**
 * Basic example of binary search algorithm (https://en.wikipedia.org/wiki/Binary_search_algorithm) where sorted array
 * is split into two segments, target value is checked against the value at the midpoint joining the two segments and
 * the process is repeated with either the left or right segment based on whether the target value is less than or
 * greater than the midpoint value.
 */

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int search(Integer[] numArray, int target) {
        int first = 0;
        int last = numArray.length - 1;

        if (target < numArray[first] || target > numArray[last]) {
            // Short circuit if target is outside of array range
            return -1;
        }

        while (first <= last) {
            int midpoint = (first + last) / 2;

            if (target < numArray[midpoint]) {
                // If target < midpoint value, repeat by checking only values left of midpoint
                last = midpoint - 1;
            } else if (target > numArray[midpoint]) {
                // If target > midpoint value, repeat by checking only values right of midpoint
                first = midpoint + 1;
            } else {
                // If target not > or < midpoint value, it must be midpoint value
                return midpoint;
            }
        }

        // Return -1 when target is not found in the array
        return -1;
    }

    public static void main (String[] args) {
        for (int i = 0; i < 10; i++) {
            Integer[] numArray = Utilities.array10();
//            Integer[] numArray = Utilities.arrayDynamic(100000, 100000);

            // Array must be sorted for binary search to work
            Arrays.sort(numArray);

//            System.out.print("numArray: ");
//            Utilities.printArray(numArray);

            Scanner input = new Scanner(System.in);
            System.out.print("Which number would you like to search for? ");
            int target = input.nextInt();

            long startTime = System.nanoTime();

            int targetIndex = search(numArray, target);

            System.out.println("Search duration for binary search: " + (System.nanoTime() - startTime));

            if (targetIndex == -1) {
                // If targetIndex is -1, the target number was not found in the array
                System.out.println(target + " not found in given array.");
            } else {
                System.out.println(target + " found at index " + targetIndex + " in given array.");
            }
        }
    }
}
