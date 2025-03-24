package com.kishor.main;

import com.kishor.dao.StudentDAO;
import com.kishor.model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nStudent Management System:");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Update Student Marks");
			System.out.println("4. Delete Student");
			System.out.println("5. Search Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Name: ");
				scanner.nextLine();
				String name = scanner.nextLine();

				System.out.print("Enter Age: ");
				int age = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Course: ");
				String course = scanner.nextLine();

				System.out.print("Enter Marks: ");
				int marks = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Present (Type-Yes/No): ");
				String presenty = scanner.nextLine();

				dao.addStudent(new Student(0, name, age, course, marks, presenty));

				break;
			case 2:
				List<Student> students = dao.getAllStudents();

				for (Student student : students) {
					System.out.println("ID: " + student.getId() + "  Name: " + student.getName() + "  Age: "
							+ student.getAge() + "  Course: " + student.getCourse() + "  Marks: " + student.getMarks()
							+ "  Present: " + student.getPresenty());
					System.out.println(
							"----------------------------------------------------------------------------------------------------");
				}
				break;
			case 3:
				System.out.print("Enter Student ID: ");
				scanner.nextLine();
				int id = scanner.nextInt();
				System.out.println("Enter new Name: ");
				String names = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter new Age: ");
				int ages = scanner.nextInt();
				System.out.println("Enter new Course: ");
				scanner.nextLine();
				String courses = scanner.next();
				System.out.print("Enter New Marks: ");
				int newMarks = scanner.nextInt();
				dao.updateStudent(id, names, ages, courses, newMarks);
				break;
			case 4:
				System.out.print("Enter Student ID: ");
				int deleteId = scanner.nextInt();
				dao.deleteStudent(deleteId);
				break;
			case 5:
			    System.out.print("Enter name, course, or presenty to search: ");
			    scanner.nextLine(); // Consume leftover newline
			    String keyword = scanner.nextLine();

			    List<Student> searchResults = dao.searchStudents(keyword);

			    if (searchResults.isEmpty()) {
			        System.out.println("No students found with the given keyword.");
			    } else {
			        for (Student student : searchResults) {
			            System.out.println("ID: " + student.getId() +
			                    ", Name: " + student.getName() +
			                    ", Age: " + student.getAge() +
			                    ", Course: " + student.getCourse() +
			                    ", Percentage: " + student.getMarks() +
			                    ", Presenty: " + student.getPresenty());
			        }
			    }
			    break;


			case 6:
				System.out.println("Exiting...");
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
