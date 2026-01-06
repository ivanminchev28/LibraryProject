public class BorrowBookRequest extends Form {

    private Reader reader;
    private Book book;
    private BorrowType borrowType;

    public BorrowBookRequest(Reader reader, Book book, BorrowType borrowType) {
        super();
        this.reader = reader;
        this.book = book;
        this.borrowType = borrowType;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public BorrowType getBorrowType() {
        return borrowType;
    }
}
