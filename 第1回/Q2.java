package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
    	char[] ox = new char[9];
        for(int i = 0; i < 3; i++) {
            line = br.readLine();
        	char[i*3] = line.substring(0, 1);
        	char[i*3+1] = line.substring(1, 2);
        	char[i*3+2] = line.substring(2, 3);
        }
        br.close();

        if(isLineCompleted(ox, "o")) {
            System.out.println("WIN");
            return;
        } else if(isLineCompleted(ox, "x")) {
            System.out.println("LOSE");
            return;
        }

        if(isFinish(ox)) {
            System.out.println("FIN");
            return;
        }
        
        String turnPlayer = decidePlayerTurn(ox);
        
        if(turnPlayer.equals("x")) {
            System.out.println("NG");
            return;
        } else {
            for(int i = 0; i < 9; i++) {
                if(ox[i].equals("-")) {
                    ox[i] = turnPlayer;
                    if(isLineCompleted(ox, turnPlayer)) {
                        System.out.println("OK");
                        return;
                    }
                    ox[i] = "-";
                }
            }
        }
        System.out.println("NO");

        
    }

    static String decidePlayerTurn(String[] ox) {
        int o = 0, x = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i].equals("o")) o++;
            else if(ox[i].equals("x")) x++;
        }

        return (o > x) ? "x" : "o";
    }

    static boolean isFinish(String[] ox) {
        int bar = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i].equals("-")) bar++;
        }

        return bar == 0;
    }

    static boolean isLineCompleted(String[] ox, String turnPlayer) {
        return((ox[0].equals(turnPlayer) && ox[3].equals(turnPlayer) && ox[6].equals(turnPlayer)) || //縦一列
                (ox[1].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[7].equals(turnPlayer)) ||
                (ox[2].equals(turnPlayer) && ox[5].equals(turnPlayer) && ox[8].equals(turnPlayer)) ||
                (ox[0].equals(turnPlayer) && ox[1].equals(turnPlayer) && ox[2].equals(turnPlayer)) || //横一列
                (ox[3].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[5].equals(turnPlayer)) ||
                (ox[6].equals(turnPlayer) && ox[7].equals(turnPlayer) && ox[8].equals(turnPlayer)) ||
                (ox[0].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[8].equals(turnPlayer)) || //斜め一列
                (ox[2].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[6].equals(turnPlayer)));
    }
}
