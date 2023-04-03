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

    //--- Coord ---------------------------------------------------------------------------------------------

        //| Set

    public void setCoord(int x, int y)
    {
        this.screenX = x;
        this.screenY = y;
        this.worldX = x;
        this.worldY = y;
    }

    public void setXCoord(int x, int y)
    {
        this.screenX = x;
        this.worldX = x;
    }

    public void setYCoord(int x, int y)
    {
        this.screenY = y;
        this.worldY = y;
    }

        //| Shift

    public void shiftCoord(int x, int y)
    {
        this.screenX += x;
        this.screenY += y;
        this.worldX += x;
        this.worldY += y;
    }

    public void shiftXCoord(int x)
    {
        this.screenX += x;
        this.worldX += x;
    }

    public void shiftYCoord(int y)
    {
        this.screenY += y;
        this.worldY += y;
    }

    //--- Screen Coord ---------------------------------------------------------------------------------------------

        //| Set

    public void setScreenCoord(int x, int y)
    {
        this.screenX = x;
        this.screenY = y;
    }

    public void setXScreenCoord(int x)
    {
        this.screenX = x;
    }

    public void setYScreenCoord(int y)
    {
        this.screenY = y;
    }

        //| Shift

    public void shiftScreenCoord(int x, int y)
    {
        this.screenX += x;
        this.screenY += y;
    }

    public void shiftXScreenCoord(int x)
    {
        this.screenX += x;
    }

    public void shiftYScreenCoord(int y)
    {
        this.screenY += y;
    }

    //--- World Coord ---------------------------------------------------------------------------------------------

        //| Set

    public void setWorldCoord(int x, int y)
    {
        this.worldX = x;
        this.worldY = y;
    }

    public void setXWorldCoord(int x)
    {
        this.worldX = x;
    }

    public void setYWorldCoord(int y)
    {
        this.worldY = y;
    }

        //| Shift

    public void shiftWorldCoord(int x, int y)
    {
        this.worldX += x;
        this.worldY += y;
    }

    public void shiftXWorldCoord(int x)
    {
        this.worldX += x;
    }

    public void shiftYWorldCoord(int y)
    {
        this.worldY += y;
    }

    //--- Extra ---------------------------------------------------------------------------------------------

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

    public String toString()
    {
        String str = "";
        str += "[ World X: " + this.worldX + " | World Y: " + this.worldY + " ]" + Utils.nL;
        str += "[ Screen X: " + this.screenX + " | Screen Y: " + this.screenY + " ]";
        return str;
    }

    public boolean isInside(int xMin, int xMax, int yMin, int yMax)
    {
        if(this.screenX < (xMin) || this.screenX > xMax)
        {
            return false;
        }
        if(this.screenY < yMin || this.screenY > yMax)
        {
            return false;
        }

        return true;
    }

    public boolean worldIsInside(int xMin, int xMax, int yMin, int yMax)
    {
        if(this.worldX < (xMin) || this.worldX > xMax)
        {
            return false;
        }
        if(this.worldY < yMin || this.worldY > yMax)
        {
            return false;
        }

        return true;
    }

    public static double distanceBtwn(Coords pointA, Coords pointB)
    {
        return Math.sqrt( Math.pow(pointA.worldX-pointB.worldX,2) + Math.pow(pointA.worldY-pointB.worldY,2) );
    }

    public static double distanceBtwn(int xA, int yA, int xB, int yB)
    {
        return Math.sqrt( Math.pow(xA-xB,2) + Math.pow(yA-yB,2) );
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Coords)
        {
            if(((Coords) obj).worldX != this.worldX)
            {
                return false;
            }
            if(((Coords) obj).worldY != this.worldY)
            {
                return false;
            }
            if(((Coords) obj).screenX != this.screenX)
            {
                return false;
            }
            if(((Coords) obj).screenY != this.screenY)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public Coords clone()
    {
        Coords obj = new Coords(this.worldX,this.worldY,this.screenX,this.screenY);
        return obj;
    }

}
