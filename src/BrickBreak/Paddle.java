package BrickBreak;


import java.awt.*;

public class Paddle extends GameObject {

    private GameHandler gameHandler;
    public Paddle(int x, int y, ID id, GameHandler gameHandler) {
        super(x, y, id, gameHandler);
        this.gameHandler = gameHandler;
    }

    @Override
    public void tick() {
        x+=velocityX;

        x = Game.clamp(x, 0, Game.WIDTH-80);
//        checkCollision();
    }

//    private void checkCollision() {
//        for (int i = 0; i<gameHandler.getGameObjects().size();i++) {
//            GameObject temp = gameHandler.getGameObjects().get(i);
//
//            if(temp.id==ID.BALL){
//                if(this.getBounds().intersects(temp.getBounds())){
//                    velocityY=velocityY*-1;
//                }
//
//            }
//        }
//    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 80, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 80, 10);
    }
}
