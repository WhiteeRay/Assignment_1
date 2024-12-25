package models;

import java.util.ArrayList;

import static models.Student.compareGpa;

public class School {
    ArrayList<Person> members = new ArrayList<>();

    public void addMembers(Person member) {
        members.add(member);
    }

    public void giveRaise(int n) {
        System.out.println("Raised salary for teacher: ");
        for (Person member : members) {
            if (member instanceof Teacher) {
                if (((Teacher) member).getYearsOfExperience() > 10) {
                    int prevSalary = ((Teacher) member).getSalary();
                    ((Teacher) member).giveRaise(n);
                    System.out.println(member.getName() + " " + member.getSurname() + "'s salary raised from "
                            + prevSalary + " to " + ((Teacher) member).getSalary() + ". ");
                }
            }
        }
        System.out.println();
    }

    public void outputStudents() {
        System.out.println("List of the students with GPA: ");
        for (Person member : members) {
            if (member instanceof Student) {
                System.out.println(member + " I have a GPA of " + (((Student) member).calculateGpa()) + ".");

            }
        }
        System.out.println();
    }

    public void outputTeachers() {
        System.out.println("List of the Teachers: ");
        for (Person member : members) {
            if (member instanceof Teacher) {
                System.out.println(member);
            }
        }
        System.out.println();
    }

    public void sortStudents() {
        System.out.println("Sorted list of the students: ");
        ArrayList<Student> students = new ArrayList<>();
        for (Person member : members) {
            if (member instanceof Student) {
                students.add((Student) member);
            }
        }
        students.sort(Student.compareGpa());
        for (Student student : students) {
            System.out.println(student + " With the GPA of " + student.calculateGpa());
        }
        // 🐝


    }
}

