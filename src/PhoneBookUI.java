//  ASCII art created from https://patorjk.com/software/taag/#p=display&f=3D%20Diagonal&t=

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookUI {

    PhoneBookManager manager;

   // public PhoneBookUI() {
   //     this.manager = new PhoneBookManager();
   // }

    //  Prompts user with main menu and runs methods based on user input
    public void mainMenu() {
        Scanner userInput = new Scanner(System.in);
        String menuInput;
        boolean menuFlag = true;
        char menuOption;
        
        ASCIIArt(); //  prints ASCII art of phone book title
        
        //  prints main menu prompt to user
        do {
            System.out.println("Please select one of the following options:\n" +
                            "(e) View all entries in phone book\n" +
                            "(v) View one specific entry in phone book\n" +
                            "(A) Add a new entry in the phone book\n" +
                            "(r) Remove an entry from the phone book\n" +
                            "(q) Quit the program\n");
            menuInput = userInput.next();
            menuOption = menuInput.toLowerCase().charAt(0);

            //  calls methods based on user input & ensuring that the input is valid
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

    //  calls method from Manager class to obtain list of  entry names and phone numbers and prints them to user
    public void viewAllEntries() {
        Scanner userInput = new Scanner(System.in);
        String menuInput;
        String entryNames;
        boolean menuFlag = true;
        char menuOption;

        entryNames = manager.getAllNames();
        Scanner names = new Scanner(entryNames);

        printLine(); //  prints solid line for user readability
        System.out.println("All entries: ");
        
        //  grabs names and phonenumbers from String and prints them to user
        while (names.hasNext()) {
            System.out.println(names.next() + " " + names.next() + " " + names.next());
        }

        //  prompts user and either runs methods or quits back to main menu based on user input
        System.out.println("\nIf you would like to view a specific entry type \"v\" or to go back to the main menu, type \"q\"");
        menuInput = userInput.next();
        menuOption = menuInput.toLowerCase().charAt(0);

        //  ensures that user enters a valid input of 'v' or 'q'
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

    //  checks if an entry exists based on user inputted data and if it does exist, print entry's information to user
    public void viewOneEntry() {
        Scanner userInput = new Scanner(System.in);
        String entryFName, entryLName, phoneNum;
        boolean menuFlag = true;
        EntryNode entry;

        printLine(); // prints solid line for user readability

        /*  prompts user for specific entry's name and phonenumber, checks if that entry exists
         *  if entry does exist, print entry's information to the user
         *  If the user types "quit" at any point, quit back to main menu
        */
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
                        entry = manager.getEntry(entryFName, entryLName, phoneNum);
                        if (entry == null) {
                            System.out.println("That user does not exist, please try again\n\n");
                        } else {
                            menuFlag = false;
                            System.out.println();
                            System.out.println(entry);
                        }
                    }
                }
            }
        } while (menuFlag);
        System.out.println("\n\n"); //  println for user readability
    } //  end of viewOneEntry method

    //  prompts user for all data needed to create an entry and calls a Manager class method that creates entry with inputted data
    public void addNewEntry() {
        Scanner userInput = new Scanner(System.in);
        Scanner addressInput = new Scanner(System.in);
        int zipCode = 0;
        boolean nameFlag = false;
        boolean zipCheck = false;
        EntryNode entry;

        printLine(); //  prints solid line for user readability

        System.out.print("Please enter the entry's first name: ");
        String entryFName = userInput.next();
        
        System.out.print("Please enter the entry's last name: ");
        String entryLName = userInput.next();

        System.out.print("Please enter the entry's address [street city state]: ");
        String address = addressInput.nextLine();

        System.out.print("Please enter the entry's phone number: ");
        String phoneNum = userInput.next();

        //  try-catch ensures that the user inputts 
        do {
            System.out.print("Please enter the entry's zipcode: ");
            try {
                zipCode = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You inputted a non-integer, please enter only integers for the zipcode [0-9]");
                userInput.next();
            }
            zipCheck = true;
        } while (!zipCheck);

        System.out.print("Please enter the entry's email address: ");
        String email = userInput.next();

        //  if manager variable is empty, prompt user to create a new entry
        if (manager == null) {
            this.manager = new PhoneBookManager(entryFName, entryLName, address, phoneNum, zipCode, email);
            return;
        }

        entry = manager.getEntry(entryFName, entryLName, phoneNum);

        //  if entry already exists, state so to user, but if entry does not exist, call Manager class method to create entry
        if (entry != null) {
            System.out.println("User already exists");
        } else {
            manager.addEntry(entryFName, entryLName, address, phoneNum, zipCode, email);
            System.out.println("User successfully created");
        }

        System.out.println("\n\n"); //  println for user readability
    } //  end of addNewEntry method

    //  checks if an entry exists based on user inputted data and if it does exist, call Manager method to remove entry
    public void removeOneEntry() {
        Scanner userInput = new Scanner(System.in);
        String entryFName, entryLName, phoneNum;
        boolean nameFlag = false;
        boolean menuFlag = true;
        EntryNode entry;

        printLine(); //  prints a solid line for user readability

        /*  prompts user for specific entry's name and phonenumber, checks if that entry exists
         *  if entry does exist, call Manager class method to remove entry
         *  If the user types "quit" at any point, quit back to main menu
        */
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
                    phoneNum = userInput.next();
                    if (phoneNum.toLowerCase().matches("quit")) {
                        menuFlag = false;
                    } else {
                        entry = manager.getEntry(entryFName, entryLName, phoneNum);
                        if (entry == null) {
                            System.out.println("That user does not exist, please try again\n\n");
                        } else {
                            manager.remove(entryFName, entryLName, phoneNum);
                            System.out.println("User removed successfully");
                            menuFlag = false;
                        }
                    }
                }
            }
        } while (menuFlag);
        System.out.println("\n\n"); //  println for user readability
    } //  end of removeOneEntry method

    //  Prints ASCIIArt in main menu
    public void ASCIIArt() {
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

    //  prints a solid line to seperate different menus to improve User Interface
    public void printLine() {
        System.out.println("\n\n***********************************************************************************");
    } //  end of printLine method
} //  end of PhoneBookUI class