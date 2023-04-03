package main;

import extra.Utils;

public class Settings {

    //=== Sprite ==============================================================================================================================

    public final static int basicTileSize = 144;

    public final static int playerSize = Utils.percentage(basicTileSize,50);
    public final static int spiderSize = Utils.percentage(basicTileSize,100);

    //=== Logic ==============================================================================================================================

        //| Entities
    public final static int playerVel = 5;

        //| Rooms
    public final static int wallsAmtPerc = 30; //? Percentuale di muri interni in una stanza
    public final static int wallsMinLengthPerc = 6; //? Percentuale minima della lunghezza dei muri
    public final static int wallsMaxLengthPerc = 8; //? Percentuale massima della lunghezza dei muri

        //| Go to
    public final static long goToUpdateInterval = (long) Utils.convertTime(10,"ms","ns");


}
