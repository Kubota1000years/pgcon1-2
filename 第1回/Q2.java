package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        for(int i = 0; i < 3; i++) {
            line += br.readLine();
        }
        String[] ox = line.split("");

        String turnPlayer = decidePlayerTurn(ox);

        if(completeLine(ox, "o")) {
            System.out.println("WIN");
            return;
        } else if(completeLine(ox, "x")) {
            System.out.println("LOSE");
            return;
        }

        if(decideFin(ox)) {
            System.out.println("FIN");
            return;
        }
        
        if(turnPlayer.equals("x")) {
            System.out.println("NG");
            return;
        } else if(turnPlayer.equals("o")) {
            for(int i = 0; i < 9; i++) {
                if(ox[i].equals("-")) {
                    ox[i] = turnPlayer;
                    if(completeLine(ox, turnPlayer)) {
                        System.out.println("OK");
                        return;
                    }
                	ox[i] = "-";
                }
            }
        }
        System.out.println("NO");

        br.close();
    }

	static String decidePlayerTurn(String[] ox) {
        int o = 0, x = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i].equals("o")) o++;
            else if(ox[i].equals("x")) x++;
        }

        return (o > x) ? "x" : "o";
    }

    static boolean decideFin(String[] ox) {
        int bar = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i].equals("-")) bar++;
        }

        return bar == 0 ? true : false;
    }

    static boolean completeLine(String[] ox, String turnPlayer) {
        return((ox[0].equals(turnPlayer) && ox[3].equals(turnPlayer) && ox[6].equals(turnPlayer)) || //縦一列
                (ox[1].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[7].equals(turnPlayer)) ||
                (ox[2].equals(turnPlayer) && ox[5].equals(turnPlayer) && ox[8].equals(turnPlayer)) ||
                (ox[0].equals(turnPlayer) && ox[1].equals(turnPlayer) && ox[2].equals(turnPlayer)) || //横一列
                (ox[3].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[5].equals(turnPlayer)) ||
                (ox[6].equals(turnPlayer) && ox[7].equals(turnPlayer) && ox[8].equals(turnPlayer)) ||
                (ox[0].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[8].equals(turnPlayer)) || //斜め一列
                (ox[2].equals(turnPlayer) && ox[4].equals(turnPlayer) && ox[6].equals(turnPlayer)))
                ? true : false;
    }
}
