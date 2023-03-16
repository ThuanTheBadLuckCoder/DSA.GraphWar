package Character;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import CreateMap.GraphWarJPanel;
import Character.CreateLine;

public class Player extends JFrame {
    GraphWarJPanel getX = new GraphWarJPanel();
    int X = getX.getWidth();
    GraphWarJPanel getY = new GraphWarJPanel();
    int Y = getY.getHeight();
    int finalX = limitLocationX();
    int finalY = limitLocationY();
    //nhân vật được xác định là một hình tròn có tâm là r
    //phạm vi nhân vật bị bắn chết xác định là r
    // nếu đường đạn đi ngang qua r (nghĩa là location < r) thì nhân vật dính đạn

    //bans kinhs
    int r = 24;
    public Player(int screenWidth, int screenHeight) {
        super();
//        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
//        this.pack();
//        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
//
        //random location
        // vì r = 25 nên là giới hạn của các nhân vật sẽ nhỏ hơn hoặc bằng screenWidth -25 và screenHeight - 25

        g.drawOval(finalX, finalY, r, r);

    }

    public int limitLocationX() {
        Random rdIntX = new Random();
        int rdX = rdIntX.nextInt(384);
        if (rdX < r) {
            rdX = rdX + r;
        }

        else if (rdX >= 384) {
            rdX = rdX - r;
        }
        return rdX;
    }

    public int limitLocationY() {
        Random rdIntY = new Random();
        int rdY = rdIntY.nextInt(576);
        if (rdY < r) {
            rdY = rdY + r;
        }

        else if (rdY > 551) {
            rdY = rdY - r;
        }
        return rdY;
    }

    public int getX() {
        int getX = this.finalX;
        return getX;
    }
    public int getY() {
        int getY = this.finalY;
        return getY;
    }
    public int getR() {
        int getR = this.r;
        return getR;
    }

}
