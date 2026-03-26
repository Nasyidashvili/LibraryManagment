import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.util.ArrayList;
import java.time.LocalDate;

public class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();

    public LibraryManager() {
        loadAll();
    }

    public void loadAll() {
        for (String book : FileHandler.readLines("data/books.csv")) {
            books.add(Book.fromCsv(book));
        }
        for (String member : FileHandler.readLines("data/members.csv")) {
            members.add(Member.fromCsv(member));
        }
        for (String borrowRecord : FileHandler.readLines("data/borrowRecords.csv")) {
            borrowRecords.add(BorrowRecord.fromCsv(borrowRecord));
        }
    }

    public void saveBooks() {
        ArrayList<String> lines = new ArrayList<>();
        for (Book book : books) {
            lines.add(book.toCsv());
        }
        FileHandler.writeLines("data/books.csv", lines);
    }

    public void saveRecords() {
        ArrayList<String> lines = new ArrayList<>();
        for (BorrowRecord record : borrowRecords) {
            lines.add(record.toCsv());
        }
        FileHandler.writeLines("data/borrowRecords.csv", lines);
    }

    public void saveMembers() {
        ArrayList<String> lines = new ArrayList<>();
        for (Member member : members) {
            lines.add(member.toCsv());
        }
        FileHandler.writeLines("data/members.csv", lines);
    }


    public void addBook(String title, String author) {
        String id = "B" + (books.size() + 1);
        books.add(new Book(id, title, author, true));

        ArrayList<String> lines = new ArrayList<>();
        for (Book book : books) {
            lines.add(book.toCsv());
        }
        FileHandler.writeLines("data/books.csv", lines);
    }

    public void addMember(String name, String email) {
        String id = "M" + (members.size() + 1);
        members.add(new Member(id, name, email));

        ArrayList<String> lines = new ArrayList<>();
        for (Member member : members) {
            lines.add(member.toCsv());
        }
        FileHandler.writeLines("data/members.csv", lines);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void borrowBook(String bookId, String memberId) {
        for(Book book : books) {
            if(book.getId().equals(bookId)) {
                if(!book.getIsAvailable()) {
                    System.out.println("Book is not available");
                    return;
                }
                book.setAvailable(false);
                borrowRecords.add(new BorrowRecord(bookId, memberId, LocalDate.now().toString(), ""));
                saveBooks();
                saveRecords();
            }
        }
    }

    public void returnBook(String bookId) {
        for (BorrowRecord record : borrowRecords) {
            if(record.getBookId().equals(bookId) && record.isActive()) {
                record.setReturnDate(LocalDate.now().toString());
                for (Book book : books) {
                    if(book.getId().equals(bookId)) {
                        book.setAvailable(true);
                    }
                }
                saveBooks();
                saveRecords();
                return;
            }
        }
        System.out.println("No active borrowing found for this book");
    }
}
