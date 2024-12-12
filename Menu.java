package battle;

import utils.ConsoleColors;

public class Menu {
    public static void displayMenu() {
        System.out.println(ConsoleColors.ANSI_BLUE + "Меню:" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_GREEN + "1. Створити дроїда" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_YELLOW + "2. Показати список створених дроїдів" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_PURPLE + "3. Бій 1 на 1" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_RED + "4. Командний бій" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_GREEN + "5. Записати бій у файл" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_YELLOW + "6. Відтворити бій із файлу" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_BLUE + "7. Вийти" + ConsoleColors.ANSI_RESET);
    }
}
