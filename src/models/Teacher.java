package models;

public class Teacher extends Person {
    private String subject;
    public int yearsOfExperience;
    public int salary;


    public Teacher(String name, String surname, int age, String gender,
                   String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void giveRaise(int percent) {
        salary = (int) (salary * ((percent + 100) / 100.0));
    }


    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}
