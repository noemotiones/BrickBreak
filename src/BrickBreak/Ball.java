package BrickBreak;

import java.awt.*;

public class Ball extends GameObject{

    private GameHandler handler;
    public Ball(int x, int y, ID id, GameHandler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        velocityX=2;
        velocityY=2;
    }

    public void tick(){
        x+=velocityX;
        y+=velocityY;

        if(y <= 0 || y >= Game.HEIGHT - 40){
            velocityY = velocityY * -1;
        }

        if(x <= 0 || x >= Game.WIDTH - 20){
            velocityX = velocityX * -1;
        }

        checkCollision();
    }

    private void checkCollision() {
        for (int i = 0; i<handler.getGameObjects().size();i++) {
            GameObject temp = handler.getGameObjects().get(i);

            if(temp.getId()==ID.PADDLE){
                if(this.getBounds().intersects(temp.getBounds())){
                    velocityY*=-1;
                }
            }else if(temp.id==ID.BOX){
                if(this.getBounds().intersects(temp.getBounds())){
//                    velocityY*=-1;
                    if(this.y<=temp.y+5|| this.y >= temp.y + 28){
                        velocityY*=-1;
                    }else if(this.x<=temp.x+5 || this.x >=temp.x+45){
                        velocityX*=-1;
                    }
                }
            }
        }
    }



    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}
