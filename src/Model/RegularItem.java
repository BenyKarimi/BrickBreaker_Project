package Model;

import java.awt.*;
import java.util.Objects;

public class RegularItem {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private ItemType itemType;
    private Color color;
    private boolean visible;
    public RegularItem(int x, int y, ItemType itemType, Color color) {
        this.x = x;
        this.y = y;
        width = 25;
        height = 25;
        this.itemType = itemType;
        this.color = color;
        visible = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularItem item = (RegularItem) o;
        return x == item.x && y == item.y && width == item.width && height == item.height && itemType == item.itemType && Objects.equals(color, item.color);
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
