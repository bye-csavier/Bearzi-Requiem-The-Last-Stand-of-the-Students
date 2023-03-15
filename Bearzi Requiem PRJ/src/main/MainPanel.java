package main;

import extra.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {

    //=== PANEL VARIABLES ====================================================================================================================

    //---- Mouse variables ---------------------------------------------------------------------------------------------------------------

    public boolean pressedRClick;
    public boolean clickedRClick;

    PointerInfo mouseInfo;

    //---- Panel logic variables ---------------------------------------------------------------------------------------------------------------

    Thread gameThread;

    //public Camera camera;

    KeyHandler keyLog = new KeyHandler();

    //---- General graphics variables ---------------------------------------------------------------------------------------------------------------

    public enum PanelMode{
        MENU;

        /*
        @Override
        public String toString() {
            switch (this) {

                case MENU -> {
                    return "menu";
                }
                default -> {
                    return "unknown";
                }
            }
        }
        */

    }

    protected PanelMode panelState = PanelMode.MENU;
    Graphics2D g2;

    public int screenWidth;
    public int screenHeight;
    private double VIEW_HEIGHT;
    private double VIEW_WIDTH;
    private double VIEW_MIN;
    private double VIEW_MAX;

    //=== CONSTRUCTOR ====================================================================================================================

    public MainPanel(int xSize, int ySize) {

        this.screenWidth = xSize;
        this.screenHeight = ySize;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.VIEW_HEIGHT = ( (double) screenHeight) /100;
        this.VIEW_WIDTH = ( (double) screenWidth) /100;

        if(VIEW_HEIGHT>VIEW_WIDTH)
        {
            this.VIEW_MAX = this.VIEW_HEIGHT;
            this.VIEW_MIN = this.VIEW_WIDTH;
        }
        else
        {
            this.VIEW_MIN = this.VIEW_HEIGHT;
            this.VIEW_MAX = this.VIEW_WIDTH;
        }

        //this.camera = new Camera(0,0,0,0);

        this.addKeyListener(this.keyLog);

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Panel/Game Setup---------------------------------------------------------------------------------------------------------------

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //---- Game Loop Func ---------------------------------------------------------------------------------------------------------------

        // ! Game Loop Variables

            int FPS = 60;
            public double delta;
            final double drawInterval = 1000000000.0/FPS;
            long lastTime = System.nanoTime();
            long curTime;

            // for displayFPS vvv
            long timer = 0;
            int drawCount = 0;

        //!-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    @Override
    public void run()
    {
        while (gameThread != null)
        {
            curTime = System.nanoTime();
            delta += (curTime - lastTime) / drawInterval;
            timer += (curTime - lastTime);
            lastTime = curTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount += 10;

                this.screenWidth = this.getWidth();

                this.screenHeight = this.getHeight();
            }

            if (timer >= 100000000) {
//				System.out.println(Support.newLines(3));
//				System.out.println("X = " + this.screenWidth + " / " + (this.screenWidth/2) );
//				System.out.println("Y = " + this.screenHeight  + " / " + (this.screenHeight/2));
//				System.out.println("FPS | "+ drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2 = (Graphics2D)g;

        g2.dispose();
    }

    //---- Panel state ---------------------------------------------------------------------------------------------------------------

    public void setGameState(PanelMode givnState)
    {
        this.panelState = givnState;
    }

    public PanelMode getGameState()
    {
        return this.panelState;
    }

    // --- Mouse Functions --------------------------------------------------------------------------------------------------

    public int getMouseX()
    {
        mouseInfo = MouseInfo.getPointerInfo();
        return mouseInfo.getLocation().x;
    }

    public int getMouseY()
    {
        mouseInfo = MouseInfo.getPointerInfo();
        return mouseInfo.getLocation().y;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int code = e.getButton();

        if(code == MouseEvent.BUTTON1)
        {
            pressedRClick = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int code = e.getButton();

        if(code == MouseEvent.BUTTON1)
        {
            pressedRClick = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    //---- Responsive Size ---------------------------------------------------------------------------------------------------------------

    public int getVW(double percentage)
    {
        double value = (this.VIEW_WIDTH /*+ this.camera.camZoom*/) * percentage;
        return (int) value;
    }

    public int getVH(double percentage)
    {
        double value = (this.VIEW_HEIGHT /*+ this.camera.camZoom*/) * percentage;
        return (int) value;
    }

    public int getVMIN(double percentage)
    {
        double value = (this.VIEW_MIN /*+ this.camera.camZoom*/) * percentage;
        return (int) value;
    }

    public int getVMAX(double percentage)
    {
        double value = (this.VIEW_MAX /*+ this.camera.camZoom*/) * percentage;
        return (int) value;
    }

    //---- Camera Update ---------------------------------------------------------------------------------------------------------------

    public void updateCamera() // l'idea è quella di passare un object che come abbiamo detto è la base di ogni entita del gioco
    {

    }

//!?!
}
