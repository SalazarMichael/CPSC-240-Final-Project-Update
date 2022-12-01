public class GameProgress {
    static String playerName1;
    static String playerName2;
    static long player1Time;
    static String player1TimeParse;
    static String player2TimeParse;
    static long player2Time;


    public GameProgress(){

    }

    public void setPLayer1Name(String inName1){
        playerName1 = inName1;
    }

    public void setPlayer2Name(String inName2){
        playerName2 = inName2;
    }
    public String getPlayer1name(){
        return playerName1;
    }
    public String getPlayer2name(){
        return playerName2;
    }
    public void setPlayer1Time(long inTime1){
        player1Time = inTime1;
    }
    public void setPlayer2Time(long inTime2){
        player2Time = inTime2;
    }

    public String getPlayer1Time(){
        player1TimeParse = String.valueOf(player1Time);

        return  player1TimeParse;
    }


    public String getPlayer2Time(){
        player2TimeParse = String.valueOf(player2Time);

        return player2TimeParse;
    }

}
