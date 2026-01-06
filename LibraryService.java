import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public void registerReader(Reader reader) {
        readers.add(reader);
        System.out.println("Reader registered.");
    }

    public void approveReader(int readerId) {
        for (Reader r : readers) {
            if (r.getId() == readerId) {
                r.approve();
                System.out.println("Reader approved.");
                return;
            }
        }
        System.out.println("Reader not found.");
    }

    public void addBook(AddBookRequest request) {
        Book book = new Book(
                request.getInventoryNumber(),
                request.getTitle(),
                request.getAuthor(),
                request.getGenre(),
                request.isForReadingRoomOnly()
        );
        books.add(book);
        System.out.println("Book added.");
    }

    public void borrowBook(BorrowBookRequest request) {

        Reader reader = request.getReader();
        Book book = request.getBook();
        BorrowType type = request.getBorrowType();

        if (!reader.isApproved()) {
            System.out.println("Reader not approved.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        if (book.isForReadingRoomOnly() && type == BorrowType.TAKE_HOME) {
            System.out.println("Book is for reading room only.");
            return;
        }

        book.borrow();
        reader.getBorrowedBooks().add(book);

        System.out.println("Book borrowed: " + type);
    }

    public void returnBook(ReturnBookRequest request) {

        Reader reader = request.getReader();
        Book book = request.getBook();

        if (reader.getBorrowedBooks().remove(book)) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed by the reader.");
        }
    }

    public void discardBook(DiscardBookRequest request) {

        Book book = request.getBook();

        if (book.getStatus() == BookStatus.BORROWED) {
            System.out.println("Cannot discard a borrowed book.");
            return;
        }

        book.discard();
        System.out.println("Book discarded. Reason: " + request.getReason());
    }

    public Reader createReaderProfile(ReaderRegistrationRequest request) {
        request.approve();

        Reader reader = new Reader(request.getReaderId(), request.getName());
        readers.add(reader);

        System.out.println("Reader profile created.");
        return reader;
    }

    public ArchiveNotification checkForArchiving(Book book) {

        if (book.getCondition() == BookCondition.DAMAGED) {
            return new ArchiveNotification(book);
        }
        return null;
    }

    public void addBookDirect(Book book) {
        books.add(book);
    }

    public void checkOverdueBooks(Reader reader) {
        for (BorrowRecord record : reader.getBorrowRecords()) {
            if (record.isOverdue()) {
                System.out.println("Overdue book: "
                        + record.getBook() + " | Days: " + record.overdueDays());
                reader.setRating(UserRating.DISLOYAL);
            }
        }
    }
}