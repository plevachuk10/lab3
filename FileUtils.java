package utils;

import java.io.*;

public class FileUtils {
    public static void saveBattle(String battleLog, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(battleLog);
            System.out.println("Бій збережено у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка збереження бою у файл.");
        }
    }

    public static String loadBattle(String fileName) {
        StringBuilder battleLog = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                battleLog.append(line).append("\n");
            }
            System.out.println("Бій відтворено з файлу: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка відтворення бою з файлу.");
        }
        return battleLog.toString();
    }
}
