package Sorting;

public class Insertion {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            for (; j >= 0 && array[j] > key; j--){
                swap(array, j + 1, j);
            }

            array[j + 1] = key;
        }
    }

    public static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}

/*
Time Complexity: O(N^2)
Auxiliary Space: O(1)

Complexity Analysis of Insertion Sort:
Time Complexity of Insertion Sort
The worst-case time complexity of the Insertion sort is O(N^2)
The average case time complexity of the Insertion sort is O(N^2)
The time complexity of the best case is O(N).
Space Complexity of Insertion Sort
The auxiliary space complexity of Insertion Sort is O(1)

Characteristics of Insertion Sort
This algorithm is one of the simplest algorithms with a simple implementation
Basically, Insertion sort is efficient for small data values
Insertion sort is adaptive in nature, i.e. it is appropriate for data sets that are already partially sorted.
 */


