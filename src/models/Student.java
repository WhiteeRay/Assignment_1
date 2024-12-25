package models;

import java.util.ArrayList;
import java.util.Comparator;

public class Student extends Person {
    private int id;
    static int id_gen;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        id = ++id_gen;
    }

    public int getId() {
        return id;
    }

    public void addGrades(int grade) {
        grades.add(grade);
    }

    public double calculateGpa() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return overallToGpa((int)(sum / grades.size()));
    }

    private static double overallToGpa(int overall) {
        overall -= overall % 5;
        switch (overall) {
            case (100):
                return 4.0;
            case (95):
                return 4.0;
            case (90):
                return 3.67;
            case (85):
                return 3.33;
            case (80):
                return 3.0;
            case (75):
                return 2.67;
            case (70):
                return 2.33;
            case (65):
                return 2.0;
            case (60):
                return 1.67;
            case (55):
                return 1.33;
            case (50):
                return 1.0;
            default:
                return 0;
        }
    }
    public static Comparator<Student> compareGpa () {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.calculateGpa() < s2.calculateGpa()) return 1;
                if (s1.calculateGpa() > s2.calculateGpa()) return -1;
                return s1.getSurname().compareTo(s2.getSurname());
            }
        };
    }

    @Override
    public String toString(){
        return super.toString() + "I am a student with ID " + id + ".";
    }

}
