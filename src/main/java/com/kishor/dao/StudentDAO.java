package com.kishor.dao;

import com.kishor.model.Student;
import com.kishor.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, course, marks, presenty) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getCourse());
            stmt.setInt(4, student.getMarks());
            stmt.setString(5, student.getPresenty());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("course"), rs.getInt("marks"),rs.getString("presenty")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public List<Student> searchStudents(String keyword) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name ILIKE ? OR course ILIKE ? OR CAST(age AS TEXT) ILIKE ? OR CAST(marks AS TEXT) ILIKE ? OR presenty ILIKE ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameters for all 5 placeholders
            for (int i = 1; i <= 5; i++) {
                stmt.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course"),
                    rs.getInt("marks"),
                    rs.getString("presenty")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to fetch student data.");
        }
        return students;
    }




    public void updateStudent(int id, String name, int age, String course, int marks) {
        String sql = "UPDATE students SET name =?,age=?,course=?,marks = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, name);
        	stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, marks);
            stmt.setInt(5, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student updated!" : "Student not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted!" : "Student not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<Student> searchStudents1(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
