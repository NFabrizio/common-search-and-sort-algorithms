/**
 * Optimized merge sort algorithm where unnecessary steps from the basic merge sort are removed (e.g., using for loops
 * where possible, skipping regression that will be passed rather than run, etc.). This method is not as fast as
 * the basic insertion sort algorithm implemented in MergeSort.
 *
 * Runtimes (avegerage of 10 trials)
 * - 10 elements = 8.77 μs
 * - 100 elements = 94.36 μs
 * - 1,000 elements = 2.74 ms
 * - 10,000 elements = 52.86 ms
 * - 100,000 elements = 2.17 s
 */

public class MergeSortOptimized {
    public static void sortArray(Integer[] numArray, int start, int middle, int end) {
        Integer[] temp = new Integer[numArray.length];

        // Copy numArray into temp array for holding intermediate sorted state
        for (int i = start; i <= end; i++) {
            temp[i] = numArray[i];
        }

        // i tracks index of first half of temp array segment
        int i = start;
        // j tracks index of second half of temp array segment
        int j = middle + 1;
        // k tracks index of numArray as sorted values are placed into it
        int k = start;

        while (i <= middle && j <= end) {
            // Compare values from front of each array segment and insert into numArray at index k based on the lowest value
            if (temp[i] <= temp[j]) {
                numArray[k] = temp[i];
                i++;
            } else {
                numArray[k] = temp[j];
                j++;
            }

            k++;
        }

        // If i is less than middle at this point, j had values lower than i values and replaced them in numArray
        // leaving duplicate j values, so we need to backfill what is left with the values from i to overwrite the
        // duplicate j values starting where we left off at index k.
        // For example, original numArray = [3, 2, 1] would be [1, 2, 1] at this point because the value at j=2 is less
        // than the value at i=0, so j would have replaced i but j would still exist at index 2. We would need to
        // backfill or replace the value at j with the value from i to end up with [1, 2, 3].
        for (int pointer = i; pointer <= middle; pointer++) {
            numArray[k] = temp[pointer];
            k++;
        }
    }

    public static void explodeAndSortArray(Integer[] numArray, int start, int end) {
        // Continue regressing until start and end are equivalent (i.e., as long as there are at least two elements to sort)
        if (start < end) {
            int middleIndex = (start + end) / 2;

            // Only continue regressing if there are more than 2 elements in the array segment since 2 elements results
            // in the same values being passed back in (e.g., (0, 1) would yield explodeAndSortArray(0, 0) and
            // explodeAndSortArray(1, 1) which would both fail the initial condition)
            if ((end - start) > 1) {
                explodeAndSortArray(numArray, start, middleIndex);
                explodeAndSortArray(numArray, (middleIndex + 1), end);
            }

            sortArray(numArray, start, middleIndex, end);
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10;i++) {
//            Integer[] numArray = Utilities.array10();
        Integer[] numArray = Utilities.arrayDynamic(100000, 100000);

            long startTime = System.nanoTime();

            explodeAndSortArray(numArray, 0, (numArray.length - 1));

            System.out.println("Sorting duration for merge sort: " + (System.nanoTime() - startTime));

//        System.out.print("Sorted numArray final: ");
//        Utilities.printArray(numArray);
        }
    }
}
