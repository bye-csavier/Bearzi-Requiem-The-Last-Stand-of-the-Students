package main;

import extra.Coords;
import gameObjects.GameObj;
import gameObjects.other.Player;

import java.awt.*;

public class Game {

    MainPanel mp;
    Player player;

    public Game(MainPanel mp)
    {
        this.mp = mp;

        this.player = new Player(mp, new Coords( (mp.centerX - (mp.tileSize/2)) ,(mp.centerY - (mp.tileSize/2)) ), mp.getVMIN(1) );

    }

    public void update()
    {
        player.update();
    }

    public void draw(Graphics2D g2)
    {
        player.draw(g2);

    }
}
