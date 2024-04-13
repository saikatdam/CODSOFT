import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject
        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];

        for (int index = 0; index < numSubjects; index++) {
            System.out.print("Enter marks for subject " + (index + 1) + ": ");
            marks[index] = scanner.nextInt();
        }

       
        int totMarks = 0;
        for (int mark : marks) {
            totMarks += mark;
        }

        
        double averagePercentage = (double) totMarks / numSubjects;

       
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

      
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
