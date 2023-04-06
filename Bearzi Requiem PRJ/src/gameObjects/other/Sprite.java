package gameObjects.other;

import extra.Coords;
import extra.Utils;
import main.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite implements Cloneable{

    //=== VARIABLES ====================================================================================================================

    //---- Main ---------------------------------------------------------------------------------------------------------------

    public MainPanel mp;
    public Coords pos;
    public int size;
    private int tileSize;
    private int edgeChecker;

    private int centerX;
    private int centerY;

    protected BufferedImage sprite;
    private BufferedImage img;

    public boolean flipX;
    public boolean flipY;
    public double rotation = 0;

    private int xSpriteIndex;
    private int ySpriteIndex;
    private int spritesAmtX;
    private int spritesAmtY;

    //---- Sprite Animation ---------------------------------------------------------------------------------------------------------------

    private double lastAnimationTime = 0;

    private long animationSpeed = (long) extra.Utils.convertTime(0.08, "s", "ns");

    private int aniStartIndex;

    private int aniEndIndex;

    private boolean animate;
    private boolean loop;

    //=== CONSTRUCTORS ====================================================================================================================

    public Sprite(MainPanel mp, BufferedImage sprites, int size, int tilesize, int xSpriteIndex, int ySpriteIndex, long animationSpeed)
    {
        this.mp = mp;
        this.sprite = sprites;
        this.size = size;
        this.edgeChecker = this.size*2;
        this.tileSize = tilesize;
        this.spritesAmtX = (this.sprite.getWidth() / this.tileSize);
        this.spritesAmtY = (this.sprite.getHeight() / this.tileSize);
        this.xSpriteIndex = xSpriteIndex % spritesAmtX;
        this.ySpriteIndex = ySpriteIndex % spritesAmtY;
        this.pos = new Coords();

        this.img = this.sprite.getSubimage(this.tileSize * this.xSpriteIndex, this.tileSize * this.ySpriteIndex, this.tileSize, this.tileSize );

        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmtY;

        if(animationSpeed >= 0)
        {
            this.animationSpeed = (long) Utils.convertTime(animationSpeed,"ms","ns");
        }

        this.animate = false;
        this.loop = false;

        this.centerX = this.size/2;
        this.centerY = this.size/2;

    }

    public Sprite(MainPanel mp, String sprites, int size, int tilesize, int xSpriteIndex, int ySpriteIndex, long animationSpeed)
    {
        this.mp = mp;

        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(sprites));
        }catch(IOException e) {
            e.printStackTrace();
        }

        this.size = size;
        this.edgeChecker = this.size*2;
        this.tileSize = tilesize;
        this.spritesAmtX = (this.sprite.getWidth() / this.tileSize);
        this.spritesAmtY = (this.sprite.getHeight() / this.tileSize);
        this.xSpriteIndex = xSpriteIndex % spritesAmtX;
        this.ySpriteIndex = ySpriteIndex % spritesAmtY;
        this.pos = new Coords(0,0);

        this.img = this.sprite.getSubimage(this.tileSize * this.xSpriteIndex, this.tileSize * this.ySpriteIndex, this.tileSize, this.tileSize );


        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmtY;

        if(animationSpeed >= 0)
        {
            this.animationSpeed = (long) Utils.convertTime(animationSpeed,"ms","ns");
        }

        this.animate = false;
        this.loop = false;

        this.centerX = this.size/2;
        this.centerY = this.size/2;

    }

    public Sprite(MainPanel mp, String sprites, int size) //? SERVE SOLO ALLA SPRITE BLANK
    {
        this.mp = mp;

        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(sprites));
        }catch(IOException e) {
            e.printStackTrace();
        }

        this.size = size;
        this.edgeChecker = this.size*2;
        this.tileSize = 0;
        this.spritesAmtX = 1;
        this.spritesAmtY = 1;
        this.xSpriteIndex = 0;
        this.ySpriteIndex = 0;
        this.pos = new Coords();

        this.img = this.sprite.getSubimage(0, 0, 1, 1 );


        this.aniStartIndex = 0;
        this.aniEndIndex = 1;

        this.animationSpeed = 0;


        this.animate = false;
        this.loop = false;

        this.centerX = this.size/2;
        this.centerY = this.size/2;

    }

    public Sprite(MainPanel mp, BufferedImage sprites, int size) //? SERVE SOLO ALLA SPRITE BLANK
    {
        this.mp = mp;

        this.sprite = sprites;


        this.size = size;
        this.edgeChecker = this.size*2;
        this.tileSize = 0;
        this.spritesAmtX = 1;
        this.spritesAmtY = 1;
        this.xSpriteIndex = 0;
        this.ySpriteIndex = 0;
        this.pos = new Coords();

        this.img = this.sprite.getSubimage(0, 0, 1, 1 );


        this.aniStartIndex = 0;
        this.aniEndIndex = 1;

        this.animationSpeed = 0;


        this.animate = false;
        this.loop = false;

        this.centerX = this.size/2;
        this.centerY = this.size/2;

    }

    //=== FUNCTIONS ====================================================================================================================

//    public static BufferedImage rotateImg(BufferedImage img, int angle) //? https://humanoid-readable.claude-martin.ch/2022/04/12/rotate-bufferedimage/ [ modificata ]
//    {
//        if (angle < 0) { //? converte l'angolo in valori utilizzabili ( <0 case )
//            angle = 360 + (angle % 360);
//        }
//        if ((angle %= 360) == 0) {
//            return img;
//        }
//        final boolean r180 = angle == 180; //? Controlla se l'angolo è uguale a 180
//
////        if (angle != 90 && !r180 && angle != 270) //? devo ancora capirlo
////            throw new IllegalArgumentException("Invalid angle.");
//
//        double rads = Math.toRadians(angle);
//        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
//
//        int w = (int) Math.floor(img.getWidth() * cos + img.getHeight() * sin);
//        int h = (int) Math.floor(img.getHeight() * cos + img.getWidth() * sin);
//
//        final int type = img.getType() == BufferedImage.TYPE_CUSTOM ? BufferedImage.TYPE_INT_ARGB : img.getType();
//        final BufferedImage rotated = new BufferedImage(w, h, type);
//        final Graphics2D graphic = rotated.createGraphics();
//        graphic.rotate(Math.toRadians(angle), w / 2d, h / 2d);
//        final int offset = r180 ? 0 : (w - h) / 2;
//        graphic.drawImage(img, null, offset, -offset);
//        graphic.dispose();
//        return rotated;
//    }

    //---- Set & Get ---------------------------------------------------------------------------------------------------------------

    public BufferedImage getSprite()
    {
        return this.img;
    }

    public BufferedImage getRootSprite()
    {
        return this.sprite;
    }

    public int getSpritesAmtX() {
        return spritesAmtX;
    }

    public int getSpritesAmtY() {
        return spritesAmtY;
    }

    public int getSize() {
        return size;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setSize(int size) {
        this.size = size;
        this.edgeChecker = this.size*2;
        this.centerX = this.size/2;
        this.centerY = this.size/2;
    }
    public void setSprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }

    public void addRotation(int degree)
    {
        this.rotation += Math.toRadians(degree);
    }

    public void setRotation(int degree)
    {
        this.rotation = Math.toRadians(degree);
    }

    public void setXSpriteIndex(int index)
    {
        this.xSpriteIndex = index % spritesAmtX;

        this.img = this.sprite.getSubimage(this.tileSize * this.xSpriteIndex, this.tileSize * this.ySpriteIndex, this.tileSize, this.tileSize );
    }

    public void setYSpriteIndex(int index)
    {
        this.ySpriteIndex = index % spritesAmtY;

        this.img = this.sprite.getSubimage(this.tileSize * this.xSpriteIndex, this.tileSize * this.ySpriteIndex, this.tileSize, this.tileSize );

    }

    public void setSpriteIndex(int xIndex, int yIndex)
    {
        this.xSpriteIndex = xIndex % spritesAmtX;
        this.ySpriteIndex = yIndex % spritesAmtY;

        this.img = this.sprite.getSubimage(this.tileSize * this.xSpriteIndex, this.tileSize * this.ySpriteIndex, this.tileSize, this.tileSize );

    }

    public void setAniStartIndex(int aniStartIndex) {
        if(aniStartIndex > 0)
        {
            this.aniStartIndex = aniStartIndex;
        }
        else
        {
            this.aniStartIndex = 0;
        }
    }

    public void setAniEndIndex(int aniEndIndex) {
        if(aniEndIndex < this.spritesAmtY)
        {
            this.aniEndIndex = aniEndIndex;
        }
        else
        {
           this.aniEndIndex = this.spritesAmtY;
        }
    }

    public void setAnimationSpeed(double animationSpeed, String timeType)
    {
        this.animationSpeed = (long) Utils.convertTime(animationSpeed,timeType,"ns");
    }

    public void setAnimationSpeed(double animationSpeed)
    {
        this.animationSpeed = (long) Utils.convertTime(animationSpeed,"ms","ns");
    }

    public void setScreenPos(int x, int y)
    {
        this.pos.screenX = x;
        this.pos.screenY = y;

    }

    public void setWorldPos(int x, int y)
    {
        this.pos.worldX = x;
        this.pos.worldY = y;

    }

    public void setPos(int x, int y)
    {
        this.pos.screenX = x;
        this.pos.screenY = y;
        this.pos.worldX = x;
        this.pos.worldY = y;

    }

    public void centerPos()
    {
        this.pos.screenX -= this.size/2;
        this.pos.screenY -= this.size/2;
        this.pos.worldX -= this.size/2;
        this.pos.worldY -= this.size/2;
    }

    public void centerWorldPos()
    {
        this.pos.worldX -= this.size/2;
        this.pos.worldY -= this.size/2;
    }

    public void centerScreenPos()
    {
        this.pos.screenX -= this.size/2;
        this.pos.screenY -= this.size/2;
    }

    //---- Controllers ---------------------------------------------------------------------------------------------------------------

    public void start()
    {
        if(spritesAmtY > 1)
        {
            this.animate = true;
            this.lastAnimationTime = 0;
        }
    }

    public void pause()
    {
        this.animate = false;
        this.lastAnimationTime = 0;
    }

    public void loop()
    {
        this.loop = true;
    }

    public void once()
    {
        this.loop = false;
    }

    //---- Draw ---------------------------------------------------------------------------------------------------------------

    public void draw(Graphics2D g2)
    {
        if(this.pos.isInside(0-this.edgeChecker,mp.screenWidth+this.edgeChecker,0-this.edgeChecker,mp.screenHeight+this.edgeChecker))
        {
        //?!?

            if(this.animate == true)
            {
                if(this.loop == true)
                {
                    if(this.lastAnimationTime == 0)
                    {
                        this.ySpriteIndex = this.aniStartIndex;
                    }

                    if(this.ySpriteIndex+1 > this.aniEndIndex)
                    {
                        this.ySpriteIndex = this.aniStartIndex;
                    }

                    if((System.nanoTime() - lastAnimationTime) >= animationSpeed)
                    {
                        this.setYSpriteIndex( (this.ySpriteIndex+1) );
                        lastAnimationTime = System.nanoTime();
                    }
                }
                else
                {
                    if(this.lastAnimationTime == 0)
                    {
                        this.ySpriteIndex = this.aniStartIndex;
                    }

                    if(this.ySpriteIndex+1 > this.aniEndIndex)
                    {
                        this.pause();
                    }

                    if((System.nanoTime() - lastAnimationTime) >= animationSpeed)
                    {
                        this.setYSpriteIndex( (this.ySpriteIndex+1) );
                        lastAnimationTime = System.nanoTime();
                    }
                }
            }

            if(this.rotation == 0)
            {
                if(this.flipX == false && this.flipY == false)
                {
                    g2.drawImage(img, this.pos.screenX, this.pos.screenY,this.size,this.size, null);
                }
                else if(this.flipX == true && this.flipY == false)
                {
                    g2.drawImage(img, this.pos.screenX+this.size, this.pos.screenY,-this.size,this.size, null);
                }
                else if(this.flipX == false && this.flipY == true)
                {
                    g2.drawImage(img, this.pos.screenX, this.pos.screenY+this.size,this.size,-this.size, null);
                }
                else
                {
                    g2.drawImage(img, this.pos.screenX+this.size, this.pos.screenY+this.size,-this.size,-this.size, null);
                }
            }
            else
            {
                //! Funziona la rotazione ma mi sembra che non sia ancora centrata perfettamente
                AffineTransform at = new AffineTransform();
                at.translate(this.pos.screenX - (this.centerX), this.pos.screenY - (this.centerY));
                at.rotate(this.rotation);
                at.translate(-this.centerX, -this.centerX);

                g2.drawImage(img,at,null);

            }

        //!?!
        }
    }

    //---- Extra ---------------------------------------------------------------------------------------------------------------

    public Sprite clone()
    {
        Sprite temp = new Sprite(this.mp,this.sprite,this.size,this.tileSize,this.xSpriteIndex,this.ySpriteIndex,this.animationSpeed);

        return temp;
    }

    public Sprite cloneBlank()
    {
        Sprite temp = new Sprite(this.mp,this.sprite,this.size);

        return temp;
    }

}
