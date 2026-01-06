public class ArchiveNotification {

    private Book book;
    private String message;

    public ArchiveNotification(Book book) {
        this.book = book;
        this.message = "Book requires archiving (old or worn edition).";
    }

    public Book getBook() {
        return book;
    }

    public String getMessage() {
        return message;
    }
}
