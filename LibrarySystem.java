import java.util.Scanner;

public class LibrarySystem {
	private static String borrowerId;
		private static String materialId;
		
		
			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				boolean exit = false;
		
				while (!exit) {
					System.out.println("========== Library System ==========");
					System.out.println("1. Borrowers Management");
					System.out.println("2. Asset Management");
					System.out.println("3. Borrow");
					System.out.println("4. Return Book");
					System.out.println("5. Borrower History");
					System.out.println("6. Book History");
					System.out.println("7. Exit");
					System.out.print("Choose an option (1-7): ");
		
					int choice = -1;
					try {
						choice = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a number between 1 and 7.");
						continue;
					}
		
					switch (choice) {
					case 1:
						manageBorrowers();
						break;
					case 2:
						manageAssets();
						break;
					case 3:
						Borrow();
						break;
					case 4:
						ReturnB();
						break;
					case 5:
						viewBorrowerHistory();
						break;
					case 6:
						viewBookHistory();
						break;
					case 7:
						exit = true;
						System.out.println("Thank you for using the Library System!");
						System.out.println("Developed by: We deserve arrays!");
						break;
					default:
						System.out.println("Invalid choice. Please select a valid option.");
					}
				}
		
				scanner.close();
			}
		
			private static void manageBorrowers() {
				BorrowerManagement.manageBorrowers();
			}
		
			private static void manageAssets() {
				AssetManagement.manageAssets();
			}
		
			private static void Borrow() {
				// System.out.print("Enter Borrower ID: ");
				// String borrowerId = AssetManagement.getScanner().nextLine();
				Borrow.borrowMaterial(borrowerId);
		}
		
		@SuppressWarnings("unused")
		private static void ReturnB() {
		ReturnM.returnMaterial(borrowerId, materialId, 
	Borrow.getBorrowedMaterials(), 
	Borrow.getBorrowers(), 
	AssetManagement.getMaterialMap());
	}

	private static void viewBorrowerHistory() {
		System.out.println("Borrower History - Placeholder");
		// Placeholder for Borrower History functionality
	}


	private static void viewBookHistory() {
		System.out.println("Book History - Placeholder");
		// Placeholder for Book History functionality
	}
}