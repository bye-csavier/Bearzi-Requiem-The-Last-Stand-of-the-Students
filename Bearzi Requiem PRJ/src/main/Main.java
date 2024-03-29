package main;

import extra.Utils;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setResizable(true);
        window.setTitle("Bearzi Requiem: The Last Stand of the Students");
        window.setUndecorated(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int xSize = (int) toolkit.getScreenSize().getWidth();
        int ySize = (int) toolkit.getScreenSize().getHeight();

        window.setSize(xSize,ySize);

        MainPanel gamePanel = new MainPanel(xSize,ySize);
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}