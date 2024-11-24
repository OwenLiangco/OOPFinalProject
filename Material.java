public abstract class Material {
    private String materialId;
    private String title;
    private String publisher;
    private int availableCopies;

    public Material(String materialId, String title, String publisher, int availableCopies) {
        this.materialId = materialId;
        this.title = title;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
    }

    public String getMaterialId() {
        return materialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getPublisher() {
        return publisher;
    }

    // Abstract method to handle different material behaviors (borrow, return, etc.)
    public abstract void borrowMaterial();
    public abstract void returnMaterial();
}
