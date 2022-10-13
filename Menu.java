public class Menu {
    static void menu() {
        DisplayHelper.setMenuItems();

        while (true) {
            DisplayHelper.showMenu();
            var typing = InputHelper.catchUserInput();

            switch (typing) {
                case "1" -> new TaskManager().switchFile();
                case "2" -> TaskManager.firstTask();
                case "3" -> TaskManager.secondTask();
                case "4" -> TaskManager.thirdTask();
                case "5" -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Not correct. Try again");
            }
        }
    }
}
