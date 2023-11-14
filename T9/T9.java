package T9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class T9 {
    public static final String file = "C:\\Users\\chris\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";
    //public static final String file = "C:\\Users\\chris\\OneDrive - KTH\\ID1021\\Inlämningar\\src\\T9\\kelly.txt";
    private Node root;

    private static class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            next = new Node[27];
            valid = false;
        }
    }

    public T9(String file) {
        root = new Node();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                insert(line);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public void insert(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = method.code(word.charAt(i));

            if (current.next[index] == null) {
                Node node = new Node();
                current.next[index] = node;
                current = node;
            } else {
                current = current.next[index];
            }
        }
        current.valid = true;
    }

    public boolean search(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = method.code(word.charAt(i));

            if (current.next[index] == null) {
                return false;
            }

            current = current.next[index];
        }

        return current.valid;
    }

    public ArrayList<String> decode(String key) {
        ArrayList<String> words = new ArrayList<>();
        collect(root, "", key, words);
        return words;
    }

    private void collect(Node node, String prefix, String remaining, ArrayList<String> words) {
        if (node == null) {
            return;
        }

        if (remaining.length() == 0) {
            if (node.valid) {
                words.add(prefix);
            }

            for (char c = 'a'; c <= 'ö'; c++) {
                int index = method.code(c);
                if (index != -1) { // Check if the character is valid
                    collect(node.next[index], prefix + c, remaining, words);
                }
            }
        } else {
            char nextChar = remaining.charAt(0);
            int index = method.code(nextChar);
            if (index != -1) { // Check if the character is valid
                collect(node.next[index], prefix + nextChar, remaining.substring(1), words);
            }
        }
    }

}
