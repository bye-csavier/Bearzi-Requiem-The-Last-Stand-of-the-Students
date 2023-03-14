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

            if(maiusc == true)
            {
                Q = true;
            }
        }
        if(keyCode == KeyEvent.VK_W) {
            w = true;

            if(maiusc == true)
            {
                W = true;
            }
        }
        if(keyCode == KeyEvent.VK_E) {
            e = true;

            if(maiusc == true)
            {
                E = true;
            }
        }
        if(keyCode == KeyEvent.VK_R) {
            r = true;

            if(maiusc == true)
            {
                R = true;
            }
        }
        if(keyCode == KeyEvent.VK_T) {
            t = true;

            if(maiusc == true)
            {
                T = true;
            }
        }
        if(keyCode == KeyEvent.VK_Y) {
            y = true;

            if(maiusc == true)
            {
                Y = true;
            }
        }
        if(keyCode == KeyEvent.VK_U) {
            u = true;

            if(maiusc == true)
            {
                U = true;
            }
        }
        if(keyCode == KeyEvent.VK_I) {
            i = true;

            if(maiusc == true)
            {
                I = true;
            }
        }
        if(keyCode == KeyEvent.VK_O) {
            o = true;

            if(maiusc == true)
            {
                O = true;
            }
        }
        if(keyCode == KeyEvent.VK_P) {
            p = true;

            if(maiusc == true)
            {
                P = true;
            }
        }
        if(keyCode == KeyEvent.VK_A) {
            a = true;

            if(maiusc == true)
            {
                A = true;
            }
        }
        if(keyCode == KeyEvent.VK_S) {
            s = true;

            if(maiusc == true)
            {
                S = true;
            }
        }
        if(keyCode == KeyEvent.VK_D) {
            d = true;

            if(maiusc == true)
            {
                D = true;
            }
        }
        if(keyCode == KeyEvent.VK_F) {
            f = true;

            if(maiusc == true)
            {
                F = true;
            }
        }
        if(keyCode == KeyEvent.VK_G) {
            g = true;

            if(maiusc == true)
            {
                G = true;
            }
        }
        if(keyCode == KeyEvent.VK_H) {
            h = true;

            if(maiusc == true)
            {
                H = true;
            }
        }
        if(keyCode == KeyEvent.VK_J) {
            j = true;

            if(maiusc == true)
            {
                J = true;
            }
        }
        if(keyCode == KeyEvent.VK_K) {
            k = true;

            if(maiusc == true)
            {
                K = true;
            }
        }
        if(keyCode == KeyEvent.VK_L) {
            l = true;

            if(maiusc == true)
            {
                L = true;
            }
        }
        if(keyCode == KeyEvent.VK_Z) {
            z = true;

            if(maiusc == true)
            {
                Z = true;
            }
        }
        if(keyCode == KeyEvent.VK_X) {
            x = true;

            if(maiusc == true)
            {
                X = true;
            }
        }
        if(keyCode == KeyEvent.VK_C) {
            c = true;

            if(maiusc == true)
            {
                C = true;
            }
        }
        if(keyCode == KeyEvent.VK_V) {
            v = true;

            if(maiusc == true)
            {
                V = true;
            }
        }
        if(keyCode == KeyEvent.VK_B) {
            b = true;

            if(maiusc == true)
            {
                B = true;
            }
        }
        if(keyCode == KeyEvent.VK_N) {
            n = true;

            if(maiusc == true)
            {
                N = true;
            }
        }
        if(keyCode == KeyEvent.VK_M) {
            m = true;

            if(maiusc == true)
            {
                M = true;
            }
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
        if(keyCode == KeyEvent.VK_ALT)
        {
            alt = true;
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
            Q = false;
        }
        if(keyCode == KeyEvent.VK_W) {
            w = false;
            W = false;
        }
        if(keyCode == KeyEvent.VK_E) {
            e = true;
            E = false;
        }
        if(keyCode == KeyEvent.VK_R) {
            r = true;
            R = false;
        }
        if(keyCode == KeyEvent.VK_T) {
            t = true;
            T = false;
        }
        if(keyCode == KeyEvent.VK_Y) {
            y = true;
            Y = false;
        }
        if(keyCode == KeyEvent.VK_U) {
            u = true;
            U = false;
        }
        if(keyCode == KeyEvent.VK_I) {
            i = true;
            I = false;
        }
        if(keyCode == KeyEvent.VK_O) {
            o = true;
            O = false;
        }
        if(keyCode == KeyEvent.VK_P) {
            p = true;
            P = false;
        }
        if(keyCode == KeyEvent.VK_A) {
            a = true;
            A = false;
        }
        if(keyCode == KeyEvent.VK_S) {
            s = true;
            S = false;
        }
        if(keyCode == KeyEvent.VK_D) {
            d = true;
            D = false;
        }
        if(keyCode == KeyEvent.VK_F) {
            f = true;
            F = false;
        }
        if(keyCode == KeyEvent.VK_G) {
            g = true;
            G = false;
        }
        if(keyCode == KeyEvent.VK_H) {
            h = true;
            H = false;
        }
        if(keyCode == KeyEvent.VK_J) {
            j = true;
            J = false;
        }
        if(keyCode == KeyEvent.VK_K) {
            k = true;
            K = false;
        }
        if(keyCode == KeyEvent.VK_L) {
            l = true;
            L = false;
        }
        if(keyCode == KeyEvent.VK_Z) {
            z = true;
            Z = false;
        }
        if(keyCode == KeyEvent.VK_X) {
            x = true;
            X = false;
        }
        if(keyCode == KeyEvent.VK_C) {
            c = true;
            C = false;
        }
        if(keyCode == KeyEvent.VK_V) {
            v = true;
            V = false;
        }
        if(keyCode == KeyEvent.VK_B) {
            b = true;
            B = false;
        }
        if(keyCode == KeyEvent.VK_N) {
            n = true;
            N = false;
        }
        if(keyCode == KeyEvent.VK_M) {
            m = true;
            M = false;
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
        if(keyCode == KeyEvent.VK_ALT)
        {
            alt = false;
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