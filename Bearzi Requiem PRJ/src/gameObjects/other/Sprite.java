package gameObjects.other;

import main.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    //=== VARIABLES ====================================================================================================================

    //---- Main ---------------------------------------------------------------------------------------------------------------

    public MainPanel mp;
    public int x;
    public int y;
    public BufferedImage sprite;

    private int xSpriteIndex;
    private int ySpriteIndex;
    private int spritesAmtX;
    private int spritesAmtY;

    private BufferedImage img;

    //---- Sprite Animation ---------------------------------------------------------------------------------------------------------------

    private double lastAnimationTime = 0;

    private long animationSpeed = (long) extra.Utils.convertTime(0.08, "s", "ns");

    private int aniStartIndex;

    private int aniEndIndex;

    private boolean animate;
    private boolean loop;

    //=== CONSTRUCTORS ====================================================================================================================

    public Sprite(MainPanel mp, BufferedImage sprites, int xSpriteIndex, int ySpriteIndex, long animationSpeed)
    {
        this.mp = mp;
        this.sprite = sprites;
        this.spritesAmtX = (this.sprite.getWidth() / mp.tileSize);
        this.spritesAmtY = (this.sprite.getHeight() / mp.tileSize);
        this.xSpriteIndex = xSpriteIndex % spritesAmtX;
        this.ySpriteIndex = ySpriteIndex % spritesAmtY;

        this.img = this.sprite.getSubimage(mp.tileSize * this.xSpriteIndex, mp.tileSize * this.ySpriteIndex, mp.tileSize, mp.tileSize );

        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmtY;

        if(animationSpeed >= 0)
        {
            this.animationSpeed = animationSpeed;
        }

        this.animate = false;
        this.loop = false;

    }

    public Sprite(MainPanel mp, String sprites, int xSpriteIndex, int ySpriteIndex, long animationSpeed)
    {
        this.mp = mp;

        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(sprites));
        }catch(IOException e) {
            e.printStackTrace();
        }

        this.spritesAmtX = (this.sprite.getWidth() / mp.tileSize);
        this.spritesAmtY = (this.sprite.getHeight() / mp.tileSize);
        this.xSpriteIndex = xSpriteIndex % spritesAmtX;
        this.ySpriteIndex = ySpriteIndex % spritesAmtY;

        this.img = this.sprite.getSubimage(mp.tileSize * this.xSpriteIndex, mp.tileSize * this.ySpriteIndex, mp.tileSize, mp.tileSize );


        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmtY;

        if(animationSpeed >= 0)
        {
            this.animationSpeed = animationSpeed;
        }

        this.animate = false;
        this.loop = false;

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Set & Get ---------------------------------------------------------------------------------------------------------------

    public BufferedImage getSprite()
    {
        return this.img;
    }

    public BufferedImage getRootSprite()
    {
        return this.sprite;
    }

    public void setSprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }

    public void setXSpriteIndex(int index)
    {
        this.xSpriteIndex = index % spritesAmtX;

        this.img = this.sprite.getSubimage(mp.tileSize * this.xSpriteIndex, mp.tileSize * this.ySpriteIndex, mp.tileSize, mp.tileSize );
    }

    public void setYSpriteIndex(int index)
    {
        this.ySpriteIndex = index % spritesAmtY;

        this.img = this.sprite.getSubimage(mp.tileSize * this.xSpriteIndex, mp.tileSize * this.ySpriteIndex, mp.tileSize, mp.tileSize );
    }

    public void setSpriteIndex(int xIndex, int yIndex)
    {
        this.xSpriteIndex = xIndex % spritesAmtX;
        this.ySpriteIndex = yIndex % spritesAmtY;

        this.img = this.sprite.getSubimage(mp.tileSize * this.xSpriteIndex, mp.tileSize * this.ySpriteIndex, mp.tileSize, mp.tileSize );
    }

    public void setAniStartIndex(int aniStartIndex) {
        if(aniStartIndex >= 0)
        {
            this.aniStartIndex = aniStartIndex;
        }
        else
        {
            this.aniStartIndex = 0;
        }
    }

    public void setAniEndIndex(int aniEndIndex) {
        if(aniEndIndex > this.spritesAmtY)
        {
            this.aniEndIndex = aniEndIndex;
        }
        else
        {
           this.aniEndIndex = this.spritesAmtY;
        }
    }

    public void setAnimationSpeed(long animationSpeed)
    {
        this.animationSpeed = animationSpeed;
    }

    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    //---- Controllers ---------------------------------------------------------------------------------------------------------------

    public void start()
    {
        this.animate = true;
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

        g2.drawImage(img, this.x, this.y,mp.tileSize,mp.tileSize, null);
    }

}
