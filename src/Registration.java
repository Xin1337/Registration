import java.io.BufferedReader; // Used to read the file
import java.io.FileReader; // Used to read the file
import java.util.Scanner; // Used to get user input
import java.util.LinkedList; // Used to store the students
import java.io.FileWriter; // Used to save the students to the file
import java.io.IOException; // Used to catch the IOException

/**
 * @author Nixheh
 * @version 1.0
 * @since 2023-03-09
 * @see OOP
 * @see LinkedList
 * @see Scanner
 * @see System
 * Total hours spent on this project: 7 hours
 * Ayoko na mag IT
 * Patya nalang ko
 * Description: This program is a registration system that allows the user to add, view and remove students from the system.
 */

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n"); // Used Delimiter to prevent the scanner from skipping the next line.
        LinkedList<OOP> students = new LinkedList<>(); // Used LinkedList to store the students.

        // Load the students from the file
        try (FileReader reader = new FileReader("src/students.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader); // Used BufferedReader to read the file
            String line;
            while ((line = bufferedReader.readLine()) != null) { // Goes through the file and adds the students to the LinkedList
                String[] student = line.split(","); // Splits the line into an array
                // Add the student to the LinkedList
                students.add(new OOP(Integer.parseInt(student[1]), student[0], student[2], Integer.parseInt(student[3]), student[4], student[5], student[6]));
            }
            // Save the students to the file when the program exits
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    FileWriter writer = new FileWriter("src/students.txt"); // Used FileWriter to write to the file
                    for (OOP student : students) { // Goes through the LinkedList and saves the students to the file
                        writer.write(String.format("%s,%d,%s,%d,%s,%s,%s%n", student.getName(), student.getAge(), student.getGender(), student.getContactNumber(), student.getAddress(), student.getCourse(), student.getYear()));
                    }
                    writer.close();
                } catch (IOException e) { // Catches the IOException
                    System.out.println("Error saving students!");
                }
            }));
        }
        catch (Exception e) { // Catches the Exception
            System.out.println("Error loading students!");
        }

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
                            System.out.printf("Name: %s, Age: %d, Gender: %s, Contact Number: %d, Address: %s, Course: %s, Year: %s\n", student.getName(), student.getAge(), student.getGender(), student.getContactNumber(), student.getAddress(), student.getCourse(), student.getYear());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the student name: ");
                    String found = scanner.next(); // Gets the student name
                    // Check if the student exists
                    if (students.parallelStream().anyMatch(student -> student.getName().equalsIgnoreCase(found))) { // Thank you Denom for this line of code!
                        students.removeIf(student -> student.getName().equalsIgnoreCase(found)); //Removes the student from the LinkedList
                        System.out.printf("%s has been removed from the system!\n", found); // Prints out the student that has been removed
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
        }
    }
}