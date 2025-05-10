package database.seeder;

import model.Student;
import service.StudentService;
import util.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class StudentSeeder {
    public static void run(){
        StudentService service = new StudentService();
        List<String> courses = CoursesProvider.getCourses();

        String[] names = {
                "João Barbosa",
                "Beatriz Cavalcante",
                "Gabriela Cézar",
                "Ana Souza",
                "Paulo Silva"
        };

        String[] cpfs = {
                "529.982.247-25",
                "157.508.380-07",
                "834.761.090-34",
                "423.594.680-01",
                "701.236.540-49",
        };

        for(int i =0; i < courses.size(); i++){
            Student student = new Student();

            student.setRegistration(RegistrationGenerator.createRegistration());
            student.setName(names[i]);
            student.setPhone("(62) 9" + (10000000 + new Random().nextInt(9000000)));
            student.setBirthdate(Date.valueOf(LocalDate.of(
                    2000+ i,
                    new Random().nextInt(11) + 1,
                    new Random().nextInt(27) + 1
            )));
            student.setCourse(courses.get(i));
            student.setCpf(cpfs[i]);

            service.createStudent(student);
        }
    }
}
