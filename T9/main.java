package T9;

import java.util.ArrayList;

public class main {
    //public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";
    public static final String file = "C:\\Users\\chris\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";


    public static void main(String[] args) {
        T9 t9 = new T9(file);

        //System.out.println(t9.search("vara"));

        ArrayList<String> list = t9.decode("gu");

        for (String word : list) {
            System.out.println(word);
        }
    }
}
