package Sorted;

import Hash.Zip;
import Hash.intZip;

public class Linear {
    public static boolean search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return true;
            } else if (array[i] > key) {
                break;
            }
        }
        return false;
    }

    // Hash task implementation1
    public static String search(Zip.Node[] data, String zip, int max) {
        for (int i = 0; i < max; i++) {
            if (data[i].zip.compareTo(zip) == 0) {
                return "City: " + data[i].city + ", Area: " + data[i].count;
            } else if (data[i].zip.compareTo(zip) > 0) {
                break;
            }
        }
        return null;
    }

    // Hash task implementation2
    public static String search(intZip.Node[] data, int zip, int max) {
        for (int i = 0; i < max; i++) {
            if (data[i].zip == zip) {
                return "City: " + data[i].city + ", Area: " + data[i].count;
            } else if (data[i].zip > zip) {
                break;
            }
        }
        return null;
    }
}
