package FileManagment;

import Panels.PanelTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileManager {
    LocalDate date;
    String username;
    PanelTimer timer;
    int score;
    private static final String highestScorePath = "src/FileManagment/HighestScore.txt";
    private static final String gameHistoryPath = "src/FileManagment/GameHistory.txt";

    public FileManager(LocalDate date, String username, PanelTimer timer, int score) {
        this.date = date;
        this.username = username;
        this.timer = timer;
        this.score = score;
    }
    public void Save() {
        SaveScore();
        SaveGame();
    }
    public static int GetMaxScore() {
        int num = 0;
        try {
            FileReader fileReader = new FileReader(highestScorePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            num = Integer.parseInt(line);
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
    public void SaveScore() {
        int mx = Math.max(GetMaxScore(), score);
        try (FileWriter writer = new FileWriter(highestScorePath, false)) {
            writer.write(Integer.valueOf(mx).toString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void SaveGame() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = date.format(formatter);

        try (FileWriter writer = new FileWriter(gameHistoryPath, true)) {
            writer.write(formattedDate + "$" + username + "$" + timer.toString() + "$" + Integer.valueOf(score).toString() + "\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
