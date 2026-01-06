public class RatingService {

    public void updateRating(Reader reader) {

        int borrowedCount = reader.getBorrowedBooks().size();

        if (borrowedCount == 0) {
            reader.setRating(UserRating.DISLOYAL);
        } else if (borrowedCount <= 3) {
            reader.setRating(UserRating.REGULAR);
        } else {
            reader.setRating(UserRating.LOYAL);
        }
    }
}
