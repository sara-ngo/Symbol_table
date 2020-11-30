// FrequencyCounter.java: Reads in a command-line integer and sequence of words
// from standard input and prints out all the words (whose length exceeds the
// threshold) that occur most frequently to standard output. It also prints out
// the number of words whose length exceeds the threshold and the number of
// distinct such words.

import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {
    public static void main(String[] args) {
        ArrayST<String, Integer> freq = new ArrayST<>();
        int count = 1;
        int maxOccurrence = 1;
        int threshold = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (freq.contains(key)) {
                freq.put(key, freq.get(key) + 1);
                if (maxOccurrence < freq.get(key)) {
                    maxOccurrence = freq.get(key);
                }
            } else {
                freq.put(key, 1);
            }
            count++;
        }
        
        for (String word : freq.keys()) {
            if (freq.get(word) > threshold && freq.get(word) == maxOccurrence) {
                System.out.print(word + " ");
            }
        }
        System.out.println(maxOccurrence);

        System.out.println("distinct = " + freq.size());

        System.out.println("words = " + (count - 1));

    }
}

