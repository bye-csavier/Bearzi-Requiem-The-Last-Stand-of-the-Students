package gameObjects.other;

import extra.Coords;
import extra.KeyHandler;
import extra.Utils;
import gameObjects.GameObj;
import main.MainPanel;

import java.awt.*;

public class Player extends GameObj {

    private int movSpeed;

    public Player(MainPanel mp, Coords pos, int movementSpeed)
    {
        super(mp,pos);
        this.movSpeed = movementSpeed;
        this.sprites = mp.playerSprites;
        this.sprites.setPos(this.pos.screenX,this.pos.screenY);
    }

    @Override
    public void update() {
        if(mp.input.d)
        {
            pos.worldX += movSpeed;
            hitbox.x = this.pos.worldX;
            mp.camera.shiftCamX(this.pos.worldX-this.mp.centerX);
            this.sprites.setPos(this.pos.screenX,this.pos.screenY);
        }
        if(mp.input.a)
        {
            pos.worldX -= movSpeed;
            hitbox.x = this.pos.worldX;
            mp.camera.shiftCamX(this.pos.worldX-this.mp.centerX);
            this.sprites.setPos(this.pos.screenX,this.pos.screenY);
        }
        if(mp.input.s)
        {
            pos.worldY += movSpeed;
            hitbox.y = this.pos.worldY;
            mp.camera.shiftCamY(this.pos.worldY-this.mp.centerY);
            this.sprites.setPos(this.pos.screenX,this.pos.screenY);
        }
        if(mp.input.w)
        {
            pos.worldY -= movSpeed;
            hitbox.y = this.pos.worldY;
            mp.camera.shiftCamY(this.pos.worldY-this.mp.centerY);
            this.sprites.setPos(this.pos.screenX,this.pos.screenY);
        }

    }

    @Override
    public void draw(Graphics2D g2)
    {

        this.sprites.draw(g2);

    }

    @Override
    public void isInsideScreen() {

    }

    @Override
    public void syncCamera(Graphics2D g2) {

    }
}
