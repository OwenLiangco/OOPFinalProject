import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nLibrary System Menu");
            System.out.println("1. Borrowers Management");
            System.out.println("2. Asset Management");
            System.out.println("3. Borrow");
            System.out.println("4. Return Book");
            System.out.println("5. Borrower History");
            System.out.println("6. Book History");
            System.out.println("7. Exit");

            try {
                System.out.print("Enter an option: ");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        library.manageBorrowers(scanner);
                        break;
                    case 2:
                        library.manageAssets(scanner);
                        break;
                    case 3:
                        library.borrowMaterial(scanner);
                        break;
                    case 4:
                        library.returnMaterial(scanner);
                        break;
                    case 5:
                        library.showBorrowerHistory(scanner);
                        break;
                    case 6:
                        library.showBookHistory(scanner);
                        break;
                    case 7:
                        System.out.println("Thank you for using the Library System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (option != 7);
        
        scanner.close();
    }
}
