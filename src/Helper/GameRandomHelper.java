package Helper;

import Model.BrickType;
import Model.ItemType;
import Panels.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameRandomHelper {
    private static final Random random = new Random();
    private static int ballNumber;

    public static int BallNumbers() {
        ballNumber = random.nextInt(5, 16);
        return ballNumber;
    }
    public static int BrickAndItemAddY(Level level) {
        if (level.equals(Level.EASY)) {
            return random.nextInt(1, 3);
        }
        else if (level.equals(Level.MEDIUM)) {
            return random.nextInt(3, 5);
        }
        return random.nextInt(5, 7);
    }
    public static int BrickValue(Level level) {
        if (level.equals(Level.EASY)) {
            return random.nextInt(ballNumber, 2 * ballNumber + 1);
        }
        else if (level.equals(Level.MEDIUM)) {
            return random.nextInt((2 * ballNumber) - (ballNumber / 2), (3 * ballNumber) - (ballNumber / 2) + 1);
        }
        else {
            return random.nextInt(2 * ballNumber, 3 * ballNumber + 1);
        }
    }
    public static int BrickAddingValue(Level level) {
        if (level.equals(Level.EASY)) {
            return random.nextInt(1, 3);
        }
        else if (level.equals(Level.MEDIUM)) {
            return random.nextInt(2, 4);
        }
        else {
            return random.nextInt(3, 5);
        }
    }
    public static int BallXPosition() {
        return random.nextInt(25, 675);
    }
    public static ArrayList<Integer> BricksPosition(Level level) {
        ArrayList<Integer> keep = new ArrayList<>();
        int cnt;

        if (level.equals(Level.EASY)) {
            cnt = random.nextInt(1, 4);
        }
        else if (level.equals(Level.MEDIUM)) {
            cnt = random.nextInt(2, 5);
        }
        else {
            cnt = random.nextInt(3, 6);
        }

        while (keep.size() < cnt) {
            int rand = random.nextInt(0, 7);
            boolean ok = true;
            for (Integer integer : keep) if (integer.equals(rand)) ok = false;
            if (ok) keep.add(rand);
        }
        return keep;
    }
    public static BrickType BrickRandomType() {
        int num = random.nextInt(0, 3);
        if (num == 0) return BrickType.PLAIN;
        if (num == 1) return BrickType.EARTHQUAKE;
        return BrickType.DANCING_LIGHT;
    }
    public static ArrayList<Integer> ItemsPosition(Level level, ArrayList<Integer> pos) {
        ArrayList<Integer> keep = new ArrayList<>();
        int cnt;

        if (level.equals(Level.EASY)) {
            cnt = random.nextInt(1, 7 - pos.size());
        }
        else {
            cnt = random.nextInt(0, 7 - pos.size());
        }

        while (keep.size() < cnt) {
            int rand = random.nextInt(0, 7);
            boolean ok = true;
            for (Integer integer : pos) if (integer.equals(rand)) ok = false;
            for (Integer integer : keep) if (integer.equals(rand)) ok = false;
            if (ok) keep.add(rand);
        }
        return keep;
    }
    public static ItemType ItemRandomType() {
        int num = random.nextInt(0, 3);
        if (num == 0) return ItemType.SPEED_UP;
        if (num == 1) return ItemType.POWER_UP;
        return ItemType.DIZZINESS;
    }
}
