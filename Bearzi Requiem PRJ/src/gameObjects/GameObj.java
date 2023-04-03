package gameObjects;

import extra.Coords;
import gameObjects.other.Sprite;
import main.MainPanel;

import java.awt.*;

public abstract class GameObj {

    //=== VARIABLES ====================================================================================================================

    //---- General ---------------------------------------------------------------------------------------------------------------

    protected MainPanel mp;
    //public Coords pos;
    public Rectangle hitbox;

    protected String name;
    protected String desc;

    public Sprite sprite;

    boolean visible;

    //=== CONSTRUCTORS ====================================================================================================================

    public GameObj(MainPanel mp, Coords pos, Sprite sprite)
    {
        this.mp = mp;
        //this.pos = pos;
        this.sprite = sprite;
        this.sprite.setPos(pos.worldX,pos.worldY);

        this.hitbox = new Rectangle(pos.screenX, pos.screenY, this.sprite.getSize(),this.sprite.getSize());

        this.name = "unknown";
        this.desc = "???";

        this.visible = true;
    }

    public GameObj(MainPanel mp, int x, int y, Sprite sprite)
    {
        this.mp = mp;
        //this.pos = pos;
        this.sprite = sprite;
        this.sprite.setPos(x,y);

        this.hitbox = new Rectangle(this.sprite.pos.screenX, this.sprite.pos.screenY, this.sprite.getSize(),this.sprite.getSize());

        this.name = "unknown";
        this.desc = "???";

        this.visible = true;
    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Get & Set ---------------------------------------------------------------------------------------------------------------

//    public Coords getPos() {
//        return pos;
//    }

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

    public int getSize() {
        return this.sprite.size;
    }

    public Sprite getSprite() {
        return sprite;
    }

//    public void setPos(Coords pos) {
//        this.pos = pos;
//    }

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

    public void setSize(int size) {
        this.sprite.setSize(size);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }


    //---- Extra ---------------------------------------------------------------------------------------------------------------

    abstract public void update();
    abstract public void draw(Graphics2D g2);
    abstract public boolean isInsideScreen();
    abstract public void syncCamera();

}
