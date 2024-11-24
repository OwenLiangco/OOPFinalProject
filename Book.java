public class Book extends Material {
    private String author;
    private int yearPublished;

    public Book(String materialId, String title, String publisher, int availableCopies, String author, int yearPublished) {
        super(materialId, title, publisher, availableCopies);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public void borrowMaterial() {
        // Borrowing logic specific to books
    }

    @Override
    public void returnMaterial() {
        // Return logic specific to books
    }
}
