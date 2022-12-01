import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ButtonListener implements ActionListener{
    private JTextField textInput1;
    private JTextField textInput2;

    public ButtonListener(JTextField t1, JTextField t2) {
        textInput1 = t1;
        textInput2 = t2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String player1Name = textInput1.getText();
        String player2Name = textInput2.getText();

        if (!player1Name.equals("") && !player2Name.equals("")){

            Game gameOn = new Game();
            gameOn.Gamerun(player1Name, player2Name);

        }
    }
}

//Runs first frame and gets the player names
public class Main {

    private String player1;
    private String player2;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Reaction Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton button = new JButton("Ready!");
        JTextField player1Name = new JTextField();
        JTextField player2Name = new JTextField();
        JLabel instructions = new JLabel("Enter Player Names");
        instructions.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel indicator1 = new JLabel("Player 1 Name:");
        JLabel indicator2 = new JLabel("Player 2 Name:");


        frame.getContentPane().add(instructions);
        frame.add(indicator1);
        frame.getContentPane().add(player1Name);
        frame.add(indicator2);
        frame.getContentPane().add(player2Name);
        button.addActionListener(new ButtonListener(player1Name, player2Name));
        frame.getContentPane().add(button);

        frame.setPreferredSize(new Dimension(400,300));
        frame.pack();
        frame.setVisible(true);

    }

}

