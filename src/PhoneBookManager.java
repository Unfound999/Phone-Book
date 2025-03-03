public class PhoneBookManager {

    private final EntryNode firstNode;
    private int length;

    public void addEntry(String fNAme, String lName, String address, String phNum, int zip, String email) {

        EntryNode currNode = firstNode;
        while(currNode.getNextEntry() !=  null) {

            currNode = currNode.getNextEntry();
        }

        EntryNode newEntryNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
        currNode.setNextEntry(newEntryNode);

    }

    public PhoneBookManager(String fNAme, String lName, String address, String phNum, int zip, String email) {

        this.length = 0;
        this.firstNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
    }



}
