

public class PhoneBookManager {

    private EntryNode firstNode;
    private int length;

    //This method handles adding an entry to the end of the node.
    public void addEntry(String fNAme, String lName, String address, String phNum, int zip, String email) {

        EntryNode currNode = firstNode;
        while(currNode.getNextEntry() !=  null) {

            currNode = currNode.getNextEntry();
        }

        EntryNode newEntryNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
        currNode.setNextEntry(newEntryNode);

    }

    //This method handles adding an entry to a specific index in the node.
    public void addEntry(String fNAme, String lName, String address, String phNum, int zip, String email, int index) {

        EntryNode currNode = firstNode;

        while(currNode.getNextEntry() !=  null) {

            //Checking that the index of the current node is larger than the index requested before we edit the node in question
            if(currNode.getIndex() > index) {

                currNode.setIndex(currNode.getIndex() + 1);
            }

            //Editing node in question
            if(index == currNode.getNextEntry().getIndex()) {
                
                EntryNode newEntryNode = new EntryNode(index, fNAme, lName, address, phNum, zip, email);
                newEntryNode.setNextEntry(currNode.getNextEntry());
                currNode.setNextEntry(newEntryNode);
                currNode = newEntryNode;
                this.length++;
            }  
            currNode = currNode.getNextEntry();
        }
    }

    //Method to return a specific entry based on someones first and last name, and phone number.
    public EntryNode getEntry(String fName, String lName, String pNumber) {

        EntryNode currNode = firstNode;

        if(currNode == null){
            return null;
        }

        String currFName = currNode.getFName();
        String currLName = currNode.getLName();
        String currPNumber = currNode.getPhoneNumber();

        //Check if first node is the one we're are looking for.
        if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
            return firstNode;
        }

        currNode = currNode.getNextEntry();

        if(currNode == null){
            // We were operating on the first node, and it was the only entry.
            return null;
        }

        //Carry out operations to check for our node in question, then return the node in question.
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

    //Method that returns all names in a long list by looping through a while loop.
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

    //Method that handles if the first node is the one needing removal. Then handles the the rest with a while loop that checks if the information is equivalent and then
    //removes the node in question by putting the node in front on it, in it's place. Then java garbage collection
    public void remove(String fName, String lName, String pNumber) {

        EntryNode currNode = firstNode;

        String currFName = currNode.getFName();
        String currLName = currNode.getLName();
        String currPNumber = currNode.getPhoneNumber();

        if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
            firstNode = currNode.getNextEntry();
            return;
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

    //Constructor that initialized the length and creates a node with all parameters passed through the method.
    public PhoneBookManager(String fNAme, String lName, String address, String phNum, int zip, String email) {

        this.length = 0;
        this.firstNode = new EntryNode(this.length++, fNAme, lName, address, phNum, zip, email);
    }

    public void sortByFName(){
        String charMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        EntryNode prevNode = null;
        EntryNode currNode = firstNode;
        
        if(currNode.getNextEntry() == null){
            return; // Only one entry, always sorted by that virtue.
        }

        while(currNode != null){
            char currFNameChar = currNode.getFName().toUpperCase().charAt(0);
            char nextFNameChar = currNode.getNextEntry().getFName().charAt(0);
            if(charMap.indexOf(currFNameChar) > charMap.indexOf(nextFNameChar)){
                if(prevNode == null){
                    // We must be at the first node.
                    EntryNode nextNode = currNode.getNextEntry();
                    nextNode.setNextEntry(currNode);
                    firstNode = nextNode;
                } else {
                    prevNode.setNextEntry(currNode.getNextEntry());
                    currNode.getNextEntry().setNextEntry(currNode);
                }
            }
            prevNode = currNode;
            currNode = currNode.getNextEntry();
        }
    }

    public static void main(String[] args) {
        PhoneBookManager x = new PhoneBookManager("Bob", "Fred", "null", "null", 0, "null");
        x.addEntry("Anna", "Frank", "null", "null", 0, "null");
        x.addEntry("Zedger", "Smith", "", "", 0, "");
        x.sortByFName();
    }
}
