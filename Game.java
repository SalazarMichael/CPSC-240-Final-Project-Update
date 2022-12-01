import javax.swing.*;
import java.awt.event.*;



public class Game extends JFrame {
    private String player1;
    private String player2;


    public void Gamerun(String p1In, String p2In){
        player1 = p1In;
        player2 = p2In;

        String player1String = player1.toString();

        GameProgress tracker = new GameProgress();
        tracker.setPLayer1Name(player1);
        tracker.setPlayer2Name(player2);

        JFrame frame = new JFrame("Pro Tree");
        JPanel panel = new LightsPanel();
        JTextField text = new JTextField(20);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
    }

}
