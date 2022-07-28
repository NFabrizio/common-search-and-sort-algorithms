public class Utilities {
    // Returns fixed array of numbers 1 through 10 for testing
    // Set up as Integer[] rather than int[] so that it can be printed using generic types, which cannot be used for primitives
    static Integer[] array10() {
        Integer[] ten = new Integer[]{6,5,9,3,1,8,7,10,2,4};

        return ten;
    }

    // Generates array of given size populated with random numbers between 0 and given limit
    static Integer[] arrayDynamic(int size, int limit) {
        Integer[] dynamicArray = new Integer[size];

        for(int i = 0; i < size; i++) {
            dynamicArray[i] =  (int) (Math.random() * limit);
        }

        return dynamicArray;
    }

    // Using generic type, <T>, to be able to print any element type within an array
    static <T> void printArray(T[] arrayToPrint) {
        for(T num : arrayToPrint) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
