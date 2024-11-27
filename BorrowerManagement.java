import java.util.ArrayList;
import java.util.Scanner;

public class BorrowerManagement {
    private static ArrayList<Borrower> borrowers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static Borrower[] borrower;

    public static void manageBorrowers() {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n----- Borrower Management -----");
            System.out.println("1. Add Borrower");
            System.out.println("2. Edit Borrower");
            System.out.println("3. Delete Borrower");
            System.out.println("4. View Borrowers");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1: addBorrower(); break;
                case 2: editBorrower(); break;
                case 3: deleteBorrower(); break;
                case 4: viewBorrowers(); break;
                case 5: backToMain = true; break;
                default: System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addBorrower() {
        System.out.print("Enter Borrower ID: ");
        String id = scanner.nextLine();
        
        for (Borrower b : borrowers) {
            if (b.getId().equals(id)) {
                System.out.println("Borrower already exists.");
                return;
            }
        }

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        borrowers.add(new Borrower(id, firstName, lastName));
        System.out.println("Borrower added successfully.");
    }

    private static void editBorrower() {
        System.out.print("Enter Borrower ID to edit: ");
        String id = scanner.nextLine();
        
        for (Borrower b : borrowers) {
            if (b.getId().equals(id)) {
                System.out.print("Enter New First Name: ");
                b.setFirstName(scanner.nextLine());
                System.out.print("Enter New Last Name: ");
                b.setLastName(scanner.nextLine());
                System.out.println("Borrower updated successfully.");
                return;
            }
        }
        System.out.println("Borrower not found.");
    }

    private static void deleteBorrower() {
        System.out.print("Enter Borrower ID to delete: ");
        String id = scanner.nextLine();
        
        for (Borrower b : borrowers) {
            if (b.getId().equals(id)) {
                borrowers.remove(b);
                System.out.println("Borrower deleted successfully.");
                return;
            }
        }
        System.out.println("Borrower not found.");
    }

    private static void viewBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers found.");
            return;
        }
        for (Borrower b : borrowers) {
            System.out.println(b);
        }
    }
}


class Borrower {
    private String id;
    private String firstName;
    private String lastName;

    public Borrower(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() { return id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName;
    }
}
