import javax.swing.*;
import java.io.*;
import java.awt.*;

public class LightDrawing extends JComponent {

    Color ready = Color.gray;
    Color go = Color.gray;
    Color fail = Color.gray;

    protected String activeLight = "yellow";

    public void paintComponent(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0,0,350,450);

        g.setColor(Color.black);
        g.fillRect(175,100,5,350);
        g.fillRect(25,100,300,5);
        g.fillRect(152, 150, 51, 5);
        g.fillRect(152, 200, 51, 5);
        g.fillRect(152, 250, 51, 5);
        g.fillRect(152, 300, 51, 5);
        g.fillRect(152, 350, 51, 5);
        g.fillRect(152, 400, 51, 5);

        g.setColor(Color.yellow);
        g.fillOval(110, 125, 50, 50);
        g.fillOval(200, 125, 50, 50);

        g.setColor(ready);
        g.fillOval(110, 175, 50, 50);
        g.fillOval(110, 225, 50, 50);
        g.fillOval(110, 275, 50, 50);
        g.fillOval(200, 175, 50, 50);
        g.fillOval(200, 225, 50, 50);
        g.fillOval(200, 275, 50, 50);

        g.setColor(go);
        g.fillOval(110, 325, 50, 50);
        g.fillOval(200, 325, 50, 50);

        g.setColor(fail);
        g.fillOval(110, 375, 50, 50);
        g.fillOval(200, 375, 50, 50);


    }

    public void changeColorY(){

        ready = Color.yellow;

        repaint();
    }

    public void changeColorG(){
        go = Color.green;
        activeLight = "green";

        repaint();
    }

    public void resetColor(){
        ready = Color.gray;
        go = Color.gray;
        repaint();
    }
    public String getActiveLight(){
        return activeLight;
    }
}
