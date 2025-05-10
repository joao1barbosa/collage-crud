package service;

import dao.StudentDAO;
import model.Student;
import model.User;
import util.RegistrationGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public void createStudent(Student student) {
        student.setRegistration(RegistrationGenerator.createRegistration());
        studentDAO.create(student);
    }

    public List<Student> getAllStudents(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if(user.isAdmin()){
            return studentDAO.findAll();
        }

        Student student = studentDAO.findByRegistration(user.getStudentRegistration());
        return student != null ? Collections.singletonList(student) : Collections.emptyList();

    }

    public Student getStudentByRegistration(int registration) {
        return studentDAO.findByRegistration(registration);
    }

    public Student getStudentByName(String name) {
        return studentDAO.findByName(name);
    }

    public void updateStudent(Student student) {
        if (student.getRegistration() <= 0) {
            throw new IllegalArgumentException("Matrícula inválida para atualização");
        }
        studentDAO.update(student);
    }

    public void deleteStudent(int registration) {
        if (registration <= 0) {
            throw new IllegalArgumentException("Matrícula inválida para remoção");
        }
        studentDAO.delete(registration);
    }

}
