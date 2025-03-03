public class EntryNode {
    private int index;
    private EntryNode nextEntry;
    private String fName;
    private String lName;
    private String address;
    private String phoneNumber;
    private int zipCode;
    private String email;

    public EntryNode(int index, String fName, String lName, String address, String phoneNumber, int zipCode,
            String email) {
        this.nextEntry = null;
        this.index = index;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.email = email;
    }

    public EntryNode(int index, EntryNode nextEntry, String fName, String lName, String address, String phoneNumber,
            int zipCode, String email) {
        this.index = index;
        this.nextEntry = nextEntry;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.email = email;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public EntryNode getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(EntryNode nextEntry) {
        this.nextEntry = nextEntry;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
