package Quick;

public class Array {
    public static void sort(int[] array, int min, int max) {
        if (min < max) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, min, max);

            // Recursively sort the elements before and after the pivot
            sort(array, min, pivotIndex - 1);
            sort(array, pivotIndex + 1, max);
        }
    }

    // Partitions the array around a pivot
    private static int partition(int[] array, int min, int max) {
        int pivot = array[min];
        int i = min;
        int j = max;

        // Move elements smaller than pivot to its left and larger elements to its right
        while (i < j) {
            while (array[j] > pivot && j > i) {
                j--;
            }

            while (array[i] <= pivot && i < j) {
                i++;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }

        // Swap the pivot with the element at j
        swap(array, min, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}