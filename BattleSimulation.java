package battle;

import droid.*;
import utils.ConsoleColors;

import java.util.Scanner;

public class BattleSimulation {
    private Scanner scanner = new Scanner(System.in);
    private DroidFactory droidFactory = new DroidFactory();
    private BattleHandler battleHandler = new BattleHandler();

    public static void main(String[] args) {
        BattleSimulation simulation = new BattleSimulation();
        simulation.run();
    }

    private void run() {
        int choice;
        do {
            Menu.displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    droidFactory.createDroid();
                    break;
                case 2:
                    droidFactory.showDroids();
                    break;
                case 3:
                    battleHandler.startOneOnOneBattle(droidFactory.getDroids());
                    break;
                case 4:
                    battleHandler.startTeamBattle(droidFactory.getDroids());
                    break;
                case 5:
                    battleHandler.saveBattleToFile();
                    break;
                case 6:
                    battleHandler.replayBattleFromFile();
                    break;
                case 7:
                    System.out.println(ConsoleColors.ANSI_RED + "Вихід з програми..." + ConsoleColors.ANSI_RESET);
                    break;
                default:
                    System.out.println(ConsoleColors.ANSI_YELLOW + "Невірний вибір. Спробуйте ще раз." + ConsoleColors.ANSI_RESET);
            }
        } while (choice != 7);
    }
}
