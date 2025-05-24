package view;

import model.CollageClass;
import model.Student;
import model.User;
import service.CollageClassService;

import java.util.List;
import java.util.Scanner;

public class CollageClassView {
    private static final CollageClassService service = new CollageClassService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void createClass(User user) {
        CollageClass collageClass = new CollageClass();

        System.out.println("\n=== Cadastrar nova turma ===");
        System.out.print("Nome da turma: ");
        collageClass.setName(scanner.nextLine());

        System.out.print("Curso: ");
        collageClass.setCourse(scanner.nextLine());

        System.out.print("Turno: ");
        collageClass.setShift(scanner.nextLine());

        service.createClass(collageClass, user);
        System.out.println("Turma cadastrada com sucesso!");
    }

    public static void listAllClasses(User user) {
        System.out.println("\n=== Todas as turmas ===");
        List<CollageClass> classes = service.getAllClasses(user);

        for (CollageClass c : classes) {
            System.out.println(c.toString());
            System.out.println("-------------------------------------------------");
        }
    }

    public static void addStudentToClass(User user) {
        System.out.print("Digite a matrícula do aluno: ");
        int registration = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o ID da turma: ");
        int classId = Integer.parseInt(scanner.nextLine());

        service.addStudentToClass(registration, classId, user);
        System.out.println("Aluno adicionado à turma com sucesso.");
    }

    public static void listStudentsByClass(User user) {
        System.out.print("Digite o ID da turma: ");
        int classId = Integer.parseInt(scanner.nextLine());

        List<Student> students = service.getStudentsByClassId(classId, user);

        System.out.println("\n=== Alunos na turma ===");
        for (Student student : students) {
            System.out.println(student.toString());
            System.out.println("-------------------------------------------------");
        }
    }

    public static void removeStudentFromClass(User user) {
        System.out.print("Digite a matrícula do aluno: ");
        int registration = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o ID da turma: ");
        int classId = Integer.parseInt(scanner.nextLine());

        service.removeStudentFromClass(registration, classId, user);
        System.out.println("Aluno removido da turma com sucesso.");
    }

    public static void viewMyClasses(User user) {
        System.out.println("\n=== Suas turmas ===");
        List<CollageClass> classes = service.getClassesByStudent(user);

        for (CollageClass c : classes) {
            System.out.println(c.toString());
            System.out.println("-------------------------------------------------");
        }
    }
}
