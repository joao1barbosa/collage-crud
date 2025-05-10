package service;

import dao.StudentDAO;
import model.Student;
import util.RegistrationGenerator;

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

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
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
