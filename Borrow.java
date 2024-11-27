import java.util.HashMap;
import java.util.Map;

class Borrow {
    private static Map<String, Borrower> borrowers = new HashMap<>(); // Borrower records
    private static Map<String, String> borrowedMaterials = new HashMap<>(); // Material ID -> Borrower ID

    public static void borrowMaterial(String borrowerId) {
        // Check if the borrower is registered
        if (!borrowers.containsKey(borrowerId)) {
            System.out.println("Borrower is not registered. Please register first.");
            return;
        }

        Borrower borrower = borrowers.get(borrowerId);

        // Check if borrower has strikes
        if (borrower.getStrikes() >= 3) {
            System.out.println("Borrower is restricted from borrowing materials due to 3 strikes.");
            return;
        }

        // Check if borrower already has a borrowed material
        if (borrowedMaterials.containsValue(borrowerId)) {
            System.out.println("Borrower already has a borrowed material. Return it first to borrow again.");
            return;
        }

        System.out.print("Enter Material ID to borrow: ");
        String materialId = AssetManagement.scanner.nextLine();

        Material materialToBorrow = null;
        for (Material m : AssetManagement.materials) {
            if (m.getId().equals(materialId)) {
                materialToBorrow = m;
                break;
            }
        }

        if (materialToBorrow == null) {
            System.out.println("Material not found.");
            return;
        }

        // Check if the material has available copies
        if (materialToBorrow.getCopies() <= 0) {
            System.out.println("No available copies for this material.");
            return;
        }

        // Process borrowing
        materialToBorrow.setCopies(materialToBorrow.getCopies() - 1);
        borrowedMaterials.put(materialId, borrowerId);
        System.out.println("Material borrowed successfully.");

        // Assign due date based on material type
        String dueDate = calculateDueDate(materialToBorrow);
        System.out.println("Due Date: " + dueDate);
    }

    public static void returnMaterial(String materialId) {
        if (!borrowedMaterials.containsKey(materialId)) {
            System.out.println("Material is not currently borrowed.");
            return;
        }

        String borrowerId = borrowedMaterials.get(materialId);
        Borrower borrower = borrowers.get(borrowerId);

        // Remove the borrowed material record and update material copies
        borrowedMaterials.remove(materialId);
        for (Material m : AssetManagement.materials) {
            if (m.getId().equals(materialId)) {
                m.setCopies(m.getCopies() + 1);
                break;
            }
        }

        System.out.println("Material returned successfully.");

        // Optionally handle overdue logic here (not implemented due to lack of dates in this example)
    }

    public static void addBorrower(String id, String name) {
        if (borrowers.containsKey(id)) {
            System.out.println("Borrower is already registered.");
            return;
        }

        borrowers.put(id, new Borrower(id, name));
        System.out.println("Borrower registered successfully.");
    }

    private static String calculateDueDate(Material material) {
        int days;
        if (material instanceof Book) {
            days = 7;
        } else if (material instanceof Journal) {
            days = 3;
        } else if (material instanceof Magazine) {
            days = 0; // Same day
        } else if (material instanceof ThesisBook) {
            days = 2;
        } else {
            days = 0; // Default case
        }
        return (days == 0) ? "Today" : "In " + days + " days";
    }
}

class Borrower {
    private String id;
    private String name;
    private int strikes;

    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
        this.strikes = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrikes() {
        return strikes;
    }

    public void addStrike() {
        strikes++;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Strikes: " + strikes;
    }
}





// import java.util.HashMap;
// import java.util.Scanner;

// public class Borrow {
// 	private static HashMap<String, BorrowedItem> borrowedMaterials = new HashMap<>();
// 	private static Scanner scanner = new Scanner(System.in);

// 	public static void borrowMats(String borrowerId2, String materialId2) {
// 		System.out.print("Enter Borrower ID: ");
// 		String borrowerId = scanner.nextLine();

// 		Borrower borrower = findBorrowerById(borrowerId);
// 		if (borrower == null) {
// 			System.out.println("Borrower not registered.");
// 			return;
// 		}

// 		if (borrowedMaterials.containsKey(borrowerId)) {
// 			System.out.println("You already have a borrowed material. Please return it first.");
// 			return;
// 		}

// 		if (getBorrowerStrikes(borrowerId) >= 3) {
// 			System.out.println("You cannot borrow materials. You have 3 strikes on your record.");
// 			return;
// 		}

// 		System.out.print("Enter Material ID: ");
// 		String materialId = scanner.nextLine();

// 		Material material = findMaterialById(materialId);
// 		if (material == null) {
// 			System.out.println("Material not found.");
// 			return;
// 		}

// 		System.out.print("Enter Material Type (Book, Journal, Magazine, Thesis Book): ");
// 		String materialType = scanner.nextLine().toLowerCase();

// 		int borrowDays = getBorrowDays(materialType);
// 		if (borrowDays == 0) {
// 			System.out.println("Invalid material type.");
// 			return;
// 		}

// 		borrowedMaterials.put(borrowerId, new BorrowedItem(material, materialType, borrowDays));
// 		System.out.println("Material borrowed successfully. Please return it within " + borrowDays + " day(s).");
// 	}

// 	private static Borrower findBorrowerById(String borrowerId) {
// 		// Search for borrower in BorrowerManagement
// 		for (Borrower borrower : BorrowerManagement.borrower) {
// 			if (borrower.getId().equals(borrowerId)) {
// 				return borrower;
// 			}
// 		}
// 		return null;
// 	}

// 	private static Material findMaterialById(String materialId) {
// 		for (Material material : AssetManagement.materials) {
// 			if (material.getId().equals(materialId)) {
// 				return material;
// 			}
// 		}
// 		return null;
// 	}

// 	private static int getBorrowDays(String materialType) {
// 		switch (materialType) {
// 		case "book":
// 			return 7;
// 		case "journal":
// 			return 3;
// 		case "magazine":
// 			return 1;
// 		case "thesis book":
// 			return 2;
// 		default:
// 			return 0;
// 		}
// 	}

// 	private static int getBorrowerStrikes(String borrowerId) {
// 		// Placeholder: Implement actual strike checking logic from Borrower records
// 		return 0;
// 	}
// }

// class BorrowedItem {
// 	private Material material;
// 	private String type;
// 	private int daysAllowed;

// 	public BorrowedItem(Material material, String type, int daysAllowed) {
// 		this.material = material;
// 		this.type = type;
// 		this.daysAllowed = daysAllowed;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Material: " + material + ", Type: " + type + ", Days Allowed: " + daysAllowed;
// 	}
// }
