/**
 * Basic example of the quick sort algorithm (https://en.wikipedia.org/wiki/Quicksort) where the array is split
 * into segments based on a pivot point. The value of the elements in each segment are compared to the value of the pivot
 * point (left segment less than pivot, right segment greater than pivot). When elements are found in each segment that
 * are out of order when compared to the value of the pivot, their order is swapped in place in the array. This process
 * is performed recursively until all elements in the array are in the correct order.
 *
 * Runtimes (avegerage of 10 trials)
 * - 10 elements = 6.27 μs
 * - 100 elements = 47.62 μs
 * - 1,000 elements = 204.1 μs
 * - 10,000 elements = 1.67 ms
 * - 100,000 elements = 18.56 ms
 */
public class QuickSort {
    public static void quicksortArray(Integer[] numArray, int start, int end) {
        Integer temp;

        // i tracks index of first half of temp array segment
        int i = start;
        // j tracks index of second half of temp array segment
        int j = end;
        // Set pivot to value at pivot point half way between start and end
        Integer pivot = numArray[(start + end) / 2];

        while (i <= j) {
            // Check values on left side of pivot until one is found that is greater than pivot
            while (numArray[i] < pivot) {
                i++;
            }

            // Check values on right side of pivot until one is found that is less than pivot
            while (numArray[j] > pivot) {
                j--;
            }

            // If i <= j, there are still values in the two segments that are out of order when compared with the pivot
            // and need to be swapped
            if (i <= j) {
                temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;

                i++;
                j--;
            }
        }

        if (start < j) {
            quicksortArray(numArray, start, j);
        }

        if (i < end) {
            quicksortArray(numArray, i, end);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            Integer[] numArray = Utilities.array10();
            Integer[] numArray = Utilities.arrayDynamic(100000, 100000);

//            System.out.print("numArray initial: ");
//            Utilities.printArray(numArray);

            long startTime = System.nanoTime();

            quicksortArray(numArray, 0, (numArray.length - 1));

            System.out.println("Sorting duration for quicksort: " + (System.nanoTime() - startTime));

//            System.out.print("Sorted numArray final: ");
//            Utilities.printArray(numArray);
        }
    }
}
