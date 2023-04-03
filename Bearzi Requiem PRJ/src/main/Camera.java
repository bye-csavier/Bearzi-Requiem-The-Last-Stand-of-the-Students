package main;

import extra.Coords;

public class Camera {

    //=== VARIABLES ====================================================================================================================

    public int x;
    public int y;

    //=== CONSTRUCTOR ====================================================================================================================

    public Camera(int givnCamX, int givnCamY)
    {
        this.x = givnCamX;
        this.y = givnCamY;

    }

    //=== FUNCTIONS ====================================================================================================================

    public int getCamX()
    {
        return this.x;
    }

    public int getCamY()
    {
        return this.y;
    }

    public void setCamPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setCamX(int x)
    {
        this.x = x;
    }

    public void setCamY(int y)
    {
        this.y = y;
    }

    public void shiftCamX(int shift)
    {
        this.x += shift;
    }

    public void shiftCamY(int shift)
    {
        this.y += shift;
    }

}
