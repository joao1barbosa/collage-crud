//TODO: move role verification to specific function 
package service;

import dao.StudentDAO;
import dto.StudentPublicDTO;
import model.Student;
import model.User;
import util.RegistrationGenerator;

import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public void createStudent(Student student, User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }
        student.setRegistration(RegistrationGenerator.createRegistration());
        studentDAO.create(student);
    }

    public List<Student> getAllStudents(User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }

        return studentDAO.findAll();
    }

    public Student getStudentByRegistration(int registration, User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }

        Student student = studentDAO.findByRegistration(registration);
        if (student == null) throw new RuntimeException("Usuário não encontrado");

        return student;
    }

    public StudentPublicDTO getOwnData(User user){
        StudentPublicDTO student = studentDAO.findOwnDataByRegistration(user.getStudentRegistration());
        if (student == null) throw new RuntimeException("Usuário não encontrado");

        return student;
    }

    public Student getStudentByName(String name, User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }

        return studentDAO.findByName(name);
    }

    public void updateStudent(Student student, User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }

        if (student.getRegistration() <= 0) {
            throw new IllegalArgumentException("Matrícula inválida para atualização");
        }

        studentDAO.update(student);
    }

    public void deleteStudent(int registration, User user) {
        if(!user.isAdmin()){
            throw new SecurityException("Acesso negado");
        }

        if (registration <= 0) {
            throw new IllegalArgumentException("Matrícula inválida para remoção");
        }
        studentDAO.delete(registration);
    }

}
