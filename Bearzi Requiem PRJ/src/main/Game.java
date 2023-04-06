package main;

import extra.Coords;
import extra.Utils;
import gameObjects.GameObj;
import gameObjects.other.Player;
import gameObjects.rooms.Stage;

import java.awt.*;

public class Game {

    MainPanel mp;
    public Player player;
    public Stage stage;

    public Game(MainPanel mp)
    {
        this.mp = mp;

        this.player = new Player(mp, new Coords( (mp.centerX - (Settings.playerSize/2)) ,(mp.centerY - (Settings.playerSize/2)) ), mp.getVMIN(1) );
        this.player.sprite.pos.setWorldCoord(200,200);

        stage = new Stage(mp);

    }

    public void update()
    {
        stage.update();
        player.update();
        //! update bullet

    }

    public void draw(Graphics2D g2)
    {
        stage.draw(g2);
        player.draw(g2);
    }

    public void syncCamera()
    {
        this.stage.syncCamera();
    }
}
