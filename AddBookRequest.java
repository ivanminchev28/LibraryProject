public class AddBookRequest {

    private int inventoryNumber;
    private String title;
    private String author;
    private String genre;
    private boolean forReadingRoomOnly;

    public AddBookRequest(int inventoryNumber, String title,
                          String author, String genre,
                          boolean forReadingRoomOnly) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.forReadingRoomOnly = forReadingRoomOnly;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isForReadingRoomOnly() {
        return forReadingRoomOnly;
    }
}

