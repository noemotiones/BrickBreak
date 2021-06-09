package BrickBreak;


import java.awt.*;
import java.util.LinkedList;

public class GameHandler {
    public LinkedList<GameObject> getGameObjects() {
        return gameObjects;
    }

    private LinkedList<GameObject>  gameObjects = new LinkedList<>();

    public void tick(){
        for (int i = 0; i<gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            go.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i<gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            go.render(g);
        }
    }

    public void add(GameObject o){
        this.gameObjects.add(o);
    }

    public void remove(GameObject o){
        this.gameObjects.remove(o);
    }
}


