package gameObjects.rooms;

import extra.Coords;
import extra.Utils;
import gameObjects.GameObj;
import gameObjects.other.Sprite;
import main.MainPanel;
import main.Settings;

import java.awt.*;

public class NPC extends GameObj {

    //=== VARIABLES ====================================================================================================================

    //---- Settings ---------------------------------------------------------------------------------------------------------------

    protected int movSpeed = 0;

    protected int idleAniSpeed = 0;
    protected int idleAniStart = 0;
    protected int idleAniEnd = 0;

    protected int movingAniSpeed = 0;
    protected int movingAniStart = 0;
    protected int movingAniEnd = 0;



    //---- NPC Info ---------------------------------------------------------------------------------------------------------------

    public enum NpcType{
        SPIDER;

        public String toString()
        {
            switch(this)
            {

                case SPIDER -> {
                    return "spider";
                }

                default -> {
                    return "?";
                }
            }
        }
    }

    //---- Movement ---------------------------------------------------------------------------------------------------------------

    double goToLastTime = 0;
    private double goToMovSpeedX;
    private double goToMovSpeedY;
    private int goToUpdateAmt;
    private int goToUpdateCounter;
    private double goToX;
    private double goToY;
    private Coords goToEndPoint;

    private int[][] nodeList;
    private int nextNode = 0;

//    private Coords playerPos;
//    private int[][] collisionMap;

    //=== CONSTRUCTORS ====================================================================================================================

    public NPC(MainPanel mp, Sprite sprite, int x, int y, NpcType type)
    {
        super(mp,new Coords(x,y),sprite);
        this.setup(type);
    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Animation Functions ---------------------------------------------------------------------------------------------------------------

    protected void idleAni()
    {
        this.sprite.setXSpriteIndex(0);

        this.sprite.setAnimationSpeed(this.idleAniSpeed);
        this.sprite.setAniStartIndex(this.idleAniStart);
        this.sprite.setAniEndIndex(this.idleAniEnd);

        this.sprite.start();
        this.sprite.loop();
    }

    protected void movingAni()
    {
        this.sprite.setXSpriteIndex(1);

        this.sprite.setAnimationSpeed(this.movingAniSpeed);
        this.sprite.setAniStartIndex(this.movingAniStart);
        this.sprite.setAniEndIndex(this.movingAniEnd);

        this.sprite.start();
        this.sprite.loop();
    }

    //---- Setup & Control ---------------------------------------------------------------------------------------------------------------

    public void followPlayer(Coords playerCoords,int[][] collisionMap)
    {
        if(this.nodeList == null || this.nextNode <= 0)
        {
            this.nodeList = PathFinding.convertNodi(PathFinding.start(collisionMap, Room.xRelativeToTilemap(this.sprite.pos), Room.yRelativeToTilemap(this.sprite.pos), Room.xRelativeToTilemap(playerCoords), Room.yRelativeToTilemap(playerCoords)));
            this.nextNode = 0;
//            if(this.nodeList != null)
//            {
//                System.out.print(Utils.nL + Utils.nL + "------------------------------------------------- | " + nodeList[0].length + Utils.nL);
//
//                for(int y=0; y<collisionMap[0].length; y++)
//                {
//                    for(int x=0; x<collisionMap.length; x++)
//                    {
//                        System.out.print(collisionMap[x][y] + " ");
//                    }
//                    System.out.println();
//                }
//
//            }

        }

        if(this.nodeList != null && this.nextNode < nodeList[0].length)
        {
            System.out.print(Utils.nL + Utils.nL + "map X= " + this.nodeList[0][this.nextNode] + " | map Y= " + this.nodeList[1][this.nextNode] +
                             Utils.nL + "X= " + Room.xRelativeToRealmap(this.nodeList[0][nextNode]) + " | Y= " + Room.yRelativeToRealmap(this.nodeList[1][nextNode]));

            goToSpeed(new Coords(Room.xRelativeToRealmap(this.nodeList[0][nextNode]),Room.yRelativeToRealmap(this.nodeList[1][nextNode])));
            this.nextNode++;
        }
        else if(nextNode != 0)
        {
            this.nextNode = 0;
        }

    }

    public void setup(NpcType type)
    {

        switch(type)
        {
            case SPIDER -> {
                this.sprite.setAnimationSpeed(0.10,"s");
            }

            default -> {
                this.sprite.setAnimationSpeed(0.08,"s");
            }
        }
    }

    public void goToSpeed(Coords endPoint)
    {

        /*
        ? Speed = pixel al secondo
        ? (Coords.distanceBtwn(this.sprite.pos,endPoint)/speed) = calcola la distanza tra la pos di npc all'endPoint e la divide per la velocita
        ? infine trasforma il tempo in secondi e chiama goTo()
        */

        long time = (long) Utils.convertTime((Coords.distanceBtwn(this.sprite.pos,endPoint)/this.movSpeed),"s","ns");

        this.goTo(endPoint,time);
    }

    public void goToSpeed(Coords endPoint, int speed)
    {

        /*
        ? Speed = pixel al secondo
        ? (Coords.distanceBtwn(this.sprite.pos,endPoint)/speed) = calcola la distanza tra la pos di npc all'endPoint e la divide per la velocita
        ? infine trasforma il tempo in secondi e chiama goTo()
        */

        long time = (long) Utils.convertTime((Coords.distanceBtwn(this.sprite.pos,endPoint)/speed),"s","ns");

//        System.out.print(Utils.nL + "---------------------------------------------" +
//                         Utils.nL + "Distance: " + Coords.distanceBtwn(this.sprite.pos,endPoint) +
//                         Utils.nL + "Speed: " + speed +
//                         Utils.nL + "Time: " + time +
//                         Utils.nL + "TIME S: " + (Coords.distanceBtwn(this.sprite.pos,endPoint)/speed) +
//                         Utils.nL + "---------------------------------------------" + Utils.nL);

        this.goTo(endPoint,time);
    }

    public void goTo(Coords endPoint, long time)
    {
//        System.out.print(Utils.nL + "---------------------------------------------" +
//                Utils.nL + "Inside: " + time +
//                Utils.nL + "---------------------------------------------" + Utils.nL);

        this.goToEndPoint = endPoint;
        this.goToLastTime = System.nanoTime();

        this.goToUpdateAmt = (int) (time / Settings.goToUpdateInterval);

//        System.out.println( Utils.nL + Utils.nL + "!!TIME!!: " + time +
//                Utils.nL + "!!INTERVAL!!: " + Settings.goToUpdateInterval);

        this.goToMovSpeedX = (Coords.distanceBtwn(this.sprite.pos.worldX,0,endPoint.worldX,0)/this.goToUpdateAmt);
        this.goToMovSpeedX = Utils.truncate(this.goToMovSpeedX,4);
        this.goToMovSpeedY = (Coords.distanceBtwn(0,this.sprite.pos.worldY,0,endPoint.worldY)/this.goToUpdateAmt);
        this.goToMovSpeedY = Utils.truncate(this.goToMovSpeedY,4);


//        System.out.println( Utils.nL + Utils.nL + "!!x dist!!: " + Coords.distanceBtwn(this.sprite.pos.worldX,0,endPoint.worldX,0) +
//                Utils.nL + "!!each x!!: " + this.goToMovSpeedX);

        if(this.sprite.pos.worldX > endPoint.worldX)
        {
            this.goToMovSpeedX = - this.goToMovSpeedX;
            this.sprite.flipX = true;
        }
        else { this.sprite.flipX = false; }

        if(this.sprite.pos.worldY > endPoint.worldY)
        {
            this.goToMovSpeedY = - this.goToMovSpeedY;
        }

        this.goToUpdateCounter = 0;

        this.goToX = this.sprite.pos.worldX;
        this.goToY = this.sprite.pos.worldY;

        this.movingAni();
    }

    private void goToUpdate()
    {

        if( (System.nanoTime()-this.goToLastTime) >= Settings.goToUpdateInterval)
        {
            if(this.goToUpdateCounter >= this.goToUpdateAmt)
            {
                this.sprite.setWorldPos(this.goToEndPoint.worldX,this.goToEndPoint.worldY);
                this.goToLastTime = 0;
                this.idleAni();
                return;
            }

//            System.out.println( Utils.nL + Utils.nL + "|time|: " + System.nanoTime() +
//                                Utils.nL + "!!last!!: " + (System.nanoTime()-this.goToLastTime) +
//                                Utils.nL + "!!interval!!: " + Settings.goToUpdateInterval);

            this.goToLastTime = System.nanoTime();

            this.goToUpdateCounter++;

            this.goToX += this.goToMovSpeedX;
            this.goToY += this.goToMovSpeedY;

            this.sprite.setWorldPos((int)goToX,(int)goToY);


            this.syncCamera();

//            System.out.println( Utils.nL + Utils.nL + "Update counter: " + goToUpdateCounter +
//                                Utils.nL + "Update Amt: " + goToUpdateAmt);
////
//            System.out.println( "-------------------------------------------" +
//                                Utils.nL + "! tempX !: " + goToX +
//                                Utils.nL + "! tempY !: " + goToY +
//                                Utils.nL + "! X !: " + this.sprite.pos.worldX +
//                                Utils.nL + "! Y !: " + this.sprite.pos.worldY );
        }

    }

    //---- Common ---------------------------------------------------------------------------------------------------------------

    @Override
    public void update() {

        if(this.goToLastTime > 0)
        {
            this.goToUpdate();
        }

    }

    @Override
    public void draw(Graphics2D g2) {
        this.sprite.draw(g2);
    }

    @Override
    public boolean isInsideScreen() {
        return true;
    }

    @Override
    public void syncCamera() {
        this.sprite.pos.setScreenCoord(this.sprite.pos.worldX+mp.cam.x,this.sprite.pos.worldY+mp.cam.y);
    }

}
