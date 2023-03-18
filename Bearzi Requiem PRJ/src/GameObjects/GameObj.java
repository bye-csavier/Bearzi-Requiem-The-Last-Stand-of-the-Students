package gameObjects;

import extra.Coords;
import gameObjects.other.Sprite;
import main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObj {

    //=== VARIABLES ====================================================================================================================

    //---- General ---------------------------------------------------------------------------------------------------------------

    protected MainPanel mp;
    public Coords pos;
    public Rectangle hitbox;

    protected String name;
    protected String desc;

    protected Sprite sprites;

    boolean visible;

    //=== CONSTRUCTORS ====================================================================================================================

    public GameObj(MainPanel mp, Coords pos)
    {
        this.mp = mp;
        this.pos = pos;

        this.hitbox = new Rectangle(pos.screenX, pos.screenY, mp.tileSize, mp.tileSize);

        this.name = "unknown";
        this.desc = "???";

        this.visible = true;
    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Get & Set ---------------------------------------------------------------------------------------------------------------

    public Coords getPos() {
        return pos;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setPos(Coords pos) {
        this.pos = pos;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    //---- Extra ---------------------------------------------------------------------------------------------------------------

    abstract public void update();
    abstract public void draw(Graphics2D g2);
    abstract public void isInsideScreen();
    abstract public void syncCamera(Graphics2D g2);

}
