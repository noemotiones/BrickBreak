package BrickBreak;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;

    protected ID id;

    protected int velocityX, velocityY;

    public GameObject(int x, int y, ID id, GameHandler gameHandler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.velocityX = 0;
        this.velocityY = 0;
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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void tick() {
    }

    public void render(Graphics g) {
    }

    public abstract Rectangle getBounds();
}
