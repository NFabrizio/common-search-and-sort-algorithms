/**
 * Basic example of a bubble sort algorithm (https://en.wikipedia.org/wiki/Bubble_sort) where each element in an
 * array of integers is compared to the element after it in the array, and if its value is greater than the
 * value of the element after it, their indices are swapped. This algorithm pushes/bubbles the highest value element in
 * the array to its correct index at the end of the array with each pass (e.g., the first pass bubbles the element with
 * the highest value to the last index in the array, the second pass bubbles the element with the second highest value
 * to the second to last index in the array, etc.).
 *
 * Runtimes bubbleForLoop (avegerage of 10 trials)
 * - 10 elements = 18.07 μs
 * - 100 elements = 357.81 μs
 * - 1,000 elements = 8.39 ms
 * - 10,000 elements = 303.76 ms
 * - 100,000 elements = 35.75 s
 *
 * Runtimes bubbleWhileLoop (avegerage of 10 trials)
 * - 10 elements = 6.49 μs
 * - 100 elements = 442.11 ms
 * - 1,000 elements = 3.36 ms
 * - 10,000 elements = 256.49 ms
 * - 100,000 elements = 44.41 s
 */

public class BubbleSort {
    public static void bubbleForLoop(Integer[] numArray) {
        long startTime = System.nanoTime();
        int arraySize = numArray.length;

        // Run the algorithm once per number of elements in the array
        // Start at 1 so that we don't go out of bounds with inner loop
        for (int position = 1; position < arraySize; position++) {
            // i tracks the index as we iterate through the positions in the array.
            // Decrement the maximum value of i (arraySize - position) with each pass since the highest value in the
            // array is pushed/bubbled to its correct index at the end of the array with each pass
            for (int i = 0; i < (arraySize - position); i++) {
                // If the value at index i is less than the value of the index before it in the array, swap the values
                if (numArray[i + 1] < numArray[i]) {
                    Integer temp = numArray[i];
                    numArray[i] = numArray[i + 1];
                    numArray[i + 1] = temp;
                }
            }
        }

        System.out.println("Sorting duration for bubbleForLoop: " + (System.nanoTime() - startTime));
    }

    public static void bubbleWhileLoop(Integer[] numArray) {
        long startTime = System.nanoTime();
        int arraySize = numArray.length;
        boolean swapping = true;

        // Continue loop while numbers are being swapped
        while (swapping) {
            // Set swapping to false as default
            swapping = false;

            // i tracks the index as we iterate through the elements in the array
            for (int i = 0; i < (arraySize - 1); i++) {
                // If the value at index i is less than the value of the index before it in the array, swap the values
                if (numArray[i + 1] < numArray[i]) {
                    // Set swapping to true since there are still numbers to be sorted
                    swapping = true;

                    Integer temp = numArray[i];
                    numArray[i] = numArray[i + 1];
                    numArray[i + 1] = temp;
                }
            }
        }

        System.out.println("Sorting duration for bubbleWhileLoop: " + (System.nanoTime() - startTime));
    }

    public static void main(String[] args) {
        for (int i=0; i<10;i++) {
//        Integer[] numArray = Utilities.array10();
            Integer[] numArray = Utilities.arrayDynamic(100000, 100000);

//        System.out.print("Initial array: ");
//        Utilities.printArray(numArray);

            // This method runs in about 40% less time than the method using a while loop when run in isolation
//        bubbleForLoop(numArray);

//        Integer[] numArray2 = Utilities.array10();
//        Integer[] numArray2 = Utilities.arrayDynamic(100, 100);

            // Running this method in the same execution as the for loop method allows this to always complete more quickly
            // even though it uses an array created separately. If the methods are switched in execution order, the for loop
            // will always complete more quickly
            // TODO: determine why execution order affects the speed of execution completion
            bubbleWhileLoop(numArray);
        }

//        System.out.print("Sorted numArray: ");
//        Utilities.printArray(numArray);
//        System.out.print("Sorted numArray2: ");
//        Utilities.printArray(numArray2);
    }
}
