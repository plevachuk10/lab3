package battle;

import droid.*;
import utils.ConsoleColors;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleHandler {
    private Scanner scanner = new Scanner(System.in);

    public void startOneOnOneBattle(ArrayList<Droid> droids) {
        if (droids.size() < 2) {
            System.out.println(ConsoleColors.ANSI_RED + "Недостатньо дроїдів для бою 1 на 1." + ConsoleColors.ANSI_RESET);
            return;
        }

        System.out.println(ConsoleColors.ANSI_PURPLE + "Оберіть першого дроїда (номер у списку): " + ConsoleColors.ANSI_RESET);
        int firstDroidIndex = scanner.nextInt() - 1;
        System.out.println(ConsoleColors.ANSI_PURPLE + "Оберіть другого дроїда (номер у списку): " + ConsoleColors.ANSI_RESET);
        int secondDroidIndex = scanner.nextInt() - 1;

        Droid firstDroid = droids.get(firstDroidIndex);
        Droid secondDroid = droids.get(secondDroidIndex);

        System.out.println(ConsoleColors.ANSI_YELLOW + firstDroid.getName() + " має " + firstDroid.getHealth() + " здоров'я." + ConsoleColors.ANSI_RESET);
        System.out.println(ConsoleColors.ANSI_YELLOW + secondDroid.getName() + " має " + secondDroid.getHealth() + " здоров'я." + ConsoleColors.ANSI_RESET);

        // Логіка бою
        while (firstDroid.getHealth() > 0 && secondDroid.getHealth() > 0) {
            secondDroid.takeDamage(firstDroid.getDamage());
            if (secondDroid.getHealth() <= 0) {
                System.out.println(ConsoleColors.ANSI_GREEN + secondDroid.getName() + " переможений." + ConsoleColors.ANSI_RESET);
                break;
            }

            firstDroid.takeDamage(secondDroid.getDamage());
            if (firstDroid.getHealth() <= 0) {
                System.out.println(ConsoleColors.ANSI_GREEN + firstDroid.getName() + " переможений." + ConsoleColors.ANSI_RESET);
            }

            System.out.println(ConsoleColors.ANSI_YELLOW + firstDroid.getName() + " має " + firstDroid.getHealth() + " здоров'я." + ConsoleColors.ANSI_RESET);
            System.out.println(ConsoleColors.ANSI_YELLOW + secondDroid.getName() + " має " + secondDroid.getHealth() + " здоров'я." + ConsoleColors.ANSI_RESET);
        }
    }

    public void startTeamBattle(ArrayList<Droid> droids) {
        if (droids.size() < 4) {
            System.out.println(ConsoleColors.ANSI_RED + "Недостатньо дроїдів для командного бою." + ConsoleColors.ANSI_RESET);
            return;
        }

        // Логіка командного бою
        System.out.println(ConsoleColors.ANSI_PURPLE + "Оберіть команду 1 (введіть номери дроїдів, розділені пробілом):" + ConsoleColors.ANSI_RESET);
        String[] firstTeamInput = scanner.next().split(" ");
        ArrayList<Droid> team1 = new ArrayList<>();
        for (String index : firstTeamInput) {
            team1.add(droids.get(Integer.parseInt(index) - 1));
        }

        System.out.println(ConsoleColors.ANSI_PURPLE + "Оберіть команду 2 (введіть номери дроїдів, розділені пробілом):" + ConsoleColors.ANSI_RESET);
        String[] secondTeamInput = scanner.next().split(" ");
        ArrayList<Droid> team2 = new ArrayList<>();
        for (String index : secondTeamInput) {
            team2.add(droids.get(Integer.parseInt(index) - 1));
        }

        // Ведення бою між командами
        while (!team1.isEmpty() && !team2.isEmpty()) {
            for (Droid attacker : team1) {
                Droid target = team2.stream().filter(droid -> droid.getHealth() > 0).findAny().orElse(null);
                if (target != null) {
                    target.takeDamage(attacker.getDamage());
                    if (target.getHealth() <= 0) {
                        team2.remove(target);
                    }
                }
            }

            for (Droid attacker : team2) {
                Droid target = team1.stream().filter(droid -> droid.getHealth() > 0).findAny().orElse(null);
                if (target != null) {
                    target.takeDamage(attacker.getDamage());
                    if (target.getHealth() <= 0) {
                        team1.remove(target);
                    }
                }
            }
        }

        System.out.println(ConsoleColors.ANSI_BLUE + (team1.isEmpty() ? "Команда 2 перемогла!" : "Команда 1 перемогла!") + ConsoleColors.ANSI_RESET);
    }

    public void saveBattleToFile() {
        System.out.print("Введіть ім'я файлу для збереження бою: ");
        String fileName = scanner.next();
        FileUtils.saveBattle("Лог бою", fileName);
    }

    public void replayBattleFromFile() {
        System.out.print("Введіть ім'я файлу для відтворення бою: ");
        String fileName = scanner.next();
        String battleLog = FileUtils.loadBattle(fileName);
        System.out.println(battleLog);
    }
}
