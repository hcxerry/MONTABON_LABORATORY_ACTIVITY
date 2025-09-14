import java.util.Scanner;

public class LibraryManagementSystem {
    private static final int MAX_BOOKS = 5;
    private static String[] bookTitles = new String[MAX_BOOKS];
    private static String[] bookStatus = new String[MAX_BOOKS];
    private static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    updateBookStatus(scanner);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting program... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Library Book Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Status");
        System.out.println("3. Show All Books");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
    }

    public static void addBook(Scanner scanner) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Book limit reached! Cannot add more books.");
            return;
        }
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        bookTitles[bookCount] = title;
        bookStatus[bookCount] = "Available";
        bookCount++;
        System.out.println("Book added successfully!");
    }

    public static void updateBookStatus(Scanner scanner) {
        if (bookCount == 0) {
            System.out.println("No books available to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to update: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();

        if (bookNumber < 1 || bookNumber > bookCount) {
            System.out.println("Invalid book number!");
            return;
        }

        int index = bookNumber - 1;
        if (bookStatus[index].equals("Available")) {
            bookStatus[index] = "Borrowed";
        } else {
            bookStatus[index] = "Available";
        }
        System.out.println("Book status updated successfully!");
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books registered.");
            return;
        }
        System.out.println("\n===== List of Books =====");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + bookTitles[i] + " - " + bookStatus[i]);
        }
    }

    public static void generateReport() {
        int availableCount = 0;
        int borrowedCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (bookStatus[i].equals("Available")) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\n===== Book Report =====");
        System.out.println("Total books: " + bookCount);
        System.out.println("Available books: " + availableCount);
        System.out.println("Borrowed books: " + borrowedCount);
    }
}

// MONTABON CHERRY R. 
// BSCS 2-D 
// AI USED: ChatGPT-5 
// CONVERSION LINK WITH ChatGPT-5: https://chatgpt.com/share/68c62779-ae8c-8005-b65a-3383db8ac68a





