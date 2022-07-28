/**
 * Basic example of linear search algorithm (https://en.wikipedia.org/wiki/Linear_search) where each element in the
 * array is compared against the target value to see if it matches starting at the first element in the array and
 * proceeding through each subsequent element until the end of the array is reached.
 */

public class LinearSearch {
    public static Integer getMax(Integer[] numArray) {
        Integer max = numArray[0];

        for (int i = 1; i < numArray.length; i++) {
            Integer value = numArray[i];

            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static void main (String[] args) {
        for (int i = 0; i < 10; i++) {
//            Integer[] numArray = Utilities.array10();
            Integer[] numArray = Utilities.arrayDynamic(100000, 100000);

//            System.out.print("numArray: ");
//            Utilities.printArray(numArray);

            long startTime = System.nanoTime();

            Integer maximum = getMax(numArray);

            System.out.println("Search duration for getMax: " + (System.nanoTime() - startTime));

            System.out.println("numArray max: " + maximum);
        }
    }
}
