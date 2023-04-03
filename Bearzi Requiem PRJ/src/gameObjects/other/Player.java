package gameObjects.other;

import extra.Coords;
import extra.Utils;
import gameObjects.GameObj;
import main.MainPanel;

import java.awt.*;

public class Player extends GameObj {

    private int movSpeed;

    public Player(MainPanel mp, Coords pos, int movementSpeed)
    {
        super(mp,pos, mp.getSprites("","", "player"));
        this.movSpeed = movementSpeed;
        this.sprite.setPos(pos.screenX,pos.screenY);
    }

    @Override
    public void update() {

        if(mp.input.wasdPressed())
        {

            if(mp.input.d)
            {
//                System.out.print(Utils.nL + "------------------------------------------------------------------------------------------" + Utils.nL + "RIGHT d");
                sprite.pos.worldX += movSpeed;
                mp.cam.setCamX((-this.sprite.pos.worldX)+(this.mp.centerX));
            }
            if(mp.input.a)
            {
//                System.out.print(Utils.nL + "------------------------------------------------------------------------------------------" + Utils.nL + "LEFT a");
                sprite.pos.worldX -= movSpeed;
                mp.cam.setCamX((-this.sprite.pos.worldX)+(this.mp.centerX));
            }
            if(mp.input.s)
            {
//                System.out.print(Utils.nL + "------------------------------------------------------------------------------------------" + Utils.nL + "BOTTOM s");
                sprite.pos.worldY += movSpeed;
                mp.cam.setCamY((-this.sprite.pos.worldY)+(this.mp.centerY));
            }
            if(mp.input.w)
            {
//                System.out.print(Utils.nL + "------------------------------------------------------------------------------------------" + Utils.nL + "TOP w");
                sprite.pos.worldY -= movSpeed;
                mp.cam.setCamY((-this.sprite.pos.worldY)+(this.mp.centerY));
            }

            hitbox.x = this.sprite.pos.worldX;
            hitbox.y = this.sprite.pos.worldY;
            //this.sprite.setPos(this.pos.screenX,this.pos.screenY);
            mp.syncCamera();


//            System.out.print( Utils.nL +
//                             "CamX : " + mp.cam.x + " | CamY : " + mp.cam.y + Utils.nL +
//                             "Player Screen X : " + this.sprite.pos.screenX + " | Player Screen X : " + this.sprite.pos.screenY + Utils.nL +
//                             "Player World X : " + this.sprite.pos.worldX + " | Player World X : " + this.sprite.pos.worldY + Utils.nL +
//                             "------------------------------------------------------------------------------------------" + Utils.nL);

//            System.out.print( Utils.nL + "----- PLAYER -------------------------------------------------------------------------------------" + Utils.nL +
//                              "Player Screen X : " + this.sprite.pos.screenX + " | Player Screen X : " + this.sprite.pos.screenY + Utils.nL +
//                              "Player World X : " + this.sprite.pos.worldX + " | Player World X : " + this.sprite.pos.worldY + Utils.nL +
//                              "------------------------------------------------------------------------------------------" + Utils.nL);

        }



    }

    @Override
    public void draw(Graphics2D g2)
    {

        this.sprite.draw(g2);

    }

    @Override
    public boolean isInsideScreen() {
        return true;
    }

    @Override
    public void syncCamera() {

    }
}
