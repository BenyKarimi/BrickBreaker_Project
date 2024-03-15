public class BrickBreakerGame implements Runnable{
    @Override
    public void run() {
        new GameFrame();
    }

    public static void main(String[] args) {
        new BrickBreakerGame().run();
    }
}
