package gameObjects.rooms.npcs;

import extra.Utils;
import gameObjects.other.Sprite;
import gameObjects.rooms.NPC;
import main.MainPanel;

public class Spider extends NPC {

    public Spider(MainPanel mp, int x, int y) {

        super(mp, mp.getSpritesByName("spider"), x, y, NPC.NpcType.SPIDER);

        this.movSpeed = 300; // pixels x seconds (px/s)

        this.idleAniSpeed = 250; //ms
        this.idleAniStart = 0; //the y position of the first frame
        this.idleAniEnd = 5; //the y position of the last frame

        this.movingAniSpeed = 100; //ms
        this.movingAniStart = 0; //the y position of the first frame
        this.movingAniEnd = 7; //the y position of the last frame

        this.idleAni();
    }

}
