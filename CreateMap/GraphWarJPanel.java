package CreateMap;


import java.awt.*;
import javax.swing.*;

import Character.Player;
import Character.Bot;

public class GraphWarJPanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 center = 384
    final int screenHeight = tileSize * maxScreenRow; //576 center = 288

    Thread gameThread;

    public GraphWarJPanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null) {
            System.out.println("The game loop is running");
        }
    }

    public void paint(Graphics g) {
        Player player = new Player(screenWidth, screenHeight);
        player.paint(g);

        Bot bot = new Bot(screenWidth, screenHeight);
        bot.paint(g);
        //first line
        g.drawLine(screenWidth/2, 0, screenWidth/2, screenHeight);
        g.drawLine(0, screenHeight/2, screenWidth, screenHeight/2);

        int playerXLocation = player.getX();
        int playerYLocation = player.getY();
        int playerRLocation = player.getR();


        for(int i = playerXLocation + playerRLocation; i < screenWidth; i++) {
            int j  = playerYLocation;
            if(j > 384) {
                 j = j - playerRLocation/2;
            }
            else {
                j = j + playerRLocation/2;
            }

            g.drawLine(i, j, i ,j);
            }

    }

    public int getWidth() {
        int X = this.screenWidth;
        return X;
    }
    public int getHeight() {
        int Y = this.screenHeight;
        return Y;
    }

}