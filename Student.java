import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private double cgpa;

    public void insert(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("CGPA: " + cgpa);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student List");
            System.out.println("3. Search Student by Name/ID");
            System.out.println("4. Edit Student Information");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("How many students to insert? ");
                    int N = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < N; i++) {
                        System.out.println("Enter the details of student " + (i + 1));
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("ID: ");
                        int ID = Integer.parseInt(sc.nextLine());
                        System.out.print("CGPA: ");
                        double cgpa = Double.parseDouble(sc.nextLine());
                        Student newStudent = new Student();
                        newStudent.insert(name, ID, cgpa);
                        studentList.add(newStudent);
                    }
                    break;

                case 2:
                    // Display Student List
                    System.out.println("\nStudent List:");
                    for (Student student : studentList) {
                        student.display();
                    }
                    break;

                case 3:
                    // Search Student by Name/ID
                    System.out.print("Enter student name or ID to search: ");
                    String searchTerm = sc.nextLine();
                    boolean found = false;
                    for (Student student : studentList) {
                        if (student.getName().equalsIgnoreCase(searchTerm) || String.valueOf(student.getId()).equalsIgnoreCase(searchTerm)) {
                            System.out.println("Student found: ");
                            student.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Edit Student Information
                    System.out.print("Enter student name or ID to edit: ");
                    String editTerm = sc.nextLine();
                    for (Student student : studentList) {
                        if (student.getName().equalsIgnoreCase(editTerm) || String.valueOf(student.getId()).equalsIgnoreCase(editTerm)) {
                            System.out.print("Enter new student name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new student ID: ");
                            int newId = Integer.parseInt(sc.nextLine());
                            
                            System.out.print("Enter new student CGPA: ");
                            double newCgpa = Double.parseDouble(sc.nextLine());
                            student.insert(newName, newId, newCgpa);
                            System.out.println("Student information updated.");
                            break;
                        }
                    }
                    break;

                case 5:
                    // Delete Student
                    
                    System.out.print("Enter student name or ID to delete: ");
                    String deleteTerm = sc.nextLine();
                    Iterator<Student> iterator = studentList.iterator();
                    while (iterator.hasNext()) {
                        Student student = iterator.next();
                        if (student.getName().equalsIgnoreCase(deleteTerm) || String.valueOf(student.getId()).equalsIgnoreCase(deleteTerm)) {
                            iterator.remove();
                            System.out.println("Student deleted.");
                            break;
                        }
                    }
                    break;

                case 6:
                    // Exit
                    sc.close();
                    System.out.println("Exiting Student Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
