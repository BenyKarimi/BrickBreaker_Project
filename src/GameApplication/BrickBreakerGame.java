package GameApplication;

import SoundManagment.SoundManager;

public class BrickBreakerGame implements Runnable{
    public static SoundManager soundManager = new SoundManager();
    @Override
    public void run() {
        new GameFrame();
    }

    public static void main(String[] args) {
        soundManager.play();
        new BrickBreakerGame().run();
    }
}
