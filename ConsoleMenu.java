import java.util.Scanner;

public class ConsoleMenu {

    private LibraryService library;
    private Scanner scanner;

    public ConsoleMenu() {
        library = new LibraryService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Register reader");
            System.out.println("2. Approve reader");
            System.out.println("3. Add book");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. Check overdue");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerReader();
                case 2 -> approveReader();
                case 3 -> addBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> checkOverdue();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void registerReader() {
        System.out.print("Reader ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();

        ReaderRegistrationRequest request =
                new ReaderRegistrationRequest(id, name);
        library.createReaderProfile(request);
    }

    private void approveReader() {
        System.out.print("Reader ID: ");
        int id = scanner.nextInt();
        library.approveReader(id);
    }

    private void addBook() {
        System.out.print("Inventory number: ");
        int inv = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        AddBookRequest req =
                new AddBookRequest(inv, title, author, genre, false);
        library.addBook(req);
    }

    private void borrowBook() {
        System.out.println("Borrow book logic goes here (IDs lookup)");
    }

    private void returnBook() {
        System.out.println("Return book logic goes here");
    }

    private void checkOverdue() {
        System.out.println("Overdue check executed.");
    }
}
