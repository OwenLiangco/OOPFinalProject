public class Borrower {
    private String borrowerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String birthday;
    private String contactNumber;
    private String email;
    private String address;
    private int violationCount = 0;

    public Borrower(String borrowerId, String firstName, String middleName, String lastName, String gender, String birthday, String contactNumber, String email, String address) {
        this.borrowerId = borrowerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getFirstName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    public void setFirstName(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFirstName'");
    }

    public void setLastName(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLastName'");
    }

    public String getLastName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }

    // Getters and Setters for other fields
}

