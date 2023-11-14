package Sorted;

import Hash.Zip;
import Hash.intZip;

public class Binary {
    public static boolean search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = first + (last - first)/2;
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index - 1;
                continue;
            }
            return false;
        }
    }

    public static boolean search2(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = first + (last - first)/2;
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index - 1;
                continue;
            }
            return false;
        }
    }

    // Hash implementation1
    public static String search(Zip.Node[] data, String zip, int max) {
        int first = 0;
        int last = max;
        while (true) {
            // jump to the middle
            int index = first + (last - first)/2;
            if (data[index].zip.compareTo(zip) == 0) {
                return "City: " + data[index].city + ", Area: " + data[index].count;
            }
            if (data[index].zip.compareTo(zip) < 0 && index < last) {
                first = index + 1;
                continue;
            }
            if (data[index].zip.compareTo(zip) > 0 && index > first) {
                last = index - 1;
                continue;
            }
            return null;
        }
    }

    // Hash implementation2
    public static String search(intZip.Node[] data, int zip, int max) {
        int first = 0;
        int last = max;
        while (true) {
            // jump to the middle
            int index = first + (last - first)/2;
            if (data[index].zip == zip) {
                return "City: " + data[index].city + ", Area: " + data[index].count;
            }
            if (data[index].zip < zip && index < last) {
                first = index + 1;
                continue;
            }
            if (data[index].zip > zip && index > first) {
                last = index - 1;
                continue;
            }
            return null;
        }
    }
}
