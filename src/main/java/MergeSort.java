/**
 * Basic example of the merge sort algorithm (https://en.wikipedia.org/wiki/Merge_sort) where the array is broken up
 * into neighboring pairs of elements which are sorted by value, and each pair is then compared to its neighboring pair
 * and each element in each pair is compared from left to right and inserted into the appropriate index of the original
 * array.
 *
 * Runtimes (avegerage of 10 trials)
 * - 10 elements = 9.00 μs
 * - 100 elements = 112.25 μs
 * - 1,000 elements = 2.79 ms
 * - 10,000 elements = 52.7 ms
 * - 100,000 elements = 2.14 s
 */
public class MergeSort {
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
        while (i <= middle) {
            numArray[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void explodeAndSortArray(Integer[] numArray, int start, int end) {
        // Continue regressing until start and end are equivalent (i.e., as long as there are at least two elements to sort)
        if (start < end) {
            int middleIndex = (start + end) / 2;

            explodeAndSortArray(numArray, start, middleIndex);
            explodeAndSortArray(numArray, (middleIndex + 1), end);

            sortArray(numArray, start, middleIndex, end);
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10;i++) {
//        Integer[] numArray = Utilities.array10();
            Integer[] numArray = Utilities.arrayDynamic(10000, 10000);

            long startTime = System.nanoTime();

            explodeAndSortArray(numArray, 0, (numArray.length - 1));

            System.out.println("Sorting duration for merge sort: " + (System.nanoTime() - startTime));

//        System.out.print("Sorted numArray final: ");
//        Utilities.printArray(numArray);
        }
    }
}
