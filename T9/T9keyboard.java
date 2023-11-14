package T9;

import Quick.Array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class T9Keyboard {
    public static final String file = "C:\\Users\\Christoffer Franzen\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";
    //public static final String file = "C:\\Users\\chris\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";

    public static void main(String[] args) {
        T9 t9 = new T9(file);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("T9 Keyboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(4, 3));

            String[][] keys = {
                    {"<html>1<br>ABC</html>", "<html>2<br>DEF</html>", "<html>3<br>GHI</html>"},
                    {"<html>4<br>JKL</html>", "<html>5<br>MNO</html>", "<html>6<br>PRS</html>"},
                    {"<html>7<br>TUV</html>", "<html>8<br>XYZ</html>", "<html>9<br>ÅÄÖ</html>"},
                    {"<html>*<br></html>", "<html>0<br></html>", "<html>#<br></html>"}
            };

            for (String[] row : keys) {
                for (String key : row) {
                    JButton button = new JButton(key);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (button.getText().equals("<html>1<br>ABC</html>")) {

                                String input = "12"; // Example input: "12" corresponds to "AD" or "AE" or "AF"
                                ArrayList<String> combinations = getT9Combinations(input);

                                System.out.println("T9 Combinations for input " + input + ":");
                                for (String combination : combinations) {
                                    System.out.println(combination);
                                }


                                /*
                                System.out.println("T9 Combinations for input " + input + ":");
                                for (String combination : combinations) {
                                    System.out.println(combination);
                                }


                                characters.add('a');
                                characters.add('b');
                                characters.add('c');

                                for (int i = 0; i < 50; i++) {
                                    System.out.println("");
                                }
                                ArrayList<String> list = new ArrayList<>();


                                for (String word : list) {
                                    System.out.println(word);
                                }

                                 */
                            }
                            if (button.getText().equals("<html>2<br>DEF</html>")) {


                                for (int i = 0; i < 100; i++) {
                                    System.out.println("");
                                }
                                ArrayList<String> list = t9.decode("å");

                                for (String word : list) {
                                    System.out.println(word);
                                }
                            }
                        }
                    });
                    frame.add(button);
                }
            }

            frame.pack();
            frame.setVisible(true);
        });
    }

    private static final String[] T9_KEYPAD = {
            " ",     // Button 0
            "",      // Button 1
            "ABC",   // Button 2
            "DEF",   // Button 3
            "GHI",   // Button 4
            "JKL",   // Button 5
            "MNO",   // Button 6
            "PQRS",  // Button 7
            "TUV",   // Button 8
            "WXYZ"   // Button 9
    };

    public static ArrayList<String> getT9Combinations(String input) {
        ArrayList<String> combinations = new ArrayList<>();
        generateT9Combinations(input, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private static void generateT9Combinations(String input, int index, StringBuilder current, ArrayList<String> combinations) {
        if (index == input.length()) {
            combinations.add(current.toString());
            return;
        }

        int digit = input.charAt(index) - '0';
        String letters = T9_KEYPAD[digit];

        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            current.append(letter);
            generateT9Combinations(input, index + 1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

