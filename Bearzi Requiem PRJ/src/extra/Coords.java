package extra;

import java.awt.Point;

public class Coords {

    public int screenX;
    public int screenY;
    public int worldX;
    public int worldY;

    public Coords(int screenX, int screenY, int worldX, int worldY)
    {
        this.screenX = screenX;
        this.screenY = screenY;
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public Coords(int screenX, int screenY)
    {
        this.screenX = screenX;
        this.screenY = screenY;
        this.worldX = screenX;
        this.worldY = screenY;
    }

    public Coords()
    {
        this.screenX = 0;
        this.screenY = 0;
        this.worldX = 0;
        this.worldY = 0;
    }

    public void setScreenCoord(int x, int y)
    {
        this.screenX = x;
        this.screenY = y;
    }

    public void setWorldCoord(int x, int y)
    {
        this.worldX = x;
        this.worldY = y;
    }

    public Point toScreenPoint()
    {
        return new Point(this.screenX,this.screenY);
    }

    public Point toWorldPoint()
    {
        return new Point(this.worldX,this.worldY);
    }

    public static Point toPoint(int x, int y)
    {
        return new Point(x,y);
    }

}
