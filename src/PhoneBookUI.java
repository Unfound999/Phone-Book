//  ASCII art created from https://patorjk.com/software/taag/#p=display&f=3D%20Diagonal&t=
/*
 *  Fix up Create viewOneEntry method 
 *  Add comments where need be
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
                    case('e'):
                        viewAllEntries();
                        break;
                    case('v'):
                        viewOneEntry();
                        break;
                    case('a'):
                        addNewEntry();
                        break;
                    case('r'):
                        removeOneEntry();
                        break;
                    case('q'):
                        System.out.println("Program Ends");
                        menuFlag = false;
                        break;
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
        System.out.println("\n\n***********************************************************************************");
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
                case('v'):
                    viewOneEntry();
                    menuFlag = false;
                    break;
                case('q'):
                    System.out.println("\n\n\n\n\n");
                    menuFlag = false;
                    break;
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
        String entryFName;
        String entryLName;
        boolean nameFlag = false;
        boolean menuFlag = true;
        //  EntryNode entry = new EntryNode;

        do {
            System.out.print("Please enter the first name of the entry you would like to see or type \"q\" to quit: ");
            entryFName = userInput.next();

            //  SIDE NOTE: CURRENT ITERATION OF CODE DOES NOT REALLY ALLOW FOR FIRST NAMES THAT START WITH Q, FIX THIS LATER
            //  first, checks if user types 'q' for the first name, if so, turn boolean to false that skips right to ending the previous menu
            //  if the user types anything that is not 'q', check if name exists in linkedlist, if not, ask user again
            //  secondly, prompts and checks if user types 'q' for last name, if so, turn boolean to false that skips right to ending the previous menu
            //  thirdly, call a method in manager class that checks if an object exists with a matching first name and matching last name
            //  if user exists, print information to user.
            if (entryFName.toLowerCase().charAt(0) == 'q') {
                menuFlag = false;
            } else {
                System.out.print("Please enter the last name of the entry you would like to see or type \"q\": ");
                entryLName = userInput.next();
                if (entryLName.toLowerCase().charAt(0) == 'q') {
                    menuFlag = false;
                } else {
                    // nameFlag = {method}; {Call method from manager class that checks if an object with that name exists in linkedlist}
                    if (nameFlag == false) {
                        System.out.println("That user does not exist, please try again\n\n");
                    } else {
                        //  entry = {Method that takes in entry name and returns an object}
                        //  System.out.println(entry); {prints out data in entry object by implicitly calling custom made toString method}
                    }
                }
            }
        } while (menuFlag);

    } //  end of viewOneEntry method

    public static void addNewEntry() {

        Scanner userInput = new Scanner(System.in);
        String entryFName;
        String entryLName;
        String address;
        String phoneNum;
        String zipCode;
        String email;

        System.out.print("Please enter the entry's first name: ");
        entryFName = userInput.next();
        
        System.out.print("Please enter the entry's last name: ");
        entryLName = userInput.next();

        System.out.print("Please enter the entry's address [street city state]: ");
        address = userInput.next();

        System.out.print("Please enter the entry's phone number: ");
        phoneNum = userInput.next();

        System.out.print("Please enter the entry's zipcode: ");
        zipCode = userInput.next();

        System.out.print("Please enter the entry's email address: ");
        email = userInput.next();

        //  {passes needed data to called method from manager class}

        System.out.println("User created successfully");
    } //  end of addNewEntry method

    public static void removeOneEntry() {

        Scanner userInput = new Scanner(System.in);
        String entryFName;
        String entryLName;
        boolean nameFlag = false;
        boolean menuFlag = true;

        do {
            System.out.print("Please enter the first name of the entry you would like to remove or type \"q\" to quit: ");
            entryFName = userInput.next();

            if (entryFName.toLowerCase().charAt(0) == 'q') {
                menuFlag = false;
            } else {
                System.out.print("Please enter the last name of the entry you would like to remove or type \"q\": ");
                entryLName = userInput.next();
                if (entryLName.toLowerCase().charAt(0) == 'q') {
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
        } while (menuFlag);
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
} //  end of PhoneBookUI class