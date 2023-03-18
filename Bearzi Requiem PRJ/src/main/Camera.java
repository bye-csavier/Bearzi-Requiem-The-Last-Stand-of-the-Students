package main;

import extra.Coords;

public class Camera {

    //=== VARIABLES ====================================================================================================================

    public int x;
    public int y;
    public double camZoom = 0;
    public double camRotation = 0;

    //=== CONSTRUCTOR ====================================================================================================================

    public Camera(int givnCamX, int givnCamY, double givnCamZoom, double givnCamRotation)
    {
        this.x = givnCamX;
        this.y = givnCamY;
        this.camZoom = givnCamZoom;
        this.camRotation = givnCamRotation;
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

    public double getZoom()
    {
        return this.camZoom;
    }

    public double getRotation()
    {
        return this.camRotation;
    }

    public void setRotation(int rotation)
    {
        this.camRotation = rotation;
    }

    public void rotate(int addRotation)
    {
        this.camRotation += addRotation;
    }

    public void setZoom(int zoom)
    {
        this.camZoom = zoom;
    }

    public void addZoom(int addZoom)
    {
        this.camZoom += addZoom;
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
