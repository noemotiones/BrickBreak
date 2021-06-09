package BrickBreak;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    private GameHandler handler;
    private static final int SPEED = 5;

    public KeyInput(GameHandler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        for (int i = 0; i < handler.getGameObjects().size(); i++) {
            GameObject temp = handler.getGameObjects().get(i);

            if(temp.getId()== ID.PADDLE){
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    temp.setVelocityX(SPEED * -1);
                }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    temp.setVelocityX(SPEED);
                }
            }
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getGameObjects().size(); i++) {
            GameObject temp = handler.getGameObjects().get(i);

            if(temp.getId()== ID.PADDLE){
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D || key == KeyEvent.VK_A) {
                    temp.setVelocityX(0);
                }
            }
        }

    }
}
