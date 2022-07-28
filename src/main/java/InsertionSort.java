/**
 * Basic example of an insertion sort algorithm (https://en.wikipedia.org/wiki/Insertion_sort) where each element in an
 * array of integers is compared to each element that occurs before it in the array, and if its value is less than the
 * value of the element before it, their indices are swapped.
 *
 * Runtimes (avegerage of 10 trials)
 * - 10 elements = 17.95 μs
 * - 100 elements = 317.72 μs
 * - 1,000 elements = 7.47 ms
 * - 10,000 elements = 203.29 ms
 * - 100,000 elements = 20.6 s
 */

public class InsertionSort {
    public static void main(String[] args) {
//        Integer[] numArray = Utilities.array10();
        Integer[] numArray = Utilities.arrayDynamic(100000, 100000);
        int arraySize = numArray.length;

//        System.out.print("Initial array: ");
//        Utilities.printArray(numArray);

        long startTime = System.nanoTime();

        // i tracks the index as we iterate through the elements in the array
        for (int i = 0; i < arraySize; i++) {
            // j tracks the value at index i as it is moved during sorting
            for (int j = i; j > 0; j--) {
                // if the value at index i is less than the value of the index before it in the array, swap the values
                if (numArray[j] < numArray[j - 1]) {
                    Integer temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }

        System.out.println("Sorting duration: " + (System.nanoTime() - startTime));

//        System.out.print("Sorted array: ");
//        Utilities.printArray(numArray);
    }
}
