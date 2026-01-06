public class DiscardBookRequest {

    private Book book;
    private String reason;

    public DiscardBookRequest(Book book, String reason) {
        this.book = book;
        this.reason = reason;
    }

    public Book getBook() {
        return book;
    }

    public String getReason() {
        return reason;
    }
}
