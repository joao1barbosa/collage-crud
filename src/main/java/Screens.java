import model.User;
import service.AuthService;
import service.StudentService;
import dao.UserDAO;
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
            System.out.println("1. Listar todos alunos");
            System.out.println("2. Buscar aluno por matrícula");
            System.out.println("3. Cadastrar novo aluno");
            System.out.println("4. Atualizar aluno");
            System.out.println("5. Remover aluno");
            System.out.println("6. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (choice) {
                case 1:
                    studentService.getAllStudents(admin);
                    break;
                case 2:
                    searchStudentByRegistration(admin);
                    break;
                case 3:
                    createStudent(admin);
                    break;
                case 4:
                    updateStudent(admin);
                    break;
                case 5:
                    deleteStudent(admin);
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
            System.out.println("2. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewMyStudent(user);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
