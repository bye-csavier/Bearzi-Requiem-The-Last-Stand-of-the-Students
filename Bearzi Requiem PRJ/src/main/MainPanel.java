package main;

import extra.*;

import gameObjects.other.Sprite;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*

    //=== VARIABLES ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

    //=== CONSTRUCTORS ====================================================================================================================

    //=== FUNCTIONS ====================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------------------

>    [ INFO ]

!||  CLASSI  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

| Settings |
.   E una classe importante che contiene variabili di impostazione e di base per il gioco oltre che costanti finali come stringhe

!||  FUNZIONI  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

| getSpritesByName |
.   !IMPORTANTE! è la funzione generica e più utilizzata per reprire le sprite del codice in maniera semplice e "sicura"; il manetenimento è macchinoso e lento ma lo rende molto personalizzabile e performante

!||  VARIABILI  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

| mp |
.   !IMPORTANTE! variabile che contiene l'istanza di questo pannello e ci permette di accedere a funzioni e variabili comodamente

!||  STANDARDS  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

| Matrici |
.   !IMPORTANTE! Utilizziamo questa logica per le matrici matrix[X][Y] = matrix[righe][colonne]

| Spritesheets |
.   !IMPORTANTE! Sulla asse Y si mettono le evoluzioni di una sprite e su quella X le sue varianti, per precisazioni chiedere a lux o xavi (oppure guardare come sono strutturate le sprite)
.   !IMPORTANTE! Per gli NPC e simili = PRIMO SET DI SPRITE IN X: Idle(fermo) | SECONDO SET DI SPRITE IN X: Moving |  TERZO SET DI SPRITE IN X: Attack

!||  ALTRO  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

| Lessico Dimensioni |
.   Width = X / Larghezza / Dimensione orizzontale || Height = Y / Altezza / Dimensione verticale

======================================================================================================================================================================================

•||  TODO  || -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

.-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
.⠀
. ❌ = da fare
.  ❗ = priorita
. ✔️ = da non fare
. ⚙️ = in lavoro
.  ⮞ = "si collega a"
.⠀
.-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

--- ANDRE ----------------------------------------------------------------------
❌️️️ | Attacco corpo a corpo dei mostri [ Andre - Yehor ] ❗
⚙️️️ | Classe Bullet : collegato allo sviluppo delle hitbox e delle animazioni [ Andre - Yehor ] ❗
⚙️ | Gestire gli oggetti e creare il glossario di oggetti nel main panel (vago) [ Andre ]

--- YEHOR ----------------------------------------------------------------------
❌️️️ | Attacco corpo a corpo dei mostri [ Andre - Yehor ] ❗
⚙️ | Creare un NPC di base, e farlo muovere nella mappa grazie all'algoritmo di A* [ Xav - Yehor ] ❗

--- LUX ----------------------------------------------------------------------
❌️️️ | Creazione arma che utilizza bullet e intergisce con la posizone del mouse (magari se riusciamo anche arma corpo a corpo ⮞ attacco mostri) [ Xav - Lux ] ❗
❌️️️ | Mostri & Personaggio che prendono danno e muoiono [ Xav - Lux ] ❗
❌️️️ | Aggiunte di porte funzionanti alle stanze [ Xav - Lux ]
❌ | TextBox [ Lux - Xav ]
❌ | Gestione e riproduzione dei suoni [ Lux ]
❌ | Bloccare i movimenti del player in caso di collisione [ Xav - Lux ] ❗
⚙️ | Stage + Room : salvataggio e caricamento delle mappe [ Lux - Xav ]
✔️ | Stage + Room : creare il caricamento delle sprite, la generazione delle mappe e la stampa delle mappe ( ⮞ creazione del "tile system" ) [ Lux - Xav ]
✔️ | Capire come gestire la hitbox delle sprite della Room che per ora non sono segnate come oggetti (influisce su syncCamera e si deve allineare con gli ogetti di andre) [ Xav - Lux ]

--- XAV ----------------------------------------------------------------------
❌️️️ | Creazione arma che utilizza bullet e intergisce con la posizone del mouse (magari se riusciamo anche arma corpo a corpo ⮞ attacco mostri) [ Xav - Lux ] ❗
❌️️️ | Mostri & Personaggio che prendono danno e muoiono [ Xav - Lux ] ❗
❌️️️ | Aggiunte di porte funzionanti alle stanze [ Xav - Lux ]
❌ | TextBox [ Lux - Xav ]
❌ | Bloccare i movimenti del player in caso di collisione [ Xav - Lux ] ❗
⚙️ | Stage + Room : salvataggio e caricamento delle mappe [ Lux - Xav ]
⚙️ | Creare un NPC di base, e farlo muovere nella mappa grazie all'algoritmo di A* [ Xav - Yehor ] ❗
✔️ | Aggiornata classi game objects all'utilizzo della nuova classe Sprite [ Xav ]
✔️ | Scambio da riferimento generale a tilesize a size personalizzato con l'aggiunta di zoom dal mp [ Xav ]
✔️ | Mettere la conversione interna in millisecondi nei costruttori di sprite [ Xav ]
✔️ | Stage + Room : creare il caricamento delle sprite, la generazione delle mappe e la stampa delle mappe ( ⮞ creazione del "tile system" ) [ Lux - Xav ]
✔️ | Sync della camera ( ⮞ prima stampa della stanza e test generale ) [ Xav ]
✔️ | Movimento NPC [ Xav ]
✔️ | Capire come gestire la hitbox delle sprite della Room che per ora non sono segnate come oggetti (influisce su syncCamera e si deve allineare con gli ogetti di andre) [ Xav - Lux ]

======================================================================================================================================================================================

> Documentazione interna al codice per chiarire dubbi su variabili,classi e funzioni
*/


public class MainPanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {

    //=== PANEL VARIABLES ====================================================================================================================

    //---- Mouse variables ---------------------------------------------------------------------------------------------------------------

    public boolean pressedRClick;
    PointerInfo mouseInfo;

    //---- Panel logic variables ---------------------------------------------------------------------------------------------------------------

    Thread gameThread;

    public Camera cam;

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
    public int zoom = 100;
    public Settings settings;

    //=== GAME VARIABLES ================================================================================================================

    //---- Common ---------------------------------------------------------------------------------------------------

    public Game game;

    //---- Input variables ---------------------------------------------------------------------------------------------------
    public KeyHandler input = new KeyHandler();

    //---- Player variables ---------------------------------------------------------------------------------------------------

    //---- Background variables ---------------------------------------------------------------------------------------------------

    //=== SPRITES ================================================================================================================

    //---- Entities Sprites ---------------------------------------------------------------------------------------------------

    //! Player

    private Sprite playerSprites;

    //! NPC

    private Sprite spiderSprites;

    //---- Room Sprites ---------------------------------------------------------------------------------------------------

    //! Test

    private Sprite test_GroundSprites;
    private Sprite test_WallSprites;

    //---- Item Sprites ---------------------------------------------------------------------------------------------------

    //! ?

    public Sprite[] itemSprites;

    //---- Extra Sprites ---------------------------------------------------------------------------------------------------

    public Sprite blankSprite;

    //=== CONSTRUCTOR ====================================================================================================================

    public MainPanel(int xSize, int ySize) {
        this.settings = new Settings();
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

        this.cam = new Camera(0,0);

        this.addKeyListener(this.keyLog);

        this.game = new Game(this);

        this.cam.setCamX(0);
        this.cam.setCamY(0);

//        this.cam.setCamX(this.game.player.sprite.pos.worldX+(this.centerX));
//        this.cam.setCamY(this.game.player.sprite.pos.worldY+(this.centerY));
        this.syncCamera();
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

        //| +++
        this.playerSprites = new Sprite(this, "/sprites/entities/TestDummy.png" ,Utils.percentage(Settings.playerSize,this.zoom),Settings.basicTileSize,0,0,0);
        this.spiderSprites = new Sprite(this, "/sprites/entities/spider.png", Utils.percentage(Settings.spiderSize,this.zoom), Settings.basicTileSize, 0, 0, 500);

        //• ROOM SPRITES

        //| Test
        this.test_GroundSprites = new Sprite(this, "/sprites/grounds/TestTile.png" ,Utils.percentage(Settings.basicTileSize,this.zoom),Settings.basicTileSize,0, 0,0);
        this.test_WallSprites = new Sprite(this, "/sprites/walls/TestWall.png" ,Utils.percentage(Settings.basicTileSize,this.zoom),Settings.basicTileSize,0,0,0);

        //| +++

        //• EXTRA SPRITES

        this.blankSprite = new Sprite(this, "/sprites/extra/blank.png" ,1);

    }

    //---- Game Loop Func ---------------------------------------------------------------------------------------------------------------

        // ! Game Loop Variables

            int FPS = 60;
            final double drawInterval = 1000000000.0/FPS;

            // for displayFPS vvv

            int drawCount = 0;

        //!-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    @Override
	public void run()
	{

		double nextDrawTime = System.nanoTime() + drawInterval;

		while(gameThread != null) {

			update();
			repaint();

			try {

				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;

				if(remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;

			} catch(InterruptedException e) {
				e.printStackTrace();
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
        this.game.syncCamera();
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

    //---- Extra ---------------------------------------------------------------------------------------------------------------

    public int[][] getCollisionMap()
    {
        return this.game.stage.rooms[this.game.stage.currentRoom].collisionMap;
    }

    public Sprite getSpritesByName(String name) {
       /*

>       INFO GET SPRITE (funzione per reperire le sprite)

        === WALL ====================================================================================

        === GROUND ====================================================================================

        === EXTRA ====================================================================================

>==================================================================================================================================================================

       */


        name = name.toLowerCase();

        switch (name) {

            //|--- NPCs ---------------------------------------------------------------------------------------------------------------------

            case "spider" ->{
                return this.spiderSprites.clone();
            }

            //|--- WALLs ---------------------------------------------------------------------------------------------------------------------

            case "testWall" -> {
                return test_WallSprites.clone();
            }

            //|--- GROUNDs ---------------------------------------------------------------------------------------------------------------------

            case "testGround" -> {
                return test_GroundSprites.clone();
            }

            //|--- EXTRA ---------------------------------------------------------------------------------------------------------------------

            case "player" -> {
                return playerSprites.clone();
            }

            case "blank" -> {
                return blankSprite.clone();
            }

            //|--- +++ ---------------------------------------------------------------------------------------------------------------------

            default -> {
                return null;
            }

        }

    }

    public Sprite getSprites(String set, String type, String name)
    {
        /*

        > INFO GET SPRITE (funzione per reperire le sprite)

        • formato -=-> getSprites("nome set sprite", "tipologia sprite", "nome sprite");
!       • lasciare "" se non ci sono informazioni per quel campo
!       • maiuscole o minuscole non influiscono ma la stringa deve corrispondere a quelle segnato qui sotto
        • ritorna un CLONE dell'oggetto sprite non un'istanza
!       • chiede a xav per aggiungere sprite oppure aggiungete seguendo la stessa logica riportata sotto
        • in verde sono riportati i nomi dei set, in arancione quelli dei type e in bianco quelli dei nomi <--- ? logica
        • ci possono essere casi in cui data la mancata necessità di avere una o piu delle stringe di ricerca il return "viene effettuato prima"
        • se volete eseguire una "ricerca generica" solo con il nome poetete prendere le sprite col metodo getSpritesByName()

        === SET ====================================================================================

        | test

            --- TYPE -------------------------------------------------------------------------------

            ^ ground

                . return diretto [test_GroundSprites]

            ^ wall

                . return diretto [test_GroundSprites]

            ^ "" (aka default)

                . return nullo [nullo]

        | "" (aka default)

            --- TYPE -------------------------------------------------------------------------------

            ^ "" (aka default)

                . player [playerSprites]
                . blank [blankSprite]

>==================================================================================================================================================================

        */


        set = set.toLowerCase();
        type = type.toLowerCase();
        name = name.toLowerCase();

        switch(set)
        {

            //|--- TEST ---------------------------------------------------------------------------------------------------------------------

            case "test" -> {

                switch(type)
                {
                    //.--- Ground ------------------------------------------------------------------------------------------------
                    case "ground" ->{
                        return this.test_GroundSprites.clone();
                    }
                    //.--- Wall ------------------------------------------------------------------------------------------------
                    case "wall" ->{
                        return this.test_WallSprites.clone();
                    }
                    //.--- Default ------------------------------------------------------------------------------------------------
                    default -> { //? QUA SI METTONO TUTTE LE SPRITE NON APPERTENENTI A NESSUN TIPO
                        return null;
                    }
                }

            }

            //|--- DEFAULT ---------------------------------------------------------------------------------------------------------------------

            default -> { //? QUA SI METTONO TUTTE LE SPRITE NON APPERTENENTI A NESSUN SET ( es: bagno, salotto, ...)

                switch(name)
                {
                    //.--- Spider ------------------------------------------------------------------------------------------------
                    case "spider" ->{
                        return this.spiderSprites.clone();
                    }
                    //.--- Player ------------------------------------------------------------------------------------------------
                    case "player" ->{
                        return this.playerSprites.clone();
                    }
                    //.--- Blank ------------------------------------------------------------------------------------------------
                    case "blank" ->{
                        return this.blankSprite.cloneBlank();
                    }
                    //.--- Default ------------------------------------------------------------------------------------------------
                    default -> { //? QUA SI METTONO TUTTE LE SPRITE NON APPERTENENTI A NESSUN TIPO
                        return null;
                    }
                }

            }
        }
    }

//!?!
}
