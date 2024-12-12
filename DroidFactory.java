package droid;

import utils.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class DroidFactory {
    private ArrayList<Droid> droids = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createDroid() {
        System.out.println(ConsoleColors.ANSI_BLUE + "Оберіть тип дроїда:" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_GREEN + "1. WarriorDroid" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_YELLOW + "2. ASeriesDroid" + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_PURPLE + "3. RSuperDroid" + ConsoleColors.ANSI_RESET);

        int type = scanner.nextInt();
        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.next();

        switch (type) {
            case 1:
                droids.add(new WarriorDroid(name));
                break;
            case 2:
                droids.add(new ASeriesDroid(name));
                break;
            case 3:
                droids.add(new RSuperDroid(name));
                break;
            default:
                System.out.println(ConsoleColors.ANSI_RED + "Невірний вибір." + ConsoleColors.ANSI_RESET);
        }
        System.out.println(ConsoleColors.ANSI_GREEN + "Дроїд створений!" + ConsoleColors.ANSI_RESET);
    }

    public void showDroids() {
        System.out.println(ConsoleColors.ANSI_YELLOW + "Список дроїдів:" + ConsoleColors.ANSI_RESET);
        if (droids.isEmpty()) {
            System.out.println(ConsoleColors.ANSI_RED + "Немає створених дроїдів." + ConsoleColors.ANSI_RESET);
        } else {
            for (int i = 0; i < droids.size(); i++) {
                Droid droid = droids.get(i);
                System.out.println((i + 1) + ". " + droid.getName() + " (Тип: " + droid.getType() + ") має " + droid.getHealth() + " здоров'я.");
            }
        }
    }


    public ArrayList<Droid> getDroids() {
        return droids;
    }

    public String getType() {
        return "Droid";
    }
}
