//  ASCII art created from https://patorjk.com/software/taag/#p=display&f=3D%20Diagonal&t=
/*
 *  Add interaction between test class and manager class 
 *  Add comments where need be & more proper code formatting
*/

import java.util.Scanner;

public class PhoneBookUI {
    public static void mainMenu() {
        Scanner userInput = new Scanner(System.in);
        String menuInput;
        boolean menuFlag = true;
        char menuOption;
        
        ASCIIArt();
        
        do {
            System.out.println("Please select one of the following options:\n" +
                            "(e) View all entries in phone book\n" +
                            "(v) View one specific entry in phone book\n" +
                            "(A) Add a new entry in the phone book\n" +
                            "(r) Remove an entry from the phone book\n" +
                            "(q) Quit the program\n");
            menuInput = userInput.next();
            menuOption = menuInput.toLowerCase().charAt(0);

            if (Character.toString(menuOption).matches("[evarq]")) {
                switch(menuOption) {
                    case('e'): viewAllEntries(); break;
                    case('v'): viewOneEntry(); break;
                    case('a'): addNewEntry(); break;
                    case('r'): removeOneEntry(); break;
                    case('q'): System.out.println("Program Ends"); menuFlag = false; break;
                }
            } else {
                System.out.println("Invalid input, please try again");
            }
        } while (menuFlag);
    } //  end of mainMenu method

    public static void viewAllEntries() {
        Scanner userInput = new Scanner(System.in);
        String menuInput;
        String entryNames = "Adam Sandler Mary Johnsons Micheal Williams Patricia Brown Robert Jones Jennifer Garcia";
        boolean menuFlag = true;
        char menuOption;

        // entryNames = {Call method from Manager class here to get String of data, using a while loop, hasNext, and next to print each name one by one}
        Scanner names = new Scanner(entryNames);

        // The following is just a hardcoded version of what UI would look like. This bit of code is temporary
        printLine();
        System.out.println("All entries: ");

        while (names.hasNext()) {
            System.out.print(names.next() + " ");
            System.out.println(names.next());
        }

        System.out.println("\nIf you would like to view a specific entry type \"v\" or to go back to the main menu, type \"q\"");
        menuInput = userInput.next();
        menuOption = menuInput.toLowerCase().charAt(0);

        do { 
            switch (menuOption) {
                case('v'): viewOneEntry(); menuFlag = false; break;
                case('q'): System.out.println("\n\n"); menuFlag = false; break;
                default:
                    System.out.println("Invalid input, please try again");
                    menuInput = userInput.next();
                    menuOption = menuInput.toLowerCase().charAt(0);
                    break;
            }
        } while (menuFlag);
    } //  end of viewAllEntries method

    public static void viewOneEntry() {
        Scanner userInput = new Scanner(System.in);
        String entryFName, entryLName, phoneNum;
        boolean nameFlag = false;
        boolean menuFlag = true;
        //  EntryNode entry = new EntryNode;

        printLine();

        do {
            System.out.print("Please enter the first name of the entry you would like to see or type \"quit\" to quit: ");
            entryFName = userInput.next();

            if (entryFName.toLowerCase().matches("quit")) {
                menuFlag = false;
            } else {
                System.out.print("Please enter the last name of the entry you would like to see or type \"quit\": ");
                entryLName = userInput.next();
                if (entryLName.toLowerCase().matches("quit")) {
                    menuFlag = false;
                } else {
                    System.out.print("Please enter the phone number of the entry you would like to remove or type \"quit\": ");
                    phoneNum = userInput.next();
                    if (phoneNum.toLowerCase().matches("quit")) {
                        menuFlag = false;
                    } else {
                        // nameFlag = {method}; {Call method from manager class that checks if an object with that name exists in linkedlist}
                        if (nameFlag == false) {
                            System.out.println("That user does not exist, please try again\n\n");
                        } else {
                            System.out.println("User removed successfully");
                            menuFlag = false;
                            //  entry = {Method that takes in entry name and returns an object}
                            //  System.out.println(entry); {prints out data in entry object by implicitly calling custom made toString method}
                            System.out.println("User successfully removed");
                        }
                    }
                }
            }
        } while (menuFlag);
        System.out.println("\n\n");
    } //  end of viewOneEntry method

    public static void addNewEntry() {
        Scanner userInput = new Scanner(System.in);
        Scanner addressInput = new Scanner(System.in);
        boolean nameFlag = false;

        printLine();

        System.out.print("Please enter the entry's first name: ");
        String entryFName = userInput.next();
        
        System.out.print("Please enter the entry's last name: ");
        String entryLName = userInput.next();

        System.out.print("Please enter the entry's address [street city state]: ");
        String address = addressInput.nextLine();

        System.out.print("Please enter the entry's phone number: ");
        String phoneNum = userInput.next();

        System.out.print("Please enter the entry's zipcode: ");
        String zipCode = userInput.next();

        System.out.print("Please enter the entry's email address: ");
        String email = userInput.next();

        // nameFlag = {method}; {Call method from manager class that checks if an object with that name exists in linkedlist}

        if (nameFlag) {
            System.out.println("User already exists");
        } else {
            //  {passes needed data to called method from manager class}
            System.out.println("User successfully created");
        }

        System.out.println("\n\n");
    } //  end of addNewEntry method

    public static void removeOneEntry() {
        Scanner userInput = new Scanner(System.in);
        String entryFName, entryLName, phoneNumber;
        boolean nameFlag = false;
        boolean menuFlag = true;

        printLine();

        do {
            System.out.print("Please enter the first name of the entry you would like to remove or type \"quit\" to quit: ");
            entryFName = userInput.next();

            if (entryFName.toLowerCase().matches("quit")) {
                menuFlag = false;
            } else {
                System.out.print("Please enter the last name of the entry you would like to remove or type \"quit\": ");
                entryLName = userInput.next();
                if (entryLName.toLowerCase().matches("quit")) {
                    menuFlag = false;
                } else {
                    System.out.print("Please enter the phone number of the entry you would like to remove or type \"quit\": ");
                    phoneNumber = userInput.next();
                    if (phoneNumber.toLowerCase().matches("quit")) {
                        menuFlag = false;
                    } else {
                        // nameFlag = {method}; {Call method from manager class that checks if an object with that name exists in linkedlist}
                        if (nameFlag == false) {
                            System.out.println("That user does not exist, please try again\n\n");
                        } else {
                            //  {calls method from manager class that removes user from linkedlist}
                            System.out.println("User removed successfully");
                            menuFlag = false;
                        }
                    }
                }
            }
        } while (menuFlag);
        System.out.println("\n\n");
    } //  end of removeOneEntry method

    //  Prints ASCIIArt in main menu
    public static void ASCIIArt() {
        System.out.println("                                                                                                                \r\n" + 
                        "                                                                                                                \r\n" + 
                        "                        ,--,    ,--,                                      ,---,.                           ,-.  \r\n" + 
                        "        ,---,         ,--.'|  ,--.'|                                    ,'  .'  \\                      ,--/ /|  \r\n" + 
                        "       /_ ./|         |  | :  |  | :     ,---.           .---.        ,---.' .' |   ,---.     ,---.  ,--. :/ |  \r\n" + 
                        " ,---, |  ' :         :  : '  :  : '    '   ,'\\         /. ./|        |   |  |: |  '   ,'\\   '   ,'\\ :  : ' /   \r\n" + 
                        "/___/ \\.  : |  ,---.  |  ' |  |  ' |   /   /   |     .-'-. ' |        :   :  :  / /   /   | /   /   ||  '  /    \r\n" + 
                        " .  \\  \\ ,' ' /     \\ '  | |  '  | |  .   ; ,. :    /___/ \\: |        :   |    ; .   ; ,. :.   ; ,. :'  |  :    \r\n" + 
                        "  \\  ;  `  ,'/    /  ||  | :  |  | :  '   | |: : .-'.. '   ' .        |   :     \\'   | |: :'   | |: :|  |   \\   \r\n" + 
                        "   \\  \\    '.    ' / |'  : |__'  : |__'   | .; :/___/ \\:     '        |   |   . |'   | .; :'   | .; :'  : |. \\  \r\n" + 
                        "    '  \\   |'   ;   /||  | '.'|  | '.'|   :    |.   \\  ' .\\           '   :  '; ||   :    ||   :    ||  | ' \\ \\ \r\n" + 
                        "     \\  ;  ;'   |  / |;  :    ;  :    ;\\   \\  /  \\   \\   ' \\ |        |   |  | ;  \\   \\  /  \\   \\  / '  : |--'  \r\n" + 
                        "      :  \\  \\   :    ||  ,   /|  ,   /  `----'    \\   \\  |--\"         |   :   /    `----'    `----'  ;  |,'     \r\n" + 
                        "       \\  ' ;\\   \\  /  ---`-'  ---`-'              \\   \\ |            |   | ,'                       '--'       \r\n" + 
                        "        `--`  `----'                                '---\"             `----'                                    \r\n" + 
                        "                                                                                                                ");
    } //  end of ASCIIArt method

    public static void printLine() {
        System.out.println("\n\n***********************************************************************************");
    } //  end of printLine method
} //  end of PhoneBookUI class