package extra;

import java.awt.Point;

public class Coords {

    public int x;
    public int y;
    public int absX;
    public int absY;

    public Coords(int x, int y, int absX, int absY)
    {
        this.x = x;
        this.y = y;
        this.absX = absX;
        this.absY = absY;
    }

    public Coords(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.absX = x;
        this.absY = y;
    }

    public Coords()
    {
        this.x = 0;
        this.y = 0;
        this.absX = 0;
        this.absY = 0;
    }

    public Point toPoint()
    {
        return new Point(this.x,this.y);
    }

    public Point toAbsPoint()
    {
        return new Point(this.absX,this.absY);
    }

}
