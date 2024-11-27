import java.time.LocalDate;
import java.util.Map;

import AssetManagement.Material;

public class ReturnM {
    public static void returnMaterial(String borrowerId, String materialId, 
                                      Map<String, BorrowedMaterial> borrowedMaterials, 
                                      Map<String, Borrower> borrowers, 
                                      Map<String, Material> materials) {
        // Check if the material is currently borrowed
        if (!borrowedMaterials.containsKey(materialId)) {
            System.out.println("Material is not currently borrowed.");
            return;
        }

        BorrowedMaterial borrowedMaterial = borrowedMaterials.get(materialId);

        // Check if the borrower matches
        if (!borrowedMaterial.getBorrowerId().equals(borrowerId)) {
            System.out.println("This material is not borrowed by the given borrower.");
            return;
        }

        Borrower borrower = borrowers.get(borrowerId);

        // Check if returned late
        if (LocalDate.now().isAfter(borrowedMaterial.getDueDate())) {
            System.out.println("Material returned late. Borrower receives a strike.");
            borrower.addStrike();
        } else {
            System.out.println("Material returned on time.");
        }

        // Remove the borrowed material record
        borrowedMaterials.remove(materialId);
        

        // Update material copies
        Material material = materials.get(materialId);
        if (material != null) {
            material.setCopies(material.getCopies() + 1);
        }

        System.out.println("Material returned successfully.");
    }
}
