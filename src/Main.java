import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Add Member");
            System.out.println("3. List Books");
            System.out.println("4. List Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Choose number: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1 -> {
                    System.out.print("Which book would you like to add: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("What is author of book: ");
                    String author = scanner.nextLine().trim();
                    manager.addBook(title, author);
                }
                case 2 -> {
                    System.out.print("What is your name: ");
                    String name = scanner.nextLine().trim().toLowerCase();
                    System.out.print("What is your email: ");
                    String email = scanner.nextLine().trim().toLowerCase();
                    manager.addMember(name, email);
                }
                case 3 -> {
                    System.out.print("All books that are available: \n");
                    manager.listBooks();
                }
                case 4 -> {
                    System.out.print("All members that are available: \n");
                    manager.listMembers();
                }
                case 5 -> {
                    System.out.print("What is Book ID: ");
                    String bookId = scanner.nextLine().trim();
                    System.out.print("What is you ID: ");
                    String memberId = scanner.nextLine().trim();
                    manager.borrowBook(bookId, memberId);
                }
                case 6 -> {
                    System.out.print("What is Book ID: ");
                    String bookId = scanner.nextLine().trim();
                    manager.returnBook(bookId);
                }
                case 0 -> {
                    System.out.print("Would you like to exit (Y/N): ");
                    String exit = scanner.nextLine().trim().toLowerCase();
                    if(exit.equals("y")) {
                        return;
                    }
                }
            }
        }
    }
}
