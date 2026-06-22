import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reader extends User {

    private boolean approved;
    private LocalDate approvalDate;
    private List<Book> borrowedBooks;
    private List<BorrowRecord> borrowRecords;
    private UserRating rating;

    public Reader(int id, String name) {
        super(id, name);
        this.approved = false;
        this.borrowedBooks = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
        this.rating = UserRating.REGULAR;
    }

    public boolean isApproved() {
        return approved;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public UserRating getRating() {
        return rating;
    }

    public void approve() {
        approved = true;
        approvalDate = LocalDate.now();
    }

    public void setRating(UserRating rating) {
        this.rating = rating;
    }

    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    @Override
    public String toString() {
        return id + " | " + name + " (" + rating + ")";
    }
}