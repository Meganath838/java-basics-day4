import java.util.Scanner;

class Demo7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;
        String[] names = new String[n];
        int[] marks = new int[n];

        // Input student details
        System.out.println("Enter student names and marks:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = sc.nextLine();

            System.out.print("Marks: ");
            marks[i] = sc.nextInt();
            sc.nextLine(); // consume newline
        }

        // Find topper
        int max = marks[0];
        int topperIndex = 0;

        for (int i = 1; i < n; i++) {
            if (marks[i] > max) {
                max = marks[i];
                topperIndex = i;
            }
        }

        System.out.println("\nTopper: " + names[topperIndex] + " with marks " + max);

        // Search student by name
        System.out.print("\nEnter name to search: ");
        String search = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (names[i].equalsIgnoreCase(search)) {
                System.out.println("Student Found: " + names[i] + " - Marks: " + marks[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }

        // Display students with marks > 75
        System.out.println("\nStudents with marks greater than 75:");
        for (int i = 0; i < n; i++) {
            if (marks[i] > 75) {
                System.out.println(names[i] + " - " + marks[i]);
            }
        }

        // Calculate class average
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += marks[i];
        }

        double average = (double) sum / n;
        System.out.println("\nClass Average: " + average);

        // Sort students by marks (Descending)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (marks[i] < marks[j]) {
                    // swap marks
                    int tempMarks = marks[i];
                    marks[i] = marks[j];
                    marks[j] = tempMarks;

                    // swap names
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        // Display sorted list
        System.out.println("\nStudents sorted by marks (High to Low):");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }

        sc.close();
    }
}
