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
    private int spriteIndex;
    private int spritesAmt;

    private BufferedImage img;

    //BufferedImage img;

    //---- Sprite Animation ---------------------------------------------------------------------------------------------------------------

    private double lastAnimationTime = 0;

    private long animationSpeed = (long) extra.Utils.convertTime(0.08, "s", "ns");

    private int aniStartIndex;

    private int aniEndIndex;

    private boolean animate;
    private boolean loop;

    //=== CONSTRUCTORS ====================================================================================================================

    public Sprite(MainPanel mp, BufferedImage sprites, int spriteIndex, long animationSpeed)
    {
        this.mp = mp;
        this.sprite = sprites;
        this.spritesAmt = (this.sprite.getHeight() / mp.tileSize);
        this.spriteIndex = spriteIndex % spritesAmt;

        this.img = this.sprite.getSubimage(0, mp.tileSize * this.spriteIndex, mp.tileSize, mp.tileSize );

        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmt;

        if(animationSpeed >= 0)
        {
            this.animationSpeed = animationSpeed;
        }

        this.animate = false;
        this.loop = false;

    }

    public Sprite(MainPanel mp, String sprites, int spriteIndex, long animationSpeed)
    {
        this.mp = mp;

        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(sprites));
        }catch(IOException e) {
            e.printStackTrace();
        }

        this.spritesAmt = (this.sprite.getHeight() / mp.tileSize);
        this.spriteIndex = spriteIndex % spritesAmt;

        this.img = this.sprite.getSubimage(0, mp.tileSize * this.spriteIndex, mp.tileSize, mp.tileSize );

        this.aniStartIndex = 0;
        this.aniEndIndex = spritesAmt;

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
        return this.img;
    }

    public void setSprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }

    public void setSpriteIndex(int index)
    {
        this.spriteIndex = index % spritesAmt;

        img = sprite.getSubimage(0, mp.tileSize * this.spriteIndex, mp.tileSize, mp.tileSize );
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
        if(aniEndIndex > this.spritesAmt)
        {
            this.aniEndIndex = aniEndIndex;
        }
        else
        {
           this.aniEndIndex = this.spritesAmt;
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
                    this.spriteIndex = this.aniStartIndex;
                }

                if(this.spriteIndex+1 > this.aniEndIndex)
                {
                    this.spriteIndex = this.aniStartIndex;
                }

                if((System.nanoTime() - lastAnimationTime) >= animationSpeed)
                {
                    this.setSpriteIndex( (this.spriteIndex+1) );
                    lastAnimationTime = System.nanoTime();
                }
            }
            else
            {
                if(this.lastAnimationTime == 0)
                {
                    this.spriteIndex = this.aniStartIndex;
                }

                if(this.spriteIndex+1 > this.aniEndIndex)
                {
                    this.pause();
                }

                if((System.nanoTime() - lastAnimationTime) >= animationSpeed)
                {
                    this.setSpriteIndex( (this.spriteIndex+1) );
                    lastAnimationTime = System.nanoTime();
                }
            }
        }

        g2.drawImage(img, this.x, this.y,mp.tileSize,mp.tileSize, null);
    }

}
