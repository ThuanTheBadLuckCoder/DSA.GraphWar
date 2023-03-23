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
            //System.out.println("The game loop is running");
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

        int x1 = playerXLocation + playerRLocation;
        int y1 = playerYLocation + playerRLocation/2;
        double interval = 2;
        double xCo = 1;
        double yCo = 20;

        for(float x = 0; x1 + x < screenWidth; x += interval) {
            //y = x + 3

            int y = y1 + (int) (Math.sin(x * xCo) * yCo);
            int y2 = y1 + (int) (Math.sin((x + interval) * xCo) * yCo);
            System.out.println(x + ", " + y + ", " + y2);
            g.drawLine(x1 + (int)x, y, x1 + (int)((x + interval) * xCo), y2);
            }

    }

    public int getWidth() {
        return this.screenWidth;
    }
    public int getHeight() {
        return this.screenHeight;
    }

}