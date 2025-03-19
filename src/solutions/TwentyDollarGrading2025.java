package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarGrading2025 {
    static class WilliamCommaSpace {
        String name;
        double[] grades;
        double average;
        public WilliamCommaSpace(String name, int length) {
            this.name = name;
            this.grades = new double[length];
            Arrays.fill(this.grades, Integer.MIN_VALUE);
            // sanity check: integer.min_value is used to define any exam that was not taken by the student
            // as according to the assignment, the assignments will never go below 0
        }
        public void addToGrade(int exam) {
            if(grades[exam] == Integer.MIN_VALUE) grades[exam] = 0;
            grades[exam]++;
        }
        public void calculateGradeFor(int exam, double length) {
            double grade = (this.grades[exam] / length) * 100;
            this.grades[exam] = grade;
        }
        public double average() {
            this.average = avg(this.grades);
            return this.average;
        }

        @Override
        public String toString() {
            String[] out = {""};
            Arrays.stream(grades)
                    .filter((e)->e>Integer.MIN_VALUE)
                    .boxed()
                    .sorted(Double::compareTo)
                    .sorted(Comparator.reverseOrder())
                // SORRY FOR THE SLOP ABOVE
                    .forEach((i) -> {
                out[0] += String.format("%.2f ", i);
            });
            return out[0];
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("grading.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        LinkedHashMap<String, WilliamCommaSpace> grades = new LinkedHashMap<>();
        int exam = 0;
        int highest = noSets;
        while(noSets-- > 0) {
            String keyForExam = scan.next();
            int numStudents = scan.nextInt();
            while(numStudents-->0) {
                String studentName = scan.next();
                String answers = scan.next();
                WilliamCommaSpace student = grades.getOrDefault(studentName, new WilliamCommaSpace(studentName, highest));
                for(int i = 0; i < answers.length(); i++) {
                    char one = keyForExam.charAt(i);
                    if(answers.charAt(i) == one) {
                        student.addToGrade(exam);
                    }
                }
                student.calculateGradeFor(exam, answers.length());
                grades.put(studentName, student);
            }
            exam++;
        }
        Comparator<Map.Entry<String, WilliamCommaSpace>> commaSpaceComparator = (a, b) -> (int) (b.getValue().average() - a.getValue().average());
        int[] i = {1};
        grades.entrySet().stream().sorted(commaSpaceComparator).forEach((e) -> {
            System.out.println("#"+(i[0]++)+": "+e.getKey() +", " + e.getValue());
            // sorry for the slop
        });
    }
    static double avg(double[] arr) {
        double av = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == Integer.MIN_VALUE) {
                len--;
                continue;
            };
            av += arr[i];
        }
        return av / len;
    }
}
