import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AssetManagement {
    static ArrayList<Material> materials = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        manageAssets();
    }

    public static Scanner getScanner() {
        return scanner;
        
    }

    public static void setScanner(Scanner scanner) {
        AssetManagement.scanner = scanner;
        
    }

    public static void manageAssets() {
        boolean backToMain = false;
        while (!backToMain) {
            System.out.println("\n----- Asset Management -----");
            System.out.println("1. Add Material");
            System.out.println("2. Edit Material");
            System.out.println("3. Delete Material");
            System.out.println("4. View Materials");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = getScanner().nextInt();
            getScanner().nextLine();

            switch (choice) {
                case 1 -> addMaterial();
                case 2 -> editMaterial();
                case 3 -> deleteMaterial();
                case 4 -> viewMaterials();
                case 5 -> backToMain = true;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addMaterial() {
        System.out.println("\nSelect Material Type:");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Magazine");
        System.out.println("4. Thesis Book");
        System.out.print("Choose an option: ");
        int typeChoice = getScanner().nextInt();
        getScanner().nextLine(); // Consume newline

        System.out.print("Enter Material ID: ");
        String id = getScanner().nextLine();

        for (Material m : materials) {
            if (m.getId().equals(id)) {
                System.out.println("Material already exists.");
                return;
            }
        }

        System.out.print("Enter Title/Name: ");
        String title = getScanner().nextLine();
        System.out.print("Enter Author (if applicable): ");
        String author = getScanner().nextLine();
        System.out.print("Enter Year Published: ");
        int year = getScanner().nextInt();
        getScanner().nextLine(); // Consume newline
        System.out.print("Enter Publisher: ");
        String publisher = getScanner().nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = getScanner().nextInt();
        getScanner().nextLine(); // Consume newline

        Material material;
        switch (typeChoice) {
            case 1 -> material = new Book(id, title, author, year, publisher, copies);
            case 2 -> material = new Journal(id, title, year, publisher, copies);
            case 3 -> material = new Magazine(id, title, year, publisher, copies);
            case 4 -> material = new ThesisBook(id, title, author, year, publisher, copies);
            default -> {
                System.out.println("Invalid material type.");
                return;
            }
        }

        materials.add(material);
        System.out.println("Material added successfully.");
    }

    private static void editMaterial() {
        System.out.print("Enter Material ID to edit: ");
        String id = getScanner().nextLine();

        for (Material m : materials) {
            if (m.getId().equals(id)) {
                System.out.print("Enter New Title/Name: ");
                m.setTitle(getScanner().nextLine());
                if (m instanceof Book || m instanceof ThesisBook) {
                    System.out.print("Enter New Author: ");
                    ((Book) m).setAuthor(getScanner().nextLine());
                }
                System.out.print("Enter New Year Published: ");
                m.setYearPublished(getScanner().nextInt());
                getScanner().nextLine(); 
                System.out.print("Enter New Publisher: ");
                m.setPublisher(getScanner().nextLine());
                System.out.print("Enter New Number of Copies: ");
                m.setCopies(getScanner().nextInt());
                getScanner().nextLine(); 
                System.out.println("Material updated successfully.");
                return;
            }
        }
        System.out.println("Material not found.");
    }

    private static void deleteMaterial() {
        System.out.print("Enter Material ID to delete: ");
        String id = getScanner().nextLine();

        for (Material m : materials) {
            if (m.getId().equals(id)) {
                materials.remove(m);
                System.out.println("Material deleted successfully.");
                return;
            }
        }
        System.out.println("Material not found.");
    }

    private static void viewMaterials() {
        if (materials.isEmpty()) {
            System.out.println("No materials found.");
            return;
        }
        for (Material m : materials) {
            System.out.println(m);
        }
    }

// 	public static Map<String, Material> getMaterialMap() {
// 		// TODO Auto-generated method stub
// 		throw new UnsupportedOperationException("Unimplemented method 'getMaterialMap'");
// 	}
// }

abstract class Material {
    private String id;
    private String title;
    private int yearPublished;
    private String publisher;
    private int copies;

    public Material(String id, String title, int yearPublished, String publisher, int copies) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.copies = copies;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title/Name: " + title + ", Year: " + yearPublished +
               ", Publisher: " + publisher + ", Copies: " + copies;
    }

    protected abstract int getCopies();
}

class Book extends Material {
    private String author;

    public Book(String id, String title, String author, int yearPublished, String publisher, int copies) {
        super(id, title, yearPublished, publisher, copies);
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }

    @Override
    protected int getCopies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCopies'");
    }
}

class Journal extends Material {
    public Journal(String id, String name, int yearPublished, String publisher, int copies) {
        super(id, name, yearPublished, publisher, copies);
    }

    @Override
    protected int getCopies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCopies'");
    }
}

class Magazine extends Material {
    public Magazine(String id, String name, int yearPublished, String publisher, int copies) {
        super(id, name, yearPublished, publisher, copies);
    }

    @Override
    protected int getCopies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCopies'");
    }
}

class ThesisBook extends Book {
    public ThesisBook(String id, String title, String author, int yearPublished, String publisher, int copies) {
        super(id, title, author, yearPublished, publisher, copies);
    }
}

// import java.util.ArrayList;
// import java.util.Scanner;

// public class AssetManagement {
//     static ArrayList<Material> materials = new ArrayList<>();
//     private static Scanner scanner = new Scanner(System.in);

//     public static void manageAssets() {
//         boolean backToMain = false;
//         while (!backToMain) {
//             System.out.println("\n----- Asset Management -----");
//             System.out.println("1. Add Material");
//             System.out.println("2. Edit Material");
//             System.out.println("3. Delete Material");
//             System.out.println("4. View Materials");
//             System.out.println("5. Back to Main Menu");
//             System.out.print("Choose an option: ");
            
//             int choice = scanner.nextInt();
//             scanner.nextLine();

//             switch (choice) {
//                 case 1: addMaterial(); break;
//                 case 2: editMaterial(); break;  
//                 case 3: deleteMaterial(); break;  
//                 case 4: viewMaterials(); break;
//                 case 5: backToMain = true; break;
//                 default: System.out.println("Invalid option, please try again.");
//             }
//         }
//     }

//     private static void addMaterial() {
//         System.out.print("Enter Material ID: ");
//         String id = scanner.nextLine();
        
//         for (Material m : materials) {
//             if (m.getId().equals(id)) {
//                 System.out.println("Material already exists.");
//                 return;
//             }
//         }

//         System.out.print("Enter Title: ");
//         String title = scanner.nextLine();
//         System.out.print("Enter Author: ");
//         String author = scanner.nextLine();

//         materials.add(new Material(id, title, author));
//         System.out.println("Material added successfully.");
//     }

//     private static void editMaterial() {
//         System.out.print("Enter Material ID to edit: ");
//         String id = scanner.nextLine();
        
//         for (Material m : materials) {
//             if (m.getId().equals(id)) {
//                 System.out.print("Enter New Title: ");
//                 m.setTitle(scanner.nextLine());
//                 System.out.print("Enter New Author: ");
//                 m.setAuthor(scanner.nextLine());
//                 System.out.println("Material updated successfully.");
//                 return;
//             }
//         }
//         System.out.println("Material not found.");
//     }

//     private static void deleteMaterial() {
//         System.out.print("Enter Material ID to delete: ");
//         String id = scanner.nextLine();
        
//         for (Material m : materials) {
//             if (m.getId().equals(id)) {
//                 materials.remove(m);
//                 System.out.println("Material deleted successfully.");
//                 return;
//             }
//         }
//         System.out.println("Material not found.");
//     }

//     private static void viewMaterials() {
//         if (materials.isEmpty()) {
//             System.out.println("No materials found.");
//             return;
//         }
//         for (Material m : materials) {
//             System.out.println(m);
//         }
//     }
// }


// class Material {
//     private String id;
//     private String title;
//     private String author;

//     public Material(String id, String title, String author) {
//         this.id = id;
//         this.title = title;
//         this.author = author;
//     }

//     public String getId() { return id; }
//     public void setTitle(String title) { this.title = title; }
//     public void setAuthor(String author) { this.author = author; }

//     @Override
//     public String toString() {
//         return "ID: " + id + ", Title: " + title + ", Author: " + author;
//     }
// }
