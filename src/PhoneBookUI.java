//  ASCII art created from https://patorjk.com/software/taag/#p=display&f=3D%20Diagonal&t=

import java.util.Scanner;

public class PhoneBookUI {
    public static void mainMenu() {

        Scanner userInput = new Scanner(System.in);

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

        System.out.println("Please select one of the following options:\n" +
                        " (e) View all entries in phone book\n" +
                        " (v) View one specific entry in phone book\n" +
                        " (A) Add a new entry in the phone book\n" +
                        " (r) Remove an entry from the phone book\n" +
                        " (q) Quit the program\n");

    } //  end of mainMenu method

    public static void viewAllEntries() {

    } //  end of viewAllEntries method

    public static void viewOneEntry() {

    } //  end of viewOneEntry method

    public static void addNewEntry() {

    } //  end of addNewEntry method

    public static void removeOneEntry() {

    } //  end of removeOneEntry method
} //  end of PhoneBookUI class