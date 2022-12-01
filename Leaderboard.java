import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;



public class Leaderboard extends JFrame {

    String inName;
    String inTime;
    int inTimeInt;
    String growinglabel = " ";

    GameProgress holderFunc = new GameProgress();

    String currentP1;
    String currentP2;
    int currentP1TParse;
    int currentP2TParse;
    public void mainBoard() throws FileNotFoundException {

        JFrame scoreBoard = new JFrame("Leaderboard");

        JLabel titleLabel = new JLabel("Top 5 Times!");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel currentWin = new JLabel("");
        JLabel currentL = new JLabel("");
        currentWin.setFont(new Font("Serif", Font.BOLD, 30));
        currentL.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel label1 = new JLabel("hello1");
        JLabel label2 = new JLabel("");
        JLabel label3 = new JLabel("");
        JLabel label4 = new JLabel("");
        JLabel label5 = new JLabel("");
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label3.setFont(new Font("Serif", Font.BOLD, 20));
        label4.setFont(new Font("Serif", Font.BOLD, 20));
        label5.setFont(new Font("Serif", Font.BOLD, 20));

        currentP1 = holderFunc.getPlayer1name();
        currentP2 = holderFunc.getPlayer2name();
        currentP1TParse = Integer.parseInt(holderFunc.getPlayer1Time());
        currentP2TParse = Integer.parseInt(holderFunc.getPlayer2Time());

        if (currentP1TParse < currentP2TParse){
            currentWin.setText("Winner: " + currentP1 + " " +  holderFunc.getPlayer1Time() + " ms");
            currentL.setText("Loser: " + currentP2 + " " + holderFunc.getPlayer2Time() + " ms");
        }
        if(currentP1TParse > currentP2TParse){
            currentWin.setText("Winner: " + currentP2 + " " +  holderFunc.getPlayer2Time() + " ms");
            currentL.setText("Loser: " + currentP1 + " " + holderFunc.getPlayer1Time() + " ms");
        }




        //scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scoreBoard.getContentPane().setLayout(new BoxLayout(scoreBoard.getContentPane(), BoxLayout.Y_AXIS));
        scoreBoard.setPreferredSize(new Dimension(400,300));
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> timeList = new ArrayList<>();
        File[] filePath = new File("timeslips/").listFiles();

        for (File fileToAdd : filePath){
            Scanner fileReader = new Scanner(fileToAdd);
            inName = fileReader.nextLine();
            inTime = fileReader.nextLine();
            inTimeInt = Integer.parseInt(inTime);
            //growinglabel += inName + " %n" + inTime + " ";



            nameList.add(inName);
            timeList.add(inTimeInt);
        }
        int tempNum;
        String tempName;

        if (timeList.size() > 1) // check if the number of orders is larger than 1
        {
            for (int x = 0; x < timeList.size() -1; x++) // bubble sort outer loop
            {
                for (int i = 0; i < timeList.size() - x -1; i++) {
                    if (timeList.get(i) >= (timeList.get(i + 1))) {
                        {
                            tempNum = timeList.get(i);
                            tempName = nameList.get(i);
                            nameList.set(i,nameList.get(i+1));
                            timeList.set(i, timeList.get(i + 1));
                            nameList.set(i+1, tempName);
                            timeList.set(i + 1, tempNum);
                        }
                    }
                }
            }

        }
        String afterSortNum = " ";

        for (int x = 0; x < timeList.size(); x++){
            afterSortNum += nameList.get(x) + " " + timeList.get(x) + " " ;

        }


        label1.setText("1: " + nameList.get(0) + ": " + timeList.get(0) + " ms");
        label2.setText("2: " + nameList.get(1) + ": " + timeList.get(1) + " ms");
        if (nameList.size() >= 3) {
            label3.setText("3: " + nameList.get(2) + ": " + timeList.get(2) + " ms");
        }
        if(nameList.size() >= 4) {
            label4.setText("4: " + nameList.get(3) + ": " + timeList.get(3) + " ms");
        }
        if (nameList.size() >= 6) {
            label5.setText("5: " + nameList.get(4) + ": " + timeList.get(4) + " ms");
        }


        scoreBoard.add(currentWin);
        scoreBoard.add(currentL);
        scoreBoard.add(titleLabel);
        scoreBoard.add(label1);
        scoreBoard.add(label2);
        scoreBoard.add(label3);
        scoreBoard.add(label4);
        scoreBoard.add(label5);

        scoreBoard.pack();
        scoreBoard.setVisible(true);

    }
}
