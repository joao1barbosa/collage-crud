package view;

import dto.StudentPublicDTO;
import model.*;
import service.StudentService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static StudentService studentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void createStudent(User user){
        Student student = new Student();

        System.out.println("\n=== Buscar aluno ===");
        System.out.println("-------------------------------------------------");

        System.out.print("Nome: ");
        student.setName(scanner.nextLine());

        System.out.print("Telefone: ");
        student.setPhone(scanner.nextLine());

        System.out.print("Aniversário: ");
        String date = scanner.nextLine();
        student.setBirthdate(Date.valueOf(
                LocalDate.parse(date,formatter)
        ));

        System.out.print("Curso: ");
        student.setCourse(scanner.nextLine());

        System.out.print("CPF: ");
        student.setCpf(scanner.nextLine());

        System.out.println("-------------------------------------------------");

        studentService.createStudent(student, user);
    }

    public static void listAllStudents(User user){
        List<Student> students = studentService.getAllStudents(user);

        System.out.println("\n=== Todos os alunos ===");
        System.out.println("-------------------------------------------------");

        for (Student student : students) {
            System.out.print(student.toString());
            System.out.println("-------------------------------------------------");
        }
    }

    public static void findByRegistration(User user) {
        System.out.print("Digite o número da matrícula: ");
        int registration = Integer.parseInt(scanner.nextLine());

        Student student = studentService.getStudentByRegistration(registration, user);
        System.out.println("\n=== Aluno encontrado ===");
        System.out.println(student.toString());
    }

    public static void viewOwnData(User user) {
        StudentPublicDTO student = studentService.getOwnData(user);

        System.out.println("\n=== Seus dados ===");
        System.out.print(student.toString());
    }

    public static void findByName(User user) {
        System.out.print("Digite o nome do aluno: ");
        String name = scanner.nextLine();

        Student student = studentService.getStudentByName(name, user);
        System.out.println("\n=== Aluno encontrado ===");
        System.out.println(student.toString());
    }

    public static void updateStudent(User user) {
        System.out.print("Digite a matrícula do aluno que deseja atualizar: ");
        int registration = Integer.parseInt(scanner.nextLine());

        Student student = studentService.getStudentByRegistration(registration, user);

        System.out.println("Deixe em branco para manter o valor atual.");

        System.out.print("Nome (" + student.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) student.setName(name);

        System.out.print("Telefone (" + student.getPhone() + "): ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) student.setPhone(phone);

        System.out.print("Aniversário (" + student.getBirthdate() + ") [yyyy-MM-dd]: ");
        String birthdate = scanner.nextLine();
        if (!birthdate.isBlank())
            student.setBirthdate(Date.valueOf(LocalDate.parse(birthdate, formatter)));

        System.out.print("Curso (" + student.getCourse() + "): ");
        String course = scanner.nextLine();
        if (!course.isBlank()) student.setCourse(course);

        System.out.print("CPF (" + student.getCpf() + "): ");
        String cpf = scanner.nextLine();
        if (!cpf.isBlank()) student.setCpf(cpf);

        studentService.updateStudent(student, user);
        System.out.println("Aluno atualizado com sucesso!");
    }

    public static void deleteStudent(User user) {
        System.out.print("Digite a matrícula do aluno que deseja excluir: ");
        int registration = Integer.parseInt(scanner.nextLine());

        System.out.print("Tem certeza que deseja remover este aluno? (s/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("s")) {
            studentService.deleteStudent(registration, user);
            System.out.println("Aluno removido com sucesso.");
            return;
        }

        System.out.println("Operação cancelada.");
    }
}
