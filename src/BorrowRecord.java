public class BorrowRecord {
    private String bookId;
    private String memberId;
    private String borrowDate;
    private String returnDate;

    public BorrowRecord(String bookId, String memberId, String borrowDate, String returnDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setReturnDate(String date) {
        returnDate = date;
    }

    public boolean isActive() {
        return returnDate.isEmpty();
    }

    public String toCsv() {
        return bookId + "," + memberId + "," + borrowDate + "," + returnDate;
    }

    public static BorrowRecord fromCsv(String line) {
        String[] parts = line.split(",", -1);
        return new BorrowRecord(parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return "Book: " + bookId + " | Member: " + memberId + " | Borrowed: " + borrowDate + " | " + (isActive() ? "Still borrowed " : "Returned: " + returnDate);
    }
}
