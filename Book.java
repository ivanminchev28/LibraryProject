public class Book {

    private int inventoryNumber;
    private String title;
    private String author;
    private String genre;

    private BookStatus status;
    private BookCondition condition;
    private boolean forReadingRoomOnly;

    public Book(int inventoryNumber,
                String title,
                String author,
                String genre,
                boolean forReadingRoomOnly) {

        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.forReadingRoomOnly = forReadingRoomOnly;

        this.status = BookStatus.AVAILABLE;
        this.condition = BookCondition.GOOD;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public BookStatus getStatus() {
        return status;
    }

    public BookCondition getCondition() {
        return condition;
    }

    public boolean isForReadingRoomOnly() {
        return forReadingRoomOnly;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    public void borrow() {
        status = BookStatus.BORROWED;
    }

    public void returnBook() {
        status = BookStatus.AVAILABLE;
    }

    public void archive() {
        status = BookStatus.ARCHIVED;
        forReadingRoomOnly = true;
    }

    public void discard() {
        status = BookStatus.DISCARDED;
    }

    public void damage() {
        condition = BookCondition.DAMAGED;
    }

    @Override
    public String toString() {
        return inventoryNumber + " | " + title + " - " + author;
    }
}
