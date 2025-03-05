

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

            if(currNode.getIndex() > index) {

                currNode.setIndex(currNode.getIndex() + 1);
            }

            if(index == currNode.getNextEntry().getIndex()) {
                
                EntryNode newEntryNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
                newEntryNode.setNextEntry(currNode.getNextEntry());
                currNode.setNextEntry(newEntryNode);
                currNode = newEntryNode;
            }

            
            currNode = currNode.getNextEntry();
        }
    }

    public EntryNode getEntry(String fName, String lName, String pNumber) {

        EntryNode currNode = firstNode;

        String currFName = currNode.getFName();
        String currLName = currNode.getLName();
        String currPNumber = currNode.getPhoneNumber();

        if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
            return firstNode;
        }

        currNode = currNode.getNextEntry();

        while(currNode.getNextEntry() !=  null) {
            currFName = currNode.getNextEntry().getFName();
            currLName = currNode.getNextEntry().getLName();
            currPNumber = currNode.getNextEntry().getPhoneNumber();

            if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
                return currNode.getNextEntry();
            }
            currNode = currNode.getNextEntry();
        }
        return null;
    }

    public String getAllNames() {

        EntryNode currNode = firstNode;
        String longList = "";

        while(currNode !=  null) {
            String currFName = currNode.getFName();
            String currLName = currNode.getLName();
            String currPNumber = currNode.getPhoneNumber();

            longList = longList + currFName + " " + currLName + " " + currPNumber + " ";
            currNode = currNode.getNextEntry();
        }
        return longList;
    }

    public void remove(String fName, String lName, String pNumber) {

        EntryNode currNode = firstNode;

        String currFName = currNode.getFName();
        String currLName = currNode.getLName();
        String currPNumber = currNode.getPhoneNumber();

        if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
            firstNode = currNode.getNextEntry();
        }

        currNode = currNode.getNextEntry();

        while(currNode.getNextEntry() !=  null) {
            currFName = currNode.getNextEntry().getFName();
            currLName = currNode.getNextEntry().getLName();
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
