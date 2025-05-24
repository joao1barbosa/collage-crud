package service;

import dao.CollageClassDAO;
import dao.StudentDAO;
import dao.UserClassDAO;
import model.CollageClass;
import model.Student;
import model.User;

import java.util.List;

public class CollageClassService {
    private final CollageClassDAO collageClassDAO;
    private final UserClassDAO userClassDAO;
    private final StudentDAO studentDAO;

    public CollageClassService() {
        this.collageClassDAO = new CollageClassDAO();
        this.userClassDAO = new UserClassDAO();
        this.studentDAO = new StudentDAO();
    }

    public void createClass(CollageClass collageClass, User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Acesso negado");
        }
        collageClassDAO.create(collageClass);
    }

    public List<CollageClass> getAllClasses(User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Acesso negado");
        }
        return collageClassDAO.findAll();
    }

    public void addStudentToClass(int registration, int classId, User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Acesso negado");
        }
        userClassDAO.addUserToClass(getIdByRegistration(registration), classId);
    }

    public List<Student> getStudentsByClassId(int classId, User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Acesso negado");
        }
        return userClassDAO.findStudentsByClass(classId);
    }

    public void removeStudentFromClass(int registration, int classId, User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Acesso negado");
        }

        userClassDAO.deleteUserFromClass(getIdByRegistration(registration), classId);
    }

    public List<CollageClass> getClassesByStudent(User user) {
        return userClassDAO.findClassesByUser(user.getId());
    }

    private int getIdByRegistration(int registration){
        return studentDAO.findIdByRegistration(registration);
    }
}
