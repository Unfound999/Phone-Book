public class PhoneBookManager {

    private EntryNode firstNode;
    private int length;

    public void addEntry(String fNAme, String lName, String address, String phNum, int zip, String email) {

        EntryNode currNode = firstNode;
        while(currNode.getNextEntry() !=  null) {

            currNode = currNode.getNextEntry();
        }

        EntryNode newEntryNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
        currNode.setNextEntry(newEntryNode);

    }

    public void addEntry(String fNAme, String lName, String address, String phNum, int zip, String email, int index) {

        EntryNode currNode = firstNode;
        while(currNode.getNextEntry() !=  null) {

            currNode = currNode.getNextEntry();
        }

        EntryNode newEntryNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
        currNode.setNextEntry(newEntryNode);

        //remove code

    }

    public void remove(String fName, String lName, String pNumber) {

        EntryNode currNode = firstNode;

        String currFName = currNode.getfName();
        String currLName = currNode.getlName();
        String currPNumber = currNode.getPhoneNumber();

        if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
            firstNode = currNode.getNextEntry();
        }

        currNode = currNode.getNextEntry();
        
        while(currNode.getNextEntry() !=  null) {
            currFName = currNode.getNextEntry().getfName();
            currLName = currNode.getNextEntry().getlName();
            currPNumber = currNode.getNextEntry().getPhoneNumber();

            if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
                currNode.setNextEntry(currNode.getNextEntry().getNextEntry());
                break;
            }
            currNode = currNode.getNextEntry();
        }
    }

    public PhoneBookManager(String fNAme, String lName, String address, String phNum, int zip, String email) {

        this.length = 0;
        this.firstNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
    }



}
