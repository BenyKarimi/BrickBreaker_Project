package Model;

import java.awt.*;
import java.util.Objects;

public class Brick {
    private int width, height, xBegin, yBegin, value;
    private BrickType brickType;
    private Color color;

    public Brick(int width, int height, int xBegin, int yBegin, int value, BrickType brickType, Color color) {
        this.width = width;
        this.height = height;
        this.xBegin = xBegin;
        this.yBegin = yBegin;
        this.value = value;
        this.brickType = brickType;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brick brick = (Brick) o;
        return width == brick.width && height == brick.height && xBegin == brick.xBegin && yBegin == brick.yBegin;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxBegin() {
        return xBegin;
    }

    public void setxBegin(int xBegin) {
        this.xBegin = xBegin;
    }

    public int getyBegin() {
        return yBegin;
    }

    public void setyBegin(int yBegin) {
        this.yBegin = yBegin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BrickType getBrickType() {
        return brickType;
    }

    public void setBrickType(BrickType brickType) {
        this.brickType = brickType;
    }
}
