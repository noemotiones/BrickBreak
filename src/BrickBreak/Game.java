package BrickBreak;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
    private boolean running = false;
    private GameHandler handler;

    public Game(){
        handler = new GameHandler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "BrickBreak", this);
        handler.add(new Paddle(WIDTH/2-20, HEIGHT-40, ID.PADDLE, handler));
        handler.add(new Ball(WIDTH/2-20, HEIGHT/2-20, ID.BALL, handler));
    }
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double ticks = 60.0;
        double ns = 1_000_000_000 / ticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta = delta + (now - lastTime) / ns;
            lastTime = now;


            while (delta >= 0) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                frames = 0;
            }
//            System.out.println("FPS = " + frames);
        }

        stop();
    }
    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }


        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);

        g.dispose();
        bufferStrategy.show();
    }



    private void tick(){
        handler.tick();
    }

    public static int clamp(int val, int min, int max){
        if(val >=max){
            return max;
        }else if(val <= min){
            return min;
        }else{
            return val;
        }
    }
}
