
import java.util.*;

public class Library {
    private ArrayList<Borrower> borrowers = new ArrayList<>();
    private ArrayList<Material> materials = new ArrayList<>();

    // Method for managing Borrowers
    public void manageBorrowers(Scanner scanner) {
        System.out.println("\nBorrowers Management Menu");
        System.out.println("1. Add Borrower");
        System.out.println("2. Edit Borrower");
        System.out.println("3. Delete Borrower");
        System.out.println("4. View Borrower");
        System.out.println("5. Return to Main Menu");

        try {
            System.out.print("Enter an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addBorrower(scanner);
                    break;
                case 2:
                    editBorrower(scanner);
                    break;
                case 3:
                    deleteBorrower(scanner);
                    break;
                case 4:
                    viewBorrowers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // Method to add a new borrower
    public void addBorrower(Scanner scanner) {
        System.out.print("Enter Borrower ID: ");
        String borrowerId = scanner.nextLine();
        if (findBorrower(borrowerId) != null) {
            System.out.println("Borrower ID already exists.");
            return;
        }
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthday (MM/DD/YYYY): ");
        String birthday = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Borrower borrower = new Borrower(borrowerId, firstName, middleName, lastName, gender, birthday, contactNumber, email, address);
        borrowers.add(borrower);
        System.out.println("Borrower added successfully!");
    }

    // Method to edit borrower details
    public void editBorrower(Scanner scanner) {
        System.out.print("Enter Borrower ID to edit: ");
        String borrowerId = scanner.nextLine();
        Borrower borrower = findBorrower(borrowerId);

        if (borrower != null) {
            System.out.print("Enter new First Name (current: " + borrower.getFirstName() + "): ");
            borrower.setFirstName(scanner.nextLine());
            System.out.print("Enter new Last Name (current: " + borrower.getLastName() + "): ");
            borrower.setLastName(scanner.nextLine());
            // Repeat for other fields as necessary
            System.out.println("Borrower details updated.");
        } else {
            System.out.println("Borrower not found.");
        }
    }

    // Method to delete a borrower
    public void deleteBorrower(Scanner scanner) {
        System.out.print("Enter Borrower ID to delete: ");
        String borrowerId = scanner.nextLine();
        Borrower borrower = findBorrower(borrowerId);

        if (borrower != null) {
            borrowers.remove(borrower);
            System.out.println("Borrower deleted successfully.");
        } else {
            System.out.println("Borrower not found.");
        }
    }

    // View all borrowers
    public void viewBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers registered.");
            return;
        }

        for (Borrower borrower : borrowers) {
            System.out.println("ID: " + borrower.getBorrowerId() + ", Name: " + borrower.getFullName());
        }
    }

    // Helper methods for managing materials
    public void manageAssets(Scanner scanner) {
        System.out.println("\nAsset Management Menu");
        System.out.println("1. Add Material");
        System.out.println("2. Edit Material");
        System.out.println("3. Delete Material");
        System.out.println("4. View Materials");
        System.out.println("5. Return to Main Menu");

        try {
            System.out.print("Enter an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addMaterial(scanner);
                    break;
                case 2:
                    editMaterial(scanner);
                    break;
                case 3:
                    deleteMaterial(scanner);
                    break;
                case 4:
                    viewMaterials();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // Add a material
    public void addMaterial(Scanner scanner) {
        // Sample addition of book
        System.out.print("Enter Material ID: ");
        String materialId = scanner.nextLine();
        System.out.print("Enter Material Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Material Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter Available Copies: ");
        int availableCopies = Integer.parseInt(scanner.nextLine());

        Material material = new Book(materialId, title, publisher, availableCopies, "Author Name", 2020);  // Example for a book
        materials.add(material);
        System.out.println("Material added successfully.");
    }

    // Edit material
    public void editMaterial(Scanner scanner) {
        System.out.print("Enter Material ID to edit: ");
        String materialId = scanner.nextLine();
        Material material = findMaterial(materialId);

        if (material != null) {
            System.out.print("Enter new title (current: " + material.getTitle() + "): ");
            material.setTitle(scanner.nextLine());
            System.out.println("Material updated.");
        } else {
            System.out.println("Material not found.");
        }
    }

    // Delete material
    public void deleteMaterial(Scanner scanner) {
        System.out.print("Enter Material ID to delete: ");
        String materialId = scanner.nextLine();
        Material material = findMaterial(materialId);

        if (material != null) {
            materials.remove(material);
            System.out.println("Material deleted.");
        } else {
            System.out.println("Material not found.");
        }
    }

    // View all materials
    public void viewMaterials() {
        if (materials.isEmpty()) {
            System.out.println("No materials available.");
            return;
        }

        for (Material material : materials) {
            System.out.println("ID: " + material.getMaterialId() + ", Title: " + material.getTitle());
        }
    }

    // Helper methods for finding Borrowers and Materials by ID
    private Borrower findBorrower(String borrowerId) {
        for (Borrower borrower : borrowers) {
            if (borrower.getBorrowerId().equals(borrowerId)) {
                return borrower;
            }
        }
        return null;
    }

    private Material findMaterial(String materialId) {
        for (Material material : materials) {
            if (material.getMaterialId().equals(materialId)) {
                return material;
            }
        }
        return null;
    }

    public void borrowMaterial(Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrowMaterial'");
    }

    public void showBorrowerHistory(Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showBorrowerHistory'");
    }

    public void returnMaterial(Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnMaterial'");
    }

    public void showBookHistory(Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showBookHistory'");
    }
}

