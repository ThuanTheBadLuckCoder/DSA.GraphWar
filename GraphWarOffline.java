

import CreateMap.GraphWarJPanel;
import Character.Player;

import javax.swing.*;

public class GraphWarOffline {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("GraphWar");

        GraphWarJPanel graphWarJPanel = new GraphWarJPanel();
        window.add(graphWarJPanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        graphWarJPanel.startGameThread();


    }
}
