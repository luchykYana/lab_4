import java.util.Scanner;

public class InputHelper {
    static String catchUserInput() {
        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }

    static void waitBeforeMenu() {
        System.out.println("Press any key and go to menu.");

        Scanner myObj = new Scanner(System.in);
        myObj.nextLine();
    }
}
