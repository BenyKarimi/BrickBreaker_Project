package FileManagment;

import java.time.LocalDate;

public class FileManager {
    LocalDate date;
    String username;
    int time, score;

    public FileManager(LocalDate date, String username, int time, int score) {
        this.date = date;
        this.username = username;
        this.time = time;
        this.score = score;
    }
}
