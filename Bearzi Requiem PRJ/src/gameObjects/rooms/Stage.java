package gameObjects.rooms;

import extra.Utils;
import gameObjects.other.Sprite;
import main.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Stage {

    //=== VARIABLES ====================================================================================================================

    //---- Main ---------------------------------------------------------------------------------------------------------------

    public MainPanel mp;
    public Room[] rooms;

    //=== CONSTRUCTORS ====================================================================================================================

    public Stage(MainPanel mp) {

        this.setup();

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Setup ---------------------------------------------------------------------------------------------------------------

    public void setup()
    {
        int roomsAmt = Utils.randInt(5,8);

        this.rooms = new Room[roomsAmt];

        for(int i = 0; i < rooms.length; i++)
        {

        }

    }

    //---- Common ---------------------------------------------------------------------------------------------------------------

    public void update()
    {

    }

    public void draw(Graphics2D g2)
    {

    }

    public void syncCamera()
    {

    }


//!?!
}
