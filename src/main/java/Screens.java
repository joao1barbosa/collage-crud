import model.User;
import service.AuthService;
import service.StudentService;
import dao.UserDAO;
import view.CollageClassView;
import view.StudentView;

import java.util.Scanner;

public class Screens {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService(new UserDAO());
    private static StudentService studentService = new StudentService();

    public static void login() {
        System.out.print("\nUsuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        try {
            User user = authService.authenticate(username, password);
            if (user.isAdmin()) {
                adminMenu(user);
            } else {
                userMenu(user);
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
        }
    }

    private static void adminMenu(User admin) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Página de Alunos");
            System.out.println("2. Página de Turmas");
            System.out.println("3. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentsPage(admin);
                    break;
                case 2:
                    classesPage(admin);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void studentsPage(User admin){
        while (true) {
            System.out.println("\n=== Páginas de Alunos ===");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Listar todos alunos");
            System.out.println("3. Buscar aluno por matrícula");
            System.out.println("4. Buscar aluno por nome");
            System.out.println("5. Editar aluno");
            System.out.println("6. Remover aluno");
            System.out.println("7. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StudentView.createStudent(admin);
                    break;
                case 2:
                    StudentView.listAllStudents(admin);
                    break;
                case 3:
                    StudentView.findByRegistration(admin);
                    break;
                case 4:
                    StudentView.findByName(admin);
                    break;
                case 5:
                    StudentView.updateStudent(admin);
                    break;
                case 6:
                    StudentView.deleteStudent(admin);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void classesPage(User admin){
        while (true) {
            System.out.println("\n=== Páginas de Turmas ===");
            System.out.println("1. Cadastrar nova turma");
            System.out.println("2. Listar todas as turmas");
            System.out.println("3. Adicionar aluno à turma");
            System.out.println("4. Listar alunos de uma turma");
            System.out.println("5. Remover aluno de uma turma");
            System.out.println("6. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CollageClassView.createClass(admin);
                    break;
                case 2:
                    CollageClassView.listAllClasses(admin);
                    break;
                case 3:
                    CollageClassView.addStudentToClass(admin);
                    break;
                case 4:
                    CollageClassView.listStudentsByClass(admin);
                    break;
                case 5:
                    CollageClassView.removeStudentFromClass(admin);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void userMenu(User user) {
        while (true) {
            System.out.println("\n=== MENU USUÁRIO ===");
            System.out.println("1. Ver meus dados");
            System.out.println("2. Ver minhas turmas");
            System.out.println("3. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StudentView.viewOwnData(user);
                    break;
                case 2:
                    CollageClassView.viewMyClasses(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
