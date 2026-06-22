public class RatingService {

    public void updateRating(Reader reader) {
        int historicalCount = reader.getBorrowRecords().size();
        int currentlyBorrowed = reader.getBorrowedBooks().size();

        if (currentlyBorrowed > 5) {
            reader.setRating(UserRating.DISLOYAL); // Holding too many books out at once
        } else if (historicalCount > 5 && currentlyBorrowed <= 2) {
            reader.setRating(UserRating.LOYAL);
        } else {
            reader.setRating(UserRating.REGULAR);
        }
    }
}