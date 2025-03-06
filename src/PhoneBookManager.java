

public class PhoneBookManager {

    private EntryNode firstNode;
    private int length;

    private int rawItemCount(){
        int i = 0;
        EntryNode currItem = firstNode;
        while(currItem != null){
            i++;
            currItem = currItem.getNextEntry();
        }
        return i; 
    }

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
        while(currNode !=  null) {
            currFName = currNode.getFName();
            currLName = currNode.getLName();
            currPNumber = currNode.getPhoneNumber();

            if(currFName.equals(fName) && currLName.equals(lName) && currPNumber.equals(pNumber)) {
                return currNode;
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

    /*
     * Citation: Please Note that this method, and the one follow, were developed with the assistant of Github copilot.
     * Void Method
     * This method is simple in theory. It takes two nodes as parameters, and swaps the pointers that reference them.
     * In practice, this method first handles if either of the nodes we're swapping is actually the firstNode in our list.
     * If it is, we set the firstNode to be our new value.
     * Next, we search for the prior node, to each of our nodes that we will be swapping. (This will be null for one if they are the first node.)
     * Once found, we set the references of the prior nodes to reflect the new moved in nodes.
     * Finally, using a temp variable for storage, we update the nextEntry values of a and b, to each others values, preserving the chain. (a.nextEntry becomes b.nextEntry, and vise versa)
     * Parameters:
     *  a (EntryNode) - First Entry to Swap.
     *  b (EntryNode) - Second Entry to swap.
     */
    public void swap(EntryNode a, EntryNode b){
        EntryNode currNode = firstNode;
        EntryNode beforeA = null;
        EntryNode beforeB = null;

        // Check if either value is the first node.
        if(firstNode == a){
            firstNode = b;
        } else if(firstNode == b){
            firstNode = a;
        }

        // Loop through each node in the list to find the prior node.
        while (currNode != null) {
            if(currNode.getNextEntry() == a){
                beforeA = currNode;
            } else if(currNode.getNextEntry() == b){
                beforeB = currNode;
            }
            currNode = currNode.getNextEntry();
        }

        // Update prior nodes to point to new swapped in nodes, with if for potential null on first node.
        if(beforeA != null){
            beforeA.setNextEntry(b);
        }
        if(beforeB != null){
            beforeB.setNextEntry(a);
        }

        // Finally, swap out the next entires of each node, while preserving one in a variable due change happing in one before the other.
        EntryNode prevANext = a.getNextEntry();
        a.setNextEntry(b.getNextEntry());
        b.setNextEntry(prevANext);
    }

    /*
     * Citation: Please Note that this method, were developed with the assistant of Github copilot.
     * Void Method
     * Sort our Linked List via the Selection Sort Algorithm (poor performance choice, but easiest to understand/follow as a beginner)
     * First, we create a list of alphabetical characters to check for the location of. (Which I now realize java can do via .compare but I didn't realize that till much later, and didn't want to change)
     * Then, we start at the first entry in our list, setting that to the value of node A.
     * Then, we proceed to use a while loop to loop through our entire list.
     * We initially assume that the first node we are holding, will be the first one in our list.
     * We then create a new variable, node b, to use for looping through the rest of the list.
     * As we loop through the values of the list in Node B, we check if that letter would come first in the alphabet.
     * If that letter comes first, we change our start node, to that node.
     * Once we are done looping through the list, we swap the location of nodeA, with the letter that comes earlier, unless that value is already our node.
     * Finally, we change Node A to the value of start node, as to make sure we're still operating on the expected next node.
     */
    public void sortByFName(){
        String charMap = "abcdefghijklmnopqrstuvwxyz";
        EntryNode nodeA = firstNode;
        while(nodeA != null){
            EntryNode startNode = nodeA; // Assume A is the least node.
            EntryNode nodeB = nodeA.getNextEntry();

            // Loop through each entry of our Linked List comparing to our current minimum.
            while(nodeB != null){
                char startNodeChar = startNode.getFName().toLowerCase().charAt(0);
                char nodeBChar = nodeB.getFName().toLowerCase().charAt(0);
                if(charMap.indexOf(nodeBChar) < charMap.indexOf(startNodeChar)){
                    startNode = nodeB;
                }
                nodeB = nodeB.getNextEntry();
            }
            if(startNode != nodeA){
                swap(nodeA, startNode);


                // Make sure we're still operating on the expected next node.
                nodeA = startNode;
            }
            nodeA = nodeA.getNextEntry();
        }
    }
}
