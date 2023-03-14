package main;

import extra.Coords;

public class Camera {

    //=== VARIABLES ====================================================================================================================

    public Coords camPos = new Coords();
    public double camZoom = 0;
    public double camRotation = 0;

    //=== CONSTRUCTOR ====================================================================================================================

    public Camera(int givnCamX, int givnCamY, double givnCamZoom, double givnCamRotation)
    {
        this.camPos.x = givnCamX;
        this.camPos.y = givnCamY;
        this.camZoom = givnCamZoom;
        this.camRotation = givnCamRotation;
    }

    //=== FUNCTIONS ====================================================================================================================

    public int getCamX()
    {
        return this.camPos.x;
    }

    public int getCamY()
    {
        return this.camPos.y;
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

    public void setCamX(int x)
    {
        this.camPos.x = x;
    }

    public void setCamY(int y)
    {
        this.camPos.y = y;
    }

    public void shiftCamX(int shift)
    {
        this.camPos.x += shift;
    }

    public void shiftCamY(int shift)
    {
        this.camPos.y += shift;
    }

}
