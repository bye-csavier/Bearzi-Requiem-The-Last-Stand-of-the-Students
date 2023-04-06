package gameObjects.rooms;

import extra.Coords;
import extra.Utils;
import gameObjects.other.Sprite;
import gameObjects.rooms.npcs.Spider;
import main.MainPanel;
import main.Settings;

import java.awt.*;

public class Room {

    //=== VARIABLES ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

    MainPanel mp;

    //---- Room Var ---------------------------------------------------------------------------------------------------------------

    //! -----------------
    private NPC[] npcs;
    //! -----------------

    // public NPC[] npcs;
    public int roomWidth;
    public int roomHeight;

    private String spriteSet;

    public int[][] collisionMap; //? Collisioni generale
    public Sprite[][] groundMap; //? Pavimento della stanza
    public Sprite[][] layoutMap; //? Sprite di muri e oggetti da stampare

    public int[] doors;
    public final static int topDoor = 0;
    public final static int rightDoor = 1;
    public final static int bottomDoor = 2;
    public final static int leftDoor = 3;

    /*
         0
        ----
      3 |  | 1
        ----
          2
    */

    //private Sprite[][] wallMap;
    //private Sprite[][] objectMap;


    private int edgeCheck = 0;

    //=== CONTRUCTORS ====================================================================================================================

    public Room(MainPanel mp)
    {
        this.mp = mp;

        //! -----------------
        this.npcs = new NPC[2];
        this.npcs[0] = new Spider(mp, 200,200);
        //this.npcs[0].sprite.flipX = true;

        //! -----------------

        this.doors = new int[4];

        for(int i = 0; i < this.doors.length; i++)
        {
            this.doors[i] = -1;
        }

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

    public void update()
    {
        for(int i=0; i<this.npcs.length; i++)
        {
            if(this.npcs[i] != null)
            {
                if(this.npcs[i].goToLastTime <= 0) {
                    this.npcs[i].followPlayer(mp.game.player.sprite.pos,this.collisionMap);
                }

                this.npcs[i].update();
            }

        }
    }

    private int edgeCkMult = 1;

    public void draw(Graphics2D g2)
    {
        for(int y = 0; y < roomHeight; y++)
        {
            for(int x = 0; x < roomWidth; x++)
            {
                if(collisionMap[x][y] != 1)
                {
                    groundMap[x][y].draw(g2);
                }

                if(collisionMap[x][y] != 0 )
                {
                    layoutMap[x][y].draw(g2);
                }

            }
        }

        for(int i=0; i<this.npcs.length; i++)
        {
            if(this.npcs[i] != null)
            {
                this.npcs[i].draw(g2);
            }

        }

    }

    public void syncCamera()
    {
        //System.out.print(Utils.nL + "CHECK" + Utils.nL + layoutMap[0][0].pos.toString() + Utils.nL);

        for(int y = 0; y < roomHeight; y++)
        {
            for(int x = 0; x < roomWidth; x++)
            {
                groundMap[x][y].pos.setScreenCoord( groundMap[x][y].pos.worldX+mp.cam.x, groundMap[x][y].pos.worldY+mp.cam.y );
                layoutMap[x][y].pos.setScreenCoord( groundMap[x][y].pos.worldX+mp.cam.x, groundMap[x][y].pos.worldY+mp.cam.y );
            }
        }

        //this.spiderA.syncCamera();
        for(int i=0; i<this.npcs.length; i++)
        {
            if(this.npcs[i] != null)
            {
                this.npcs[i].syncCamera();
            }

        }

//        System.out.print( Utils.nL + "----- Spider -------------------------------------------------------------------------------------" + Utils.nL +
//                          "Spider Screen X : " + this.spider.sprite.pos.screenX + " | Spider Screen X : " + this.spider.sprite.pos.screenY + Utils.nL +
//                          "Spider World X : " + this.spider.sprite.pos.worldX + " | Spider World X : " + this.spider.sprite.pos.worldY + Utils.nL +
//                          "------------------------------------------------------------------------------------------" + Utils.nL);

        //this.spider.goTo(mp.game.player.sprite.pos, (long) Utils.convertTime(0.75,"s","ns"));
    }

    //---- Room func ---------------------------------------------------------------------------------------------------------------

    public void setup(String spriteSet)
    {
        int x, y; //? Coordinate per navigare sulla matrice

        this.roomWidth = Utils.randInt(15,25);
        this.roomHeight = Utils.randInt(10,15);
        this.spriteSet = spriteSet;

        int tempInt = 0;

        this.collisionMap = new int[roomWidth][roomHeight];
        this.groundMap = new Sprite[roomWidth][roomHeight];
        this.layoutMap = new Sprite[roomWidth][roomHeight];

        //|___ Collisioni ____________________________________________________________________________________________________________

        for(y = 1; y < roomHeight-1; y++)
        {
            for(x = 1; x < roomWidth-1; x++)
            {
                collisionMap[x][y] = 0;
            }
        }

        //? Creazione muri del perimetro

        for(int k = 0; k < roomWidth; k++)
        {
            collisionMap[k][0] = 1;
            collisionMap[k][roomHeight-1] = 1;
        }

        for(int k = 0; k < roomHeight; k++)
        {
            collisionMap[0][k] = 1;
            collisionMap[roomWidth-1][k] = 1;
        }

        //? Creazione collisioni interne

        int collisionAmount = Utils.percentage(roomHeight + roomWidth, Settings.wallsAmtPerc); //? Numero di collisioni nella stanza
        int collisionLenght; //? Lunghezza minima e massima di ogni collisione, vai a riga 95 per cambiare i valori

        for(int j = collisionAmount; j > 0; j--)
        {
            do
            {
                x = Utils.randInt(2, roomWidth-3);
                y = Utils.randInt(2, roomHeight-3);
            }
            while(collisionMap[x][y] > 0);

            collisionLenght = Utils.randInt(Utils.percentage(collisionAmount + (roomHeight + roomWidth), Settings.wallsMinLengthPerc), Utils.percentage(collisionAmount + (roomHeight + roomWidth), Settings.wallsMaxLengthPerc)); //? Valore minimo e massimo per la lunghezza delle collisioni

            //System.out.println("n: " + j + "   l: " + collisionLenght + "   pos: " + x + ", " + y);

            for(int k = collisionLenght; k > 0; k--)
            {
                int chosenDirection = Utils.randInt(0, 3);

                //System.out.println("Entrato " + n + " Coords: " + x + ", " + y);

                switch(chosenDirection)
                {
                    case 0:{
                        if(y-1 > 1 && collisionMap[x][y-1] < 1)
                        {
                            collisionMap[x][y-1] = 1;
                            y--;
                        }
                        else
                        {
                            k++;
                        }

                        break;
                    }

                    case 1:{
                        if(x+1 < roomWidth-2 && collisionMap[x+1][y] < 1)
                        {
                            collisionMap[x+1][y] = 1;
                            x++;
                        }
                        else
                        {
                            k++;
                        }

                        break;
                    }

                    case 2:{
                        if(y+1 < roomHeight-2 && collisionMap[x][y+1] < 1)
                        {
                            collisionMap[x][y+1] = 1;
                            y++;
                        }
                        else
                        {
                            k++;
                        }

                        break;
                    }

                    case 3:{
                        if(x-1 > 1 && collisionMap[x-1][y] < 1)
                        {
                            collisionMap[x-1][y] = 1;
                            x--;
                        }
                        else
                        {
                            k++;
                        }

                        break;
                    }
                }
            }
        }

        //? Creazione oggetti

        int objectsAmount = 5; //? Numero degli oggetti nella stanza

        for(int j = objectsAmount; j > 0; j--)
        {
            do
            {
                x = Utils.randInt(2, roomWidth-3);
                y = Utils.randInt(2, roomHeight-3);
            }
            while(collisionMap[x][y] > 0);

            collisionMap[x][y] = 2;
        }

        //? Stampa collisionMap su console

//        System.out.println();
//        for(y = 0; y < roomHeight; y++)
//        {
//            for(x = 0; x < roomWidth; x++)
//            {
//                System.out.print(collisionMap[x][y]);
//            }
//            System.out.println();
//        }


        //|___ Ground ____________________________________________________________________________________________________________

        for(y = 0; y < roomHeight; y++)
        {
            for(x = 0; x < roomWidth; x++)
            {
                this.groundMap[x][y] = mp.getSprites(spriteSet,"ground","");
                tempInt = Utils.randInt(0,this.groundMap[x][y].getSpritesAmtX()-1); //? Prende una variante casual tra quelle esistenti in questa spritesheet
                this.groundMap[x][y].setXSpriteIndex(tempInt);

                groundMap[x][y].setPos(x * groundMap[x][y].size, y * groundMap[x][y].size);

                //System.out.print("Ciclo Ground " + x+"|"+y + Utils.nL + groundMap[x][y].pos.toString() + Utils.nL +  Utils.nL);

            }
        }

        //|___ Wall ____________________________________________________________________________________________________________



        for(int k = 0; k < roomWidth; k++)
        {
            this.collisionMap[k][0] = 1;
            this.layoutMap[k][0] = mp.getSprites(spriteSet,"wall","");
            this.layoutMap[k][0].setXSpriteIndex(0);

            this.collisionMap[k][roomHeight-1] = 1;
            this.layoutMap[k][roomHeight-1] = mp.getSprites(spriteSet,"wall","");
            this.layoutMap[k][roomHeight-1].setXSpriteIndex(0);

        }

        for(int k = 0; k < roomHeight; k++)
        {
            this.collisionMap[0][k] = 1;
            this.layoutMap[0][k] = mp.getSprites(spriteSet,"wall","");
            this.layoutMap[0][k].setXSpriteIndex(1);

            this.collisionMap[roomWidth-1][k] = 1;
            this.layoutMap[roomWidth-1][k] = mp.getSprites(spriteSet,"wall","");
            this.layoutMap[roomWidth-1][k].setXSpriteIndex(1);

        }

        for(y = 0; y < roomHeight; y++)
        {

            int check = 0;

            for(x = 0; x < roomWidth; x++)
            {

                if(this.collisionMap[x][y] == 1)
                {

                    if(y < roomHeight-1)
                    {
                        check = 1;
                    }

                    //if( (this.collisionMap[x][y+bottomCheck] == 1 || this.collisionMap[x][y-topCheck] == 1) && (this.collisionMap[x+rightCheck][y] != 1 && this.collisionMap[x-leftCheck][y] != 1))
                    if( (this.collisionMap[x][y+check] == check))
                    {
                        this.layoutMap[x][y] = mp.getSprites(spriteSet,"wall","");
                        this.layoutMap[x][y].setXSpriteIndex(1);
                    }
                    else
                    {
                        this.layoutMap[x][y] = mp.getSprites(spriteSet,"wall","");
                        this.layoutMap[x][y].setXSpriteIndex(0);
                    }

                    layoutMap[x][y].setPos(x * layoutMap[x][y].size,x * layoutMap[x][y].size);
                    //System.out.print(Utils.nL + "| X: " + x * groundMap[x][y].size + " / Y: " + y * groundMap[x][y].size + Utils.nL);

                }
                else
                {
                    this.layoutMap[x][y] = mp.getSprites("","","blank");

                    layoutMap[x][y].setPos(-10,-10);

                }

                //System.out.print("Ciclo Wall " + x+"|"+y + Utils.nL + groundMap[x][y].pos.toString() + Utils.nL + Utils.nL);

            }
        }

        edgeCheck = groundMap[0][0].size;

    //?end
    }

    //---- Save & Load ---------------------------------------------------------------------------------------------------------------

    public String saveRoom(int i)
    {
        String str = "";

        str += Utils.nL + "--- ROOM " + i + " ---";
        str += Utils.nL + "Room width: " + this.roomWidth;
        str += Utils.nL + "Room height: " + this.roomHeight;
        str += Utils.nL + "Doors: " + this.doors[0] + "," + this.doors[1] + "," + this.doors[2] + "," + this.doors[3] ;

        str += Utils.nL + Utils.nL + "|COLLISION|" + Utils.nL;

        for(int y=0; y < this.roomHeight; y++)
        {
            for(int x=0; x < this.roomWidth; x++)
            {
                str += this.collisionMap[x][y] + " ";
            }

            str += Utils.nL;
        }

        return str;
    }

    public void loadRoom()
    {

    }

    //---- Door func ---------------------------------------------------------------------------------------------------------------

    public int randDoorChooser()
    {
        int rand = Utils.randInt(0,3);
        int i = 0;

        while(this.doors[rand] != -1)
        {
            rand = Utils.randInt(0,3);

            if(i > 4)
            {
                return -1;
            }

            i++;
        }

        return rand;
    }

    public void setDoor(int door, int roomIndex)
    {
        if(door != -1)
        {
            if(this.doors[door] == -1)
            {
                this.doors[door] = roomIndex;
            }
        }
    }

    public static int oppositeDoor(int door)
    {
        return ((door+2)%4);
    }

    //---- Extra ---------------------------------------------------------------------------------------------------------------

    public static int xRelativeToTilemap(int x)
    {
        return (x/Settings.basicTileSize);
    }
    public static int yRelativeToTilemap(int y)
    {
        return (y/Settings.basicTileSize);
    }
    public static int[] indexRelativeToTilemap(int x, int y)
    {
        return new int[]{(x / Settings.basicTileSize), (y / Settings.basicTileSize)};
    }

    public static int xRelativeToTilemap(Coords pos)
    {
        return (pos.worldX/Settings.basicTileSize);
    }
    public static int yRelativeToTilemap(Coords pos)
    {
        return (pos.worldY/Settings.basicTileSize);
    }
    public static int[] indexRelativeToTilemap(Coords pos)
    {
        return new int[]{(pos.worldX/Settings.basicTileSize), (pos.worldY/Settings.basicTileSize)};
    }


    public static int xRelativeToRealmap(int x)
    {
        return (x*Settings.basicTileSize);
    }
    public static int yRelativeToRealmap(int y)
    {
        return (y*Settings.basicTileSize);
    }


}
