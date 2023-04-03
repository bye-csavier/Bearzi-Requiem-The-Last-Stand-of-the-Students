package extra;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{
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

    public boolean Q;
    public boolean W;
    public boolean E;
    public boolean R;
    public boolean T;
    public boolean Y;
    public boolean U;
    public boolean I;
    public boolean O;
    public boolean P;
    public boolean A;
    public boolean S;
    public boolean D;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean Z;
    public boolean X;
    public boolean C;
    public boolean V;
    public boolean B;
    public boolean N;
    public boolean M;

    // --- Symbols --------------------------------------------------------------------------------------------------

    public boolean backSlash;
    public boolean slash;
    public boolean exa;
    public boolean questionMark;
    public boolean percentage;

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
    public boolean alt;

    // === FUNCTIONS ==================================================================================================== TODO

    // --- Key Functions --------------------------------------------------------------------------------------------------

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //! --- Pressed --------------------------------------------------------------------------------------------------
    // TODO

    @Override
    public void keyPressed(KeyEvent event)
    {

        int keyCode = event.getKeyCode();
        
        switch (keyCode)
        {
//>                                                                                                                                                                                         .
            // --- Numbers --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_0 -> {
                n0 = true;
            }
            case KeyEvent.VK_1 -> {
                n1 = true;
            }
            case KeyEvent.VK_2 -> {
                n2 = true;
            }
            case KeyEvent.VK_3 -> {
                n3 = true;
            }
            case KeyEvent.VK_4 -> {
                n4 = true;
            }
            case KeyEvent.VK_5 -> {
                n5 = true;
            }
            case KeyEvent.VK_6 -> {
                n6 = true;
            }
            case KeyEvent.VK_7 -> {
                n7 = true;
            }
            case KeyEvent.VK_8 -> {
                n8 = true;
            }
            case KeyEvent.VK_9 -> {
                n9 = true;
            }

            // --- Letters --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_Q -> {
                q = true;

                if(maiusc == true)
                {
                    Q = true;
                }
            }
            case KeyEvent.VK_W -> {
                w = true;

                if(maiusc == true)
                {
                    W = true;
                }
            }
            case KeyEvent.VK_E -> {
                e = true;

                if(maiusc == true)
                {
                    E = true;
                }
            }
            case KeyEvent.VK_R -> {
                r = true;

                if(maiusc == true)
                {
                    R = true;
                }
            }
            case KeyEvent.VK_T -> {
                t = true;

                if(maiusc == true)
                {
                    T = true;
                }
            }
            case KeyEvent.VK_Y -> {
                y = true;

                if(maiusc == true)
                {
                    Y = true;
                }
            }
            case KeyEvent.VK_U -> {
                u = true;

                if(maiusc == true)
                {
                    U = true;
                }
            }
            case KeyEvent.VK_I -> {
                i = true;

                if(maiusc == true)
                {
                    I = true;
                }
            }
            case KeyEvent.VK_O -> {
                o = true;

                if(maiusc == true)
                {
                    O = true;
                }
            }
            case KeyEvent.VK_P -> {
                p = true;

                if(maiusc == true)
                {
                    P = true;
                }
            }
            case KeyEvent.VK_A -> {
                a = true;

                if(maiusc == true)
                {
                    A = true;
                }
            }
            case KeyEvent.VK_S -> {
                s = true;

                if(maiusc == true)
                {
                    S = true;
                }
            }
            case KeyEvent.VK_D -> {
                d = true;

                if(maiusc == true)
                {
                    D = true;
                }
            }
            case KeyEvent.VK_F -> {
                f = true;

                if(maiusc == true)
                {
                    F = true;
                }
            }
            case KeyEvent.VK_G -> {
                g = true;

                if(maiusc == true)
                {
                    G = true;
                }
            }
            case KeyEvent.VK_H -> {
                h = true;

                if(maiusc == true)
                {
                    H = true;
                }
            }
            case KeyEvent.VK_J -> {
                j = true;

                if(maiusc == true)
                {
                    J = true;
                }
            }
            case KeyEvent.VK_K -> {
                k = true;

                if(maiusc == true)
                {
                    K = true;
                }
            }
            case KeyEvent.VK_L -> {
                l = true;

                if(maiusc == true)
                {
                    L = true;
                }
            }
            case KeyEvent.VK_Z -> {
                z = true;

                if(maiusc == true)
                {
                    Z = true;
                }
            }
            case KeyEvent.VK_X -> {
                x = true;

                if(maiusc == true)
                {
                    X = true;
                }
            }
            case KeyEvent.VK_C -> {
                c = true;

                if(maiusc == true)
                {
                    C = true;
                }
            }
            case KeyEvent.VK_V -> {
                v = true;

                if(maiusc == true)
                {
                    V = true;
                }
            }
            case KeyEvent.VK_B -> {
                b = true;

                if(maiusc == true)
                {
                    B = true;
                }
            }
            case KeyEvent.VK_N -> {
                n = true;

                if(maiusc == true)
                {
                    N = true;
                }
            }
            case KeyEvent.VK_M -> {
                m = true;

                if(maiusc == true)
                {
                    M = true;
                }
            }

            // --- Action Keys --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_ESCAPE -> {
                escape = true;
            }
            case KeyEvent.VK_SHIFT -> {
                shift = true;
                maiusc = true;
            }
            case KeyEvent.VK_ENTER -> {
                enter = true;
            }
            case KeyEvent.VK_SPACE -> {
                space = true;
            }
            case KeyEvent.VK_BACK_SPACE -> {
                delete = true;
            }
            case KeyEvent.VK_CONTROL -> {
                ctrl = true;
                control = true;
            }
            case KeyEvent.VK_BACK_SLASH -> {
                backSlash = true;
            }
            case KeyEvent.VK_TAB ->
            {
                tab = true;
            }
            case KeyEvent.VK_ALT ->
            {
                alt = true;
            }

//>                                                                                                                                                                                         .
        }

    } // TODO

    //! --- Released --------------------------------------------------------------------------------------------------
    // TODO

    @Override
    public void keyReleased(KeyEvent event) {

        int keyCode = event.getKeyCode();

        switch (keyCode)
        {
//>                                                                                                                                                                                         .
            // --- Numbers --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_0 -> {
                n0 = false;
            }
            case KeyEvent.VK_1 -> {
                n1 = false;
            }
            case KeyEvent.VK_2 -> {
                n2 = false;
            }
            case KeyEvent.VK_3 -> {
                n3 = false;
            }
            case KeyEvent.VK_4 -> {
                n4 = false;
            }
            case KeyEvent.VK_5 -> {
                n5 = false;
            }
            case KeyEvent.VK_6 -> {
                n6 = false;
            }
            case KeyEvent.VK_7 -> {
                n7 = false;
            }
            case KeyEvent.VK_8 -> {
                n8 = false;
            }
            case KeyEvent.VK_9 -> {
                n9 = false;
            }

            // --- Letters --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_Q -> {
                q = false;
                Q = false;
            }
            case KeyEvent.VK_W -> {
                w = false;
                W = false;
            }
            case KeyEvent.VK_E -> {
                e = false;
                E = false;
            }
            case KeyEvent.VK_R -> {
                r = false;
                R = false;
            }
            case KeyEvent.VK_T -> {
                t = false;
                T = false;
            }
            case KeyEvent.VK_Y -> {
                y = false;
                Y = false;
            }
            case KeyEvent.VK_U -> {
                u = false;
                U = false;
            }
            case KeyEvent.VK_I -> {
                i = false;
                I = false;
            }
            case KeyEvent.VK_O -> {
                o = false;
                O = false;
            }
            case KeyEvent.VK_P -> {
                p = false;
                P = false;
            }
            case KeyEvent.VK_A -> {
                a = false;
                A = false;
            }
            case KeyEvent.VK_S -> {
                s = false;
                S = false;
            }
            case KeyEvent.VK_D -> {
                d = false;
                D = false;
            }
            case KeyEvent.VK_F -> {
                f = false;
                F = false;
            }
            case KeyEvent.VK_G -> {
                g = false;
                G = false;
            }
            case KeyEvent.VK_H -> {
                h = false;
                H = false;
            }
            case KeyEvent.VK_J -> {
                j = false;
                J = false;
            }
            case KeyEvent.VK_K -> {
                k = false;
                K = false;
            }
            case KeyEvent.VK_L -> {
                l = false;
                L = false;
            }
            case KeyEvent.VK_Z -> {
                z = false;
                Z = false;
            }
            case KeyEvent.VK_X -> {
                x = false;
                X = false;
            }
            case KeyEvent.VK_C -> {
                c = false;
                C = false;
            }
            case KeyEvent.VK_V -> {
                v = false;
                V = false;
            }
            case KeyEvent.VK_B -> {
                b = false;
                B = false;
            }
            case KeyEvent.VK_N -> {
                n = false;
                N = false;
            }
            case KeyEvent.VK_M -> {
                m = false;
                M = false;
            }

            // --- Action Keys --------------------------------------------------------------------------------------------------

            case KeyEvent.VK_ESCAPE -> {
                escape = false;
            }
            case KeyEvent.VK_SHIFT -> {
                shift = false;
                maiusc = false;
            }
            case KeyEvent.VK_ENTER -> {
                enter = false;
            }
            case KeyEvent.VK_SPACE -> {
                space = false;
            }
            case KeyEvent.VK_BACK_SPACE -> {
                delete = false;
            }
            case KeyEvent.VK_CONTROL -> {
                ctrl = false;
                control = false;
            }
            case KeyEvent.VK_BACK_SLASH -> {
                backSlash = false;
            }
            case KeyEvent.VK_TAB ->
            {
                tab = false;
            }
            case KeyEvent.VK_ALT ->
            {
                alt = false;
            }

//>                                                                                                                                                                                         .
        }

    }//

    public boolean numPressed() {

        if( n0 == true || n1 == true || n2 == true || n3 == true || n4 == true || n5 == true || n6 == true || n7 == true || n8 == true || n9 == true)
        {
            return true;
        }

        return false;
    }

    public boolean wasdPressed() {

        if( w == true || a == true || s == true || d == true)
        {
            return true;
        }

        return false;
    }


}