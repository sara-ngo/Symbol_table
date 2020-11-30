// AvgGPA.java: Reads from standard input a list of letter grades and computes
// and prints the average GPA (the average of the numbers corresponding to
// the grades).

import edu.princeton.cs.algs4.StdIn;

public class AvgGPA {
    public static void main(String[] args) {
        int count = 0;
        double avg;
        double sum = 0.0;

        ArrayST<String, Double> gradeTable = new ArrayST<>();
        gradeTable.put("A+", 4.33);
        gradeTable.put("A", 4.00);
        gradeTable.put("A-", 3.67);
        gradeTable.put("B+", 3.33);
        gradeTable.put("B", 3.00);
        gradeTable.put("B-", 2.67);
        gradeTable.put("C+", 2.33);
        gradeTable.put("C", 2.00);
        gradeTable.put("C-", 1.67);
        gradeTable.put("D+", 1.35);
        gradeTable.put("D", 1.0);
        gradeTable.put("F", 0.00);

        while (!StdIn.isEmpty()) {
            String letter = StdIn.readString();
            Double gpa = gradeTable.get(letter);
            if (gpa == null)
                System.out.println("Invalid Letter Grade");
            else {
                sum += gpa;
                count++;
            }
        }
        avg = sum / count;
        System.out.println(avg);
    }
}
