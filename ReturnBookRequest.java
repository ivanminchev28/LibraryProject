public class ReturnBookRequest {

    private Reader reader;
    private Book book;

    public ReturnBookRequest(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }
}
