import java.time.LocalDate;

public class BorrowRecord {

    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowRecord(Book book, int daysAllowed) {
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(daysAllowed);
    }

    public Book getBook() {
        return book;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    public long overdueDays() {
        if (!isOverdue()) return 0;
        return java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }
}
