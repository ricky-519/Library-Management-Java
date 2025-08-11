package Assignment1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get Member details
        System.out.print("Enter member name: ");
        String memberName = sc.nextLine();

        System.out.print("Enter member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Get Book details
        System.out.print("Enter book title: ");
        String bookTitle = sc.nextLine();

        System.out.print("Enter book author: ");
        String bookAuthor = sc.nextLine();

        // Create objects using constructor
        Book book1 = new Book(bookTitle, bookAuthor);
        Member member1 = new Member(memberName, memberId);

        // Display details
        System.out.println("\nMember: " + member1.getName() + " (ID: " + member1.getMemberId() + ")");
        System.out.println("Book: " + book1.getTitle() + " by " + book1.getAuthor());

        // Borrow and return operations
        book1.borrowBook();
        book1.borrowBook(); // Trying again when unavailable
        book1.returnBook();

        sc.close();
    }
}

// Book class
class Book {
    private String title;
    private String author;
    private boolean available = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Methods
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("'" + title + "' borrowed successfully.");
        } else {
            System.out.println("'" + title + "' is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("'" + title + "' returned successfully.");
    }
}

// Member class
class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getMemberId() {
        return memberId;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
