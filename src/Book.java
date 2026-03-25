public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book (String id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toCsv() {
        return id + "," + title + "," + author + "," + isAvailable;
    }

    public static Book fromCsv(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]));
    }

    @Override
    public String toString() {
        return "[" + id + "]" + title + " by " + author + " | " + (isAvailable ? "Available" : "Borrowed");
    }
}
