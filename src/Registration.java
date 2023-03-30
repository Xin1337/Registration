import java.util.Scanner;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dominic
 * @version 1.0
 * @since 2023-03-09
 * @see OOP
 * @see LinkedList
 * @see Scanner
 * @see System
 * Total hours spent on this project: 3 hours
 * Ayoko na mag IT
 * Patya nalang ko
 * Description: This program is a registration system that allows the user to add, view and remove students from the system.
 */

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); // Used Delimiter to prevent the scanner from skipping the next line.
        LinkedList<OOP> students = new LinkedList<>(); // Used LinkedList to store the students.

        // Main loop
        while (true) {
            System.out.println("Welcome to the registration system!");
            System.out.println("1. Add student");
            System.out.println("2. View Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            // User input
            int choice = scanner.nextInt();
            // Switch statement
            switch (choice) {
                // Add student
                case 1:
                    System.out.println("Enter the student name: ");
                    String name = scanner.next();
                    System.out.println("Enter the student age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter Gender: ");
                    String gender = scanner.next();
                    System.out.println("Enter the student contact number: ");
                    int contactNumber = scanner.nextInt();
                    System.out.println("Enter the student address: ");
                    String address = scanner.next();
                    System.out.println("Enter the student course: ");
                    String course = scanner.next();
                    System.out.println("Enter the student year: ");
                    String year = scanner.next();
                    // Check if the student already exists
                    if (students.parallelStream().anyMatch(student -> student.getName().equalsIgnoreCase(name))) { // Thank you Denom for this line of code!
                        System.out.println("Student already exists!");
                    } else {
                        // Add the student to the LinkedList
                        students.add(new OOP(age, name, gender, contactNumber, address, course, year));
                        System.out.printf("%s has been added to the system!\n", name);
                    }
                    break;
                case 2:
                    // Check if the LinkedList is empty
                    if (students.size() == 0) {
                        System.out.println("No student in the system!");
                    } else {
                        // Print out the students
                        for (OOP student : students) { //Goes through the LinkedList and prints out the students
                            System.out.printf("Name: %s, Age: %s, Gender: %s, Contact Number: %s, Address: %s, Course: %s, Year: %s\n", student.getName(), student.getAge(), student.getGender(), student.getContactNumber(), student.getAddress(), student.getCourse(), student.getYear());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the student name: ");
                    String found = scanner.next();
                    // Check if the student exists
                    if (students.parallelStream().anyMatch(student -> student.getName().equalsIgnoreCase(found))) { // Thank you Denom for this line of code!
                        students.removeIf(student -> student.getName().equalsIgnoreCase(found)); //Removes the student from the LinkedList
                        System.out.printf("%s has been removed from the system!\n", found);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            try {
                FileWriter fileWriter = new FileWriter("src/students.txt");
                for (OOP student : students) {
                    String data = student.getName() + "," + student.getAge() + "," + student.getGender() + "," + student.getContactNumber() + "," + student.getAddress() + "," + student.getCourse() + "," + student.getYear() + "," + "\n";
                    fileWriter.write(data);
                }
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
