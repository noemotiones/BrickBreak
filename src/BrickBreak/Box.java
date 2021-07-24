package BrickBreak;

import java.awt.*;

public class Box extends GameObject{

    public int DAMAGE = 0;
    private GameHandler handler;
    private Color colour = Color.GREEN;

    public Box(int x, int y, ID id, GameHandler handler){
        super(x, y, id, handler);
        this.handler = handler;
    }

    public void tick(){
        if(DAMAGE == 1){
            colour = Color.YELLOW;
        }else if(DAMAGE == 2){
            colour = Color.ORANGE;
        }else if(DAMAGE == 3){
            colour = Color.RED;
        }
        checkCollision();
    }

    private void checkCollision() {
        for (int i = 0; i<handler.getGameObjects().size();i++) {
            GameObject temp = handler.getGameObjects().get(i);

            if(temp.id==ID.BALL){
                if(this.getBounds().intersects(temp.getBounds())){
                    DAMAGE++;
                }
            }
        }
    }

    public void render(Graphics g){


//        g.setColor(Color.gray);
//        g.fillRect(x, y, 50, 32);


        g.setColor(colour);
        g.fillRect(x, y, 50, 32);
//        if(HEALTH>=67) {
//            g.setColor(Color.GREEN);
//            g.fillRect(15, 15, HEALTH * 2, 32);
//        }
//
//        if(HEALTH>=34 &&HEALTH<=68) {
//            g.setColor(Color.YELLOW);
//            g.fillRect(15, 15, HEALTH * 2, 32);
//        }
//
//        if(HEALTH<=33) {
//            g.setColor(Color.RED);
//            g.fillRect(15, 15, HEALTH * 2, 32);
//        }

        g.setColor(Color.WHITE);
        g.drawRect(x,y,50,32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 32);
    }
}



