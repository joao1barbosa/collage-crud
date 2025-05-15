import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== COLLAGE CRUD ===");
            System.out.println("1. Login");
            System.out.println("2. Sair");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Screens.login();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}