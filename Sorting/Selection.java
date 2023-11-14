package Sorting;

public class Selection {
    public static void sort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            int candidate = i;
            for (int j = i; j < array.length ; j++) {
                if (array[j] < array[candidate]){
                    candidate = j;
                }

                int tmp = array[candidate];
                array[candidate] = array[i];
                array[i] = tmp;
            }
        }
    }
}
/*
Complexity Analysis of Selection Sort

Time Complexity: The time complexity of Selection Sort is O(N2) as there are two nested loops:

    One loop to select an element of Array one by one = O(N)
    Another loop to compare that element with every other Array element = O(N)
    Therefore overall complexity = O(N) * O(N) = O(N*N) = O(N2)

Auxiliary Space: O(1) as the only extra memory used is for temporary variables while swapping two values in Array. The selection sort never makes more than O(N) swaps and can be useful when memory writing is costly.
Advantages of Selection Sort Algorithm

    Simple and easy to understand.
    Works well with small datasets.

Disadvantages of the Selection Sort Algorithm

    Selection sort has a time complexity of O(n^2) in the worst and average case.
    Does not work well on large datasets.
    Does not preserve the relative order of items with equal keys which means it is not stable.
 */