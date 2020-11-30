import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;

    // Create a symbol table with INIT_CAPACITY.
    public ArrayST() {
        keys = (Key[]) new Object[INIT_CAPACITY];
        values = (Value[]) new Object[INIT_CAPACITY];
        N = 0;
    }

    // Create a symbol table with given capacity.
    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        N = 0;
    }

    // Return the number of key-value pairs in the table.
    public int size() {
        return N;
    }

    // Return true if the table is empty and false otherwise.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Return true if the table contains key and false otherwise.
    public boolean contains(Key key) {
        if (isEmpty())
            return false;
        for (int i = 0; i < size(); i++)
            if (key.equals(keys[i]))
                return true;
        return false;
    }

    // Return the value associated with key, or null.
    public Value get(Key key) {
        for (int i = 0; i < size(); i++)
            if (key.equals(keys[i]))
                return values[i];
        return null;
    }

    // Put the key-value pair into the table; remove key from table
    // if value is null.
    public void put(Key key, Value value) {
        delete(key); // delete duplicate key
        if (N >= values.length)
            resize(2 * N);
        values[N] = value;
        keys[N] = key;
        N++;
    }

    // Remove key (and its value) from table.
    public void delete(Key key) {
        for (int i = 0; i < N; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[N - 1];
                values[i] = values[N - 1];
                keys[N - 1] = null;
                values[N - 1] = null;
                N--;
                if (N > 0 && N == keys.length / 4)
                    resize(keys.length / 2);

            }
        }
    }

    // Return all the keys in the table.
    public Iterable<Key> keys() {
        Stack<Key> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--)
            stack.push(keys[i]);
        return stack;
    }

    // Resize the internal arrays to capacity.
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            st.put(s, ++count);
        }
        for (String s : args) {
            st.delete(s);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
