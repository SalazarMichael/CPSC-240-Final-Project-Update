import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class LightsPanel extends JPanel implements KeyListener{
    LightDrawing lights = new LightDrawing();
    GameProgress tracking = new GameProgress();
    Leaderboard timeBoard = new Leaderboard();
    long currentTime = 0;
    long firstTimePressed = 0;
    long secondTimePressed = 0;
    long firstClickTime = 0;
    long secondClickTime = 0;
    boolean firstTime = true;
    char player1Button = 's';
    char player2Button = 'l';

    boolean isgreen = false;



    String greenLight;
    public LightsPanel(){

        JButton startButton = new JButton("Start");
        JLabel instructions = new JLabel("Player 1 will press S and Player 2 will press L when the light goes green");
        lights.setPreferredSize(new Dimension(360,460));
        JTextField text = new JTextField(10);
        text.addKeyListener(this);

        buttonListener l = new buttonListener();
        startButton.addActionListener(l);


        add(lights);
        add(startButton);
        add(instructions);
        add(text);
        text.setFocusable(true);
        text.requestFocus();
        text.requestFocusInWindow();

    }
    class buttonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            lights.resetColor();
            lights.changeColorY();
            firstClickTime = 0;
            secondClickTime = 0;
            currentTime = 0;
            isgreen = false;


            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            // your code here
                            lights.changeColorG();
                            greenLight = lights.getActiveLight();
                            currentTime = System.currentTimeMillis();
                            isgreen = true;
                            //System.out.println(currentTime);
                        }
                    },
                    1000
            );


        }

    }

    public void keyTyped(KeyEvent e) {
        int id = e.getID();
        Path path = Paths.get("timeslips");
        if (Files.exists(path)){
            //System.out.println("Directory exists");
        }
        else {

            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(isgreen == true) {
            if (id == KeyEvent.KEY_TYPED) {
                char c1 = e.getKeyChar();

                if (c1 == player1Button) {
                    firstTimePressed = System.currentTimeMillis();
                    firstClickTime = firstTimePressed - currentTime;

                    // System.out.println(firstClickTime);
                    String p1Name = tracking.getPlayer1name();
                    tracking.setPlayer1Time(firstClickTime);
                    File p1File = new File("timeslips/" + p1Name + ".txt");
                    try {
                        p1File.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        PrintWriter p1Write = new PrintWriter(p1File);
                        p1Write.println(p1Name);
                        p1Write.println(tracking.getPlayer1Time());

                        p1Write.close();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if (c1 == player2Button) {
                    secondTimePressed = System.currentTimeMillis();
                    secondClickTime = secondTimePressed - currentTime;
                    // System.out.println(secondClickTime);
                    String p2Name = tracking.getPlayer2name();
                    tracking.setPlayer2Time(secondClickTime);
                    File p2File = new File("timeslips/" + p2Name + ".txt");
                    try {
                        p2File.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        PrintWriter p2Write = new PrintWriter(p2File);
                        p2Write.println(p2Name);
                        p2Write.println(tracking.getPlayer2Time());

                        p2Write.close();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if (firstClickTime != 0 && secondClickTime != 0) {
                    try {
                        timeBoard.mainBoard();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }


    public void keyPressed(KeyEvent e) {
        //System.out.println("key input typed pressed");

    }


    public void keyReleased(KeyEvent e) {
        // System.out.println("key input typed released");
    }
}
