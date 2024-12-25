import models.*;

import java.io.*;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        School aitu = new School();
        String file = "C:\\Users\\AEI\\IdeaProjects\\Assignment_1\\src\\Students.txt";
        String file2 = "C:\\Users\\AEI\\IdeaProjects\\Assignment_1\\src\\Teachers.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            Student student = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
            for (int i = 4; i < parts.length; i++) {
                student.addGrades(Integer.parseInt(parts[i]));
            }
            aitu.addMembers(student);
        }
        br.close();

        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String line2;
        while((line2 = br2.readLine()) != null){
            String[] parts = line2.split(" ");
            Teacher teacher = new Teacher(parts[0], parts[1],Integer.parseInt(parts[2]), parts[3], parts[4],
                    Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
            aitu.addMembers(teacher);

        }
        br2.close();



        aitu.outputTeachers();
        aitu.giveRaise(30);
        aitu.outputStudents();
        aitu.sortStudents();


    }
}
