import java.util.Scanner;

public class uas14 {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (menu != 4);
    }

    static String[][] books = {
        {"Index", "Title", "ISBN", "Availability"},
        {"1", "Harry Potter", "978-3-16-148410-0", "Available"},
        {"2", "Lord of The Ring", "978-1-843-56710-2", "Available"},
        {"3", "The Alchemist", "978-0-06-231500-7", "Borrowed"},
        {"4", "Sherlock Holmes", "978-1-566-19310-3", "Available"},
    };


    public static void displayBooks() {
        for (int i = 0; i < books[0].length; i++) {
            System.out.printf("%-20s", books[0][i]);
        }
        System.out.println();

        for (int i = 1; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                System.out.printf("%-20s", books[i][j]);
            }
            System.out.println();
        }
    }

    public static void borrowBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the index of the book you want to borrow (1 to 4): ");
        int bookIndex = sc.nextInt();

        if (bookIndex < 1 || bookIndex >= books.length) {
            System.out.println("Invalid book index! Please select a valid book index.");
            return;
        }

        if (books[bookIndex][3].equals("Available")) {
            books[bookIndex][3] = "Borrowed";
            System.out.println("You have successfully borrowed " + books[bookIndex][1]);
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    public static void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the index of the book you want to return (1 to 4): ");
        int bookIndex = sc.nextInt();

        if (bookIndex < 1 || bookIndex >= books.length) {
            System.out.println("Invalid book index! Please select a valid book index.");
            return;
        }

        if (books[bookIndex][3].equals("Borrowed")) {
            books[bookIndex][3] = "Available";
            System.out.println("You have successfully returned " + books[bookIndex][1]);
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Library!!!");
        showMenu();
    }
}
