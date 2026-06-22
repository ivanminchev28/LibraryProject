import java.util.Scanner;

public class ConsoleMenu {

    private LibraryService library;
    private Scanner scanner;

    public ConsoleMenu() {
        library = new LibraryService();
        scanner = new Scanner(System.in);
        DataSeeder.seed(library); // Pre-load test values instantly
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
            System.out.print("Select an option: ");

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

        ReaderRegistrationRequest request = new ReaderRegistrationRequest(id, name);
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

        AddBookRequest req = new AddBookRequest(inv, title, author, genre, false);
        library.addBook(req);
    }

    private void borrowBook() {
        System.out.print("Enter Reader ID: ");
        int readerId = scanner.nextInt();
        System.out.print("Enter Book Inventory Number: ");
        int invNum = scanner.nextInt();
        System.out.print("Type (1 for READING_ROOM, 2 for TAKE_HOME): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        BorrowType type = (typeChoice == 1) ? BorrowType.READING_ROOM : BorrowType.TAKE_HOME;

        Reader reader = library.findReaderById(readerId);
        Book book = library.findBookByInventoryNumber(invNum);

        if (reader != null && book != null) {
            BorrowBookRequest req = new BorrowBookRequest(reader, book, type);
            library.borrowBook(req);
        } else {
            System.out.println("Reader or Book not found in system.");
        }
    }

    private void returnBook() {
        System.out.print("Enter Reader ID: ");
        int readerId = scanner.nextInt();
        System.out.print("Enter Book Inventory Number: ");
        int invNum = scanner.nextInt();
        scanner.nextLine();

        Reader reader = library.findReaderById(readerId);
        Book book = library.findBookByInventoryNumber(invNum);

        if (reader != null && book != null) {
            ReturnBookRequest req = new ReturnBookRequest(reader, book);
            library.returnBook(req);
        } else {
            System.out.println("Reader or Book not found.");
        }
    }

    private void checkOverdue() {
        System.out.print("Enter Reader ID to check: ");
        int readerId = scanner.nextInt();
        scanner.nextLine();

        Reader reader = library.findReaderById(readerId);
        if (reader != null) {
            library.checkOverdueBooks(reader);
        } else {
            System.out.println("Reader not found.");
        }
    }
}