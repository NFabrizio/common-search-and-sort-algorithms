/**
 * Optimized insertion sort algorithm where unnecessary steps from the basic insertion sort are removed (e.g., skipping
 * the first element in the array since there are no elements that occur before it in the array to compare it with). This
 * method is significantly faster than the basic insertion sort algorithm implemented in InsertionSort.
 *
 * Runtimes (avegerage of 10 trials)
 * - 10 elements = 8.17 μs
 * - 100 elements = 233.11 μs
 * - 1,000 elements = 6.43 ms
 * - 10,000 elements = 163.26 ms
 * - 100,000 elements = 15.62 s
 */

public class InsertionSortOptimized {
    public static void main(String[] args) {
//        Integer[] numArray = Utilities.array10();
        Integer[] numArray = Utilities.arrayDynamic(100000, 100000);
        int arraySize = numArray.length;

//        System.out.print("Initial array: ");
//        Utilities.printArray(numArray);

        long startTime = System.nanoTime();

        // i tracks the index as we iterate through the elements in the array
        // Start at index 1 since there is nothing to which to compare the first element in the array
        for (int i = 1; i < arraySize; i++) {
            // j tracks the value at index i as it is moved during sorting
            for (int j = i; j > 0; j--) {
                // if the value of j is less than the value of the element before it in the array, swap the values
                if (numArray[j] < numArray[j - 1]) {
                    Integer temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                } else {
                    // If the value at j is greater than that at j - 1, stop since j will be greater than all other
                    // values with lower index
                    break;
                }
            }
        }

        System.out.println("Sorting duration: " + (System.nanoTime() - startTime));

//        System.out.print("Sorted array: ");
//        Utilities.printArray(numArray);
    }
}
