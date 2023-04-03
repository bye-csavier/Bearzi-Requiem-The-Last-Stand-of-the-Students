package gameObjects.rooms;

import extra.Utils;
import gameObjects.other.Sprite;
import jdk.jshell.execution.Util;
import main.MainPanel;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Stage {

    //=== VARIABLES ====================================================================================================================

    //---- Main ---------------------------------------------------------------------------------------------------------------

    public MainPanel mp;
    public Room[] rooms;

    public String spriteSet;

    int currentRoom = 0;

    //=== CONSTRUCTORS ====================================================================================================================

    public Stage(MainPanel mp) {

        this.mp = mp;
        this.setup();

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Setup & Save/Load ---------------------------------------------------------------------------------------------------------------

    public void setup()
    {
        this.currentRoom = 0;
        int roomsAmt = 5;

        this.rooms = new Room[roomsAmt];

        String spriteSet = "";

        switch(Utils.randInt(1,2))
        {
            default -> {
                spriteSet = "test";
            }
        }

        for(int i = 0; i < rooms.length; i++)
        {
            rooms[i] = new Room(mp);
            this.rooms[i].setup(spriteSet);

        }

        //|___ Assegnazione porte _____________________________________________________________________
        for(int i = 0; i < rooms.length; i++)
        {

            int door = this.rooms[i].randDoorChooser();
            int randRoom;

            if(roomsAmt > 1)
            {
                do {
                    randRoom = Utils.randInt(0,this.rooms.length-1);
                }while(i == randRoom || this.rooms[randRoom].doors[Room.oppositeDoor(door)] != -1);

                this.rooms[i].setDoor(door,randRoom);
                this.rooms[randRoom].setDoor(Room.oppositeDoor(door),i);

//                System.out.println(Utils.nL + "---------------------------------" +
//                                   Utils.nL + "index: " + i +
//                                   Utils.nL + "door: " + door +
//                                   Utils.nL + "randRoom: " + randRoom +
//                                   Utils.nL + "oppsiteDoor: " + Room.oppositeDoor(door) +
//                                   Utils.nL + "---------------------------------");

                roomsAmt--;
            }
            else // porta finale
            {
//                System.out.println(i);
                this.rooms[i].setDoor(door,-2);
            }

        }

        this.saveStage();
    }

    public void saveStage()
    {
        try{

            FileWriter fWriter = new FileWriter("./res/files/StageData.file");

            fWriter.append("=== INFO ===========================");
            fWriter.append(Utils.nL + "Sprite set: " + this.spriteSet);
            fWriter.append(Utils.nL + "Current room: " + this.currentRoom);
            fWriter.append(Utils.nL + "Room amt: " + this.rooms.length);
            fWriter.append(Utils.nL + Utils.nL + "=== ROOMS ===========================" + Utils.nL);

            for(int i=0; i < this.rooms.length; i++)
            {
                fWriter.append(this.rooms[i].saveRoom(i));
            }

            fWriter.close();

        //!?!
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadStage()
    {

    }

    //---- Common ---------------------------------------------------------------------------------------------------------------

    public void update()
    {
        this.rooms[currentRoom].update();
    }

    public void draw(Graphics2D g2)
    {
        rooms[0].draw(g2);
    }

    public void syncCamera()
    {
        this.rooms[currentRoom].syncCamera();
    }


//!?!
}
