package main;

import extra.*;

import gameObjects.other.Player;
import gameObjects.other.Sprite;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*

    //=== VARIABLES ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

    //=== CONSTRUCTORS ====================================================================================================================

    //=== FUNCTIONS ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

>    [ INFO ]

!||  CLASSI  ||

!||  FUNZIONI  ||

!||  VARIABILI  ||

.   mp = !IMPORTANTE! variabile che contiene l'istanza di questo pannello e ci permette di accedere a funzioni e variabili comodamente

!||  ALTRO  ||

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

!||  TODO  || ❌ ✔️ ⚙️ ⮞

.------------------------------------------
.⠀                                        |
. ❌ = da fare                            |
. ✔️ = da non fare                        |
. ⚙️ = in lavoro                          |
.  ⮞ = "si collega a"                     |
.⠀                                        |
.------------------------------------------

•   ✔️ | Aggiornata classi game objects all'utilizzo della nuova classe Sprite [ Xavier ]
•   ❌️️️ | Classe Bullet : collegato allo sviluppo delle hitbox e delle animazioni [ Lucidi - Xavier ]
•   ❌ | TextBox [ Lux - Xavier ]
•   ❌ | A* path finding per gli NPC [ Yehor ]
•   ⚙️ | Stage + Room : creare il caricamento delle sprite, la generazione delle mappe, salvataggio e caricamento delle mappe, e la stampa delle mappe ( ⮞ creazione del "tile system" ) [ Lux - Xav ]
•   ⚙️ | Gestire gli oggetti e creare il glossario di oggetti nel main panel [ Andre ]
•   ⚙️ | Sync della camera ( ⮞ prima stampa della stanza e test generale ) [ Xav ]

> Documentazione interna al codice per chiarire dubbi su variabili,classi e funzioni
*/

public class MainPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {

    //=== PANEL VARIABLES ====================================================================================================================

    //---- Mouse variables ---------------------------------------------------------------------------------------------------------------

    public boolean pressedRClick;
    PointerInfo mouseInfo;

    //---- Panel logic variables ---------------------------------------------------------------------------------------------------------------

    Thread gameThread;

    public Camera camera;

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
    public int centerX;
    public int centerY;
    private double VIEW_HEIGHT;
    private double VIEW_WIDTH;
    private double VIEW_MIN;
    private double VIEW_MAX;
    public int tileSize = 144;

    //=== GAME VARIABLES ================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------

    Game game;

    //---- Input variables ---------------------------------------------------------------------------------------------------
    public KeyHandler input = new KeyHandler();

    //---- Player variables ---------------------------------------------------------------------------------------------------

    //---- Background variables ---------------------------------------------------------------------------------------------------

    //=== SPRITES ================================================================================================================

    //---- Entities Sprites ---------------------------------------------------------------------------------------------------

    //! Player

    public Sprite playerSprites;

    //! NPC

    public Sprite[] npcSprites;

    //---- Room Sprites ---------------------------------------------------------------------------------------------------

    //! Test

    public Sprite[] test_GroundSprites;
    public Sprite[] test_WallSprites;

    //---- Item Sprites ---------------------------------------------------------------------------------------------------

    //! ?

    public Sprite[] itemSprites;

    //=== CONSTRUCTOR ====================================================================================================================

    public MainPanel(int xSize, int ySize) {

        this.screenWidth = xSize;
        this.screenHeight = ySize;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.addKeyListener(input);
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

        this.centerX = this.screenWidth/2;
        this.centerY = this.screenHeight/2;

        this.setupSprites();

        this.setBackground(Color.black);

        this.camera = new Camera(0,0,0,0);

        this.addKeyListener(this.keyLog);

        this.game = new Game(this);

    }

    //=== FUNCTIONS ====================================================================================================================

    //---- Panel/Game Setup---------------------------------------------------------------------------------------------------------------

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void setupSprites() {

        //• ENTITIES SPRITES

        this.playerSprites = new Sprite(this, "/sprites/entities/TestDummy.png" ,0,0,0);

        //• ROOM SPRITES

        //| Ground

        this.test_GroundSprites = new Sprite[1];

        test_GroundSprites[0] = new Sprite(this, "/sprites/grounds/TestTile.png" ,0, 0,0);

        //| Wall

        this.test_WallSprites = new Sprite[2];

        test_WallSprites[0] = new Sprite(this, "/sprites/grounds/TestSideWall.png" ,0, 0,0);
        test_WallSprites[1] = new Sprite(this, "/sprites/grounds/TestWall.png" ,0, 0,0);

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

    public void update() //? funzione a cascata di aggiornamento e progressione del gioco
    {
        game.update();
    }

    public void paintComponent(Graphics g) //? funzione a cascata chiamata per disegnare ogni elemento
    {
        super.paintComponent(g);
        g2 = (Graphics2D)g;

        game.draw(g2);

        g2.dispose();
    }

    public void syncCamera() //? serve per muovere la camera ed è una funzione a cascata
    {

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

//!?!
}
