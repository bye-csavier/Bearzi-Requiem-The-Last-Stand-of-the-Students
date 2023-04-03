package UI;

import extra.Coords;
import main.MainPanel;

import java.awt.*;

abstract public class ElementUI {

    //=== VARIABLES ====================================================================================================================

    //---- Element Vars ---------------------------------------------------------------------------------------------------------------

    MainPanel mp; // Main Panel
    Rectangle area;
    boolean visible;

    //---- Size & Position Vars ---------------------------------------------------------------------------------------------------------------

    public Coords pos;

    //---- Animation Vars ---------------------------------------------------------------------------------------------------------------

        //? In Animation
    protected double inAnimationStart = 0;
    protected long inAnimationLength;
        //? General Animation
    protected double animationStart = 0;
    protected long animationLength;
        //? Out Animation
    protected double outAnimationStart = 0;
    protected long outAnimationLength;

    protected double transitionProgress = 0;
    protected double animationProgress = 0;

    protected boolean hover = false;

    //=== CONSTRUCTORS ====================================================================================================================

    //=== FUNCTIONS ====================================================================================================================

//!?!
}
