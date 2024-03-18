package SoundManagment;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SoundManager {
    private Clip clip;
    boolean selectStop = false;
    public SoundManager() {
        try {
            File audioFile = new File("Imported things/background_sound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.CLOSE && !selectStop) {
                    clip.setFramePosition(0); // بازگرداندن موقعیت به ابتدای فایل صوتی
                    clip.start(); // شروع دوباره پخش
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
            selectStop = false;
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            selectStop = true;
            clip.stop();
        }
    }
}
