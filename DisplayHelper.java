import java.util.ArrayList;
import java.util.Objects;

public class DisplayHelper {
    static ArrayList<String> menuItems = new ArrayList<String>();

    static void setMenuItems() {
        menuItems.add("1. Change language");
        menuItems.add("2. Task 1");
        menuItems.add("3. Task 2");
        menuItems.add("4. Task 3");
        menuItems.add("5. Exit");
    }

    static void showMenu() {
        System.out.println("-------- Menu --------");
        System.out.println(menuItems.get(0));
        System.out.println(menuItems.get(1));
        System.out.println(menuItems.get(2));
        System.out.println(menuItems.get(3));
        System.out.println(menuItems.get(4));
        System.out.println("----------------------");
        System.out.println("Please, print 1, 2, 3 or 4 for program working or print 5 for exit program!\n");
    }

    static void showThreeWords(ArrayList<ArrayList<String>> mas) {
        System.out.println("-----------------------------------------------");
        System.out.println("Всі трійки слів, які можуть претендувати на прізвище, ім’я та по-батькові деяких осіб");
        for (ArrayList<String> array: mas) {
            if (!array.isEmpty()) {
                for (String snp: array) {
                    if (!Objects.equals(snp, ""))
                        System.out.println(snp);
                }
            }
        }
    }

    static void showRightSentences(ArrayList<String> mas){
        System.out.println("Речення-сусіди для того речення, в якому було знайдено відповідну інформацію");
        for (String i: mas) {
            System.out.println(i);
        }
    }

    static void displayData(String data) {
        System.out.println("File data: ");

        for (int i = 0; i < data.length(); i++) {
            if( i % 150 == 0) {
                System.out.println(data.charAt(i));
            } else {
                System.out.print(data.charAt(i));
            }
        }

        System.out.println("----------------------");
    }
}
