package extra;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    // === KeyVars ==================================================================================================== TODO

    // --- Numbers --------------------------------------------------------------------------------------------------

    public boolean n0;
    public boolean n1;
    public boolean n2;
    public boolean n3;
    public boolean n4;
    public boolean n5;
    public boolean n6;
    public boolean n7;
    public boolean n8;
    public boolean n9;

    // --- Letters --------------------------------------------------------------------------------------------------

    public boolean q;
    public boolean w;
    public boolean e;
    public boolean r;
    public boolean t;
    public boolean y;
    public boolean u;
    public boolean i;
    public boolean o;
    public boolean p;
    public boolean a;
    public boolean s;
    public boolean d;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean z;
    public boolean x;
    public boolean c;
    public boolean v;
    public boolean b;
    public boolean n;
    public boolean m;

    // --- Action Keys --------------------------------------------------------------------------------------------------

    public boolean escape;
    public boolean enter;
    public boolean shift;
    public boolean maiusc;
    public boolean space;
    public boolean delete;
    public boolean ctrl;
    public boolean control;
    public boolean tab;
    public boolean backSlash;

    // === FUNCTIONS ==================================================================================================== TODO

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //! --- Pressed --------------------------------------------------------------------------------------------------
    // TODO

    @Override
    public void keyPressed(KeyEvent event)
    {

        int keyCode = event.getKeyCode();

        // --- Numbers --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_0) {
            n0 = true;
        }
        if(keyCode == KeyEvent.VK_1) {
            n1 = true;
        }
        if(keyCode == KeyEvent.VK_2) {
            n2 = true;
        }
        if(keyCode == KeyEvent.VK_3) {
            n3 = true;
        }
        if(keyCode == KeyEvent.VK_4) {
            n4 = true;
        }
        if(keyCode == KeyEvent.VK_5) {
            n5 = true;
        }
        if(keyCode == KeyEvent.VK_6) {
            n6 = true;
        }
        if(keyCode == KeyEvent.VK_7) {
            n7 = true;
        }
        if(keyCode == KeyEvent.VK_8) {
            n8 = true;
        }
        if(keyCode == KeyEvent.VK_9) {
            n9 = true;
        }

        // --- Letters --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_Q) {
            q = true;
        }
        if(keyCode == KeyEvent.VK_W) {
            w = true;
        }
        if(keyCode == KeyEvent.VK_E) {
            e = true;
        }
        if(keyCode == KeyEvent.VK_R) {
            r = true;
        }
        if(keyCode == KeyEvent.VK_T) {
            t = true;
        }
        if(keyCode == KeyEvent.VK_Y) {
            y = true;
        }
        if(keyCode == KeyEvent.VK_U) {
            u = true;
        }
        if(keyCode == KeyEvent.VK_I) {
            i = true;
        }
        if(keyCode == KeyEvent.VK_O) {
            o = true;
        }
        if(keyCode == KeyEvent.VK_P) {
            p = true;
        }
        if(keyCode == KeyEvent.VK_A) {
            a = true;
        }
        if(keyCode == KeyEvent.VK_S) {
            s = true;
        }
        if(keyCode == KeyEvent.VK_D) {
            d = true;
        }
        if(keyCode == KeyEvent.VK_F) {
            f = true;
        }
        if(keyCode == KeyEvent.VK_G) {
            g = true;
        }
        if(keyCode == KeyEvent.VK_H) {
            h = true;
        }
        if(keyCode == KeyEvent.VK_J) {
            j = true;
        }
        if(keyCode == KeyEvent.VK_K) {
            k = true;
        }
        if(keyCode == KeyEvent.VK_L) {
            l = true;
        }
        if(keyCode == KeyEvent.VK_Z) {
            z = true;
        }
        if(keyCode == KeyEvent.VK_X) {
            x = true;
        }
        if(keyCode == KeyEvent.VK_C) {
            c = true;
        }
        if(keyCode == KeyEvent.VK_V) {
            v = true;
        }
        if(keyCode == KeyEvent.VK_B) {
            b = true;
        }
        if(keyCode == KeyEvent.VK_N) {
            n = true;
        }
        if(keyCode == KeyEvent.VK_M) {
            m = true;
        }

        // --- Action Keys --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_ESCAPE)
        {
            escape = true;
        }
        if(keyCode == KeyEvent.VK_SHIFT)
        {
            shift = true;
            maiusc = true;
        }
        if(keyCode == KeyEvent.VK_ENTER)
        {
            enter = true;
        }
        if(keyCode == KeyEvent.VK_SPACE) {
            space = true;
        }
        if(keyCode == KeyEvent.VK_BACK_SPACE) {
            delete = true;
        }
        if(keyCode == KeyEvent.VK_CONTROL) {
            ctrl = true;
            control = true;
        }
        if(keyCode == KeyEvent.VK_BACK_SLASH) {
            backSlash = true;
        }
        if(keyCode == KeyEvent.VK_TAB)
        {
            tab = true;
        }

    } // TODO

    //! --- Released --------------------------------------------------------------------------------------------------
    // TODO

    @Override
    public void keyReleased(KeyEvent event) {

        int keyCode = event.getKeyCode();

        // --- Numbers --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_0) {
            n0 = false;
        }
        if(keyCode == KeyEvent.VK_1) {
            n1 = false;
        }
        if(keyCode == KeyEvent.VK_2) {
            n2 = false;
        }
        if(keyCode == KeyEvent.VK_3) {
            n3 = false;
        }
        if(keyCode == KeyEvent.VK_4) {
            n4 = false;
        }
        if(keyCode == KeyEvent.VK_5) {
            n5 = false;
        }
        if(keyCode == KeyEvent.VK_6) {
            n6 = false;
        }
        if(keyCode == KeyEvent.VK_7) {
            n7 = false;
        }
        if(keyCode == KeyEvent.VK_8) {
            n8 = false;
        }
        if(keyCode == KeyEvent.VK_9) {
            n9 = false;
        }

        // --- Letters --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_Q) {
            q = false;
        }
        if(keyCode == KeyEvent.VK_W) {
            w = false;
        }
        if(keyCode == KeyEvent.VK_E) {
            e = false;
        }
        if(keyCode == KeyEvent.VK_R) {
            r = false;
        }
        if(keyCode == KeyEvent.VK_T) {
            t = false;
        }
        if(keyCode == KeyEvent.VK_Y) {
            y = false;
        }
        if(keyCode == KeyEvent.VK_U) {
            u = false;
        }
        if(keyCode == KeyEvent.VK_I) {
            i = false;
        }
        if(keyCode == KeyEvent.VK_O) {
            o = false;
        }
        if(keyCode == KeyEvent.VK_P) {
            p = false;
        }
        if(keyCode == KeyEvent.VK_A) {
            a = false;
        }
        if(keyCode == KeyEvent.VK_S) {
            s = false;
        }
        if(keyCode == KeyEvent.VK_D) {
            d = false;
        }
        if(keyCode == KeyEvent.VK_F) {
            f = false;
        }
        if(keyCode == KeyEvent.VK_G) {
            g = false;
        }
        if(keyCode == KeyEvent.VK_H) {
            h = false;
        }
        if(keyCode == KeyEvent.VK_J) {
            j = false;
        }
        if(keyCode == KeyEvent.VK_K) {
            k = false;
        }
        if(keyCode == KeyEvent.VK_L) {
            l = false;
        }
        if(keyCode == KeyEvent.VK_Z) {
            z = false;
        }
        if(keyCode == KeyEvent.VK_X) {
            x = false;
        }
        if(keyCode == KeyEvent.VK_C) {
            c = false;
        }
        if(keyCode == KeyEvent.VK_V) {
            v = false;
        }
        if(keyCode == KeyEvent.VK_B) {
            b = false;
        }
        if(keyCode == KeyEvent.VK_N) {
            n = false;
        }
        if(keyCode == KeyEvent.VK_M) {
            m = false;
        }

        // --- Action Keys --------------------------------------------------------------------------------------------------

        if(keyCode == KeyEvent.VK_ESCAPE)
        {
            escape = false;
        }
        if(keyCode == KeyEvent.VK_SHIFT)
        {
            shift = false;
            maiusc = false;
        }
        if(keyCode == KeyEvent.VK_ENTER)
        {
            enter = false;
        }
        if(keyCode == KeyEvent.VK_SPACE) {
            space = false;
        }
        if(keyCode == KeyEvent.VK_BACK_SPACE) {
            delete = false;
        }
        if(keyCode == KeyEvent.VK_CONTROL) {
            ctrl = false;
            control = false;
        }
        if(keyCode == KeyEvent.VK_BACK_SLASH) {
            backSlash = false;
        }
        if(keyCode == KeyEvent.VK_TAB)
        {
            tab = false;
        }

    }//

    public boolean numPressed() {

        if( n0 == true || n1 == true || n2 == true || n3 == true || n4 == true || n5 == true || n6 == true || n7 == true || n8 == true || n9 == true)
        {
            return true;
        }

        return false;
    }

}