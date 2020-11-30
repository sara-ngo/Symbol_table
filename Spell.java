// Spell.java: Takes a command-line argument specifying the name of the file
// containing common misspellings (a line-oriented file with each
// comma-separated line containing a misspelled word and the correct spelling),
// then reads text from standard input and prints out the misspelled words in
// the text along with the line numbers where they occurred and their correct
// spellings.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Spell {
    public static void main(String[] args) {
        int counter = 0;
        ArrayST<String, String> dict = new ArrayST<>();

        In in = new In(args[0]);
        String[] lines = in.readAllLines();
        in.close();

        for (String line : lines) {
            String[] tokens = line.split(",");
            String word = tokens[0];
            String correction = tokens[1];
            dict.put(word, correction);
        }

        In in2 = new In(args[1]);
        while (!in2.isEmpty()) {
            counter++;
            String line = in2.readLine();
            String[] words = line.split("\\b");
            for (String word : words) {
                if (dict.contains(word)) {
                    StdOut.println(word + ": " + counter + " -> " + dict.get(word));
                }
            }
        }
    }
}
