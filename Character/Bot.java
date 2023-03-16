package Character;

import CreateMap.GraphWarJPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Bot extends JFrame {
    int r = 25;
    public Bot(int screenWidth, int screenHeight) {
        super("Graphwar");
    }
    GraphWarJPanel getX = new GraphWarJPanel();
    int X = getX.getWidth();
    GraphWarJPanel getY = new GraphWarJPanel();
    int Y = getY.getHeight();
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        //random location
        // vì r = 25 nên là giới hạn của các nhân vật sẽ nhỏ hơn hoặc bằng screenWidth -25 và screenHeight - 25
        int finalX = limitLocationX();
        int finalY = limitLocationY();
        g.drawOval(finalX, finalY, r, r);
    }

    public int limitLocationX() {
        Random rdIntX = new Random();
        int rdX = rdIntX.nextInt(768);
        if (rdX < 384) {
            rdX = 384 + 25;
        }

        else if (rdX > 743) {
            rdX = rdX - 25;
        }
        return rdX;
    }

    public int limitLocationY() {
        Random rdIntY = new Random();
        int rdY = rdIntY.nextInt(576);
        if (rdY < 25) {
            rdY = rdY + 25;
        }

        else if (rdY > 551) {
            rdY = rdY - 25;
        }
        return rdY;
    }
}
