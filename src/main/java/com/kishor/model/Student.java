package com.kishor.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private int marks;
    private String presenty;

    public Student(int id, String name, int age, String course, int marks,String presenty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
        this.presenty=presenty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int getMarks() { return marks; }
    public String getPresenty() {return presenty;}
}


