//  ASCII art created from https://patorjk.com/software/taag/#p=display&f=3D%20Diagonal&t=
/*
 *  Create viewAllEntries method
 *  Create viewOneEntry method
 *  Create addNewEntry method
 *  Create removeOneEntry method
 *  Add comments where need be
*/

import java.util.Scanner;

public class PhoneBookUI {
    public static void mainMenu() {

        Scanner userInput = new Scanner(System.in);
        String menuInput;
        boolean menuFlag = true;
        
        ASCIIArt();
        System.out.println("Please select one of the following options:\n" +
                        "(e) View all entries in phone book\n" +
                        "(v) View one specific entry in phone book\n" +
                        "(A) Add a new entry in the phone book\n" +
                        "(r) Remove an entry from the phone book\n" +
                        "(q) Quit the program\n");
        
        menuInput = userInput.next();
        char menuOption = menuInput.toLowerCase().charAt(0);

        do {
            switch(menuOption) {
                case('e'):
                    viewAllEntries();
                    menuFlag = false;
                    break;
                case('v'):
                    viewOneEntry();
                    menuFlag = false;
                    break;
                case('a'):
                    addNewEntry();
                    menuFlag = false;
                    break;
                case('r'):
                    removeOneEntry();
                    menuFlag = false;
                    break;
                case('q'):
                    System.out.println("Program Ends");
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    menuInput = userInput.next();
                    menuOption = menuInput.toLowerCase().charAt(0);
                    break;
            }
        } while (menuFlag);

    } //  end of mainMenu method

    public static void viewAllEntries() {
        System.out.println("viewAllEntries");
    } //  end of viewAllEntries method

    public static void viewOneEntry() {
        System.out.println("viewOneEntry");
    } //  end of viewOneEntry method

    public static void addNewEntry() {
        System.out.println("addNewEntry");
    } //  end of addNewEntry method

    public static void removeOneEntry() {
        System.out.println("removeOneEntry");
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