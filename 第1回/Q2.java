package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "", lineValue = "";
        for(int i = 0; i < 3; i++) {
            line = br.readLine();
            lineValue += line;
        }
        char[] ox = lineValue.toCharArray();
        br.close();

        if(isLineCompleted(ox, 'o')) {
            System.out.println("WIN");
            return;
        } else if(isLineCompleted(ox, 'x')) {
            System.out.println("LOSE");
            return;
        }

        if(isFinished(ox)) {
            System.out.println("FIN");
            return;
        }
        
        char turnPlayer = decidePlayerTurn(ox);
        
        if(turnPlayer == 'x') {
            System.out.println("NG");
            return;
        } else {
            for(int i = 0; i < 9; i++) {
                if(ox[i] == '-') {
                    ox[i] = turnPlayer;
                    if(isLineCompleted(ox, turnPlayer)) {
                        System.out.println("OK");
                        return;
                    }
                    ox[i] = '-';
                }
            }
        }
        System.out.println("NO");

        
    }

    static char decidePlayerTurn(char[] ox) {
        int o = 0, x = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i] == 'o') o++;
            else if(ox[i] == 'x') x++;
        }

        return (o > x) ? 'x' : 'o';
    }

    static boolean isFinished(char[] ox) {
        int bar = 0;
        for(int i = 0; i < 9; i++) {
            if(ox[i] == '-') bar++;
        }

        return bar == 0;
    }

    static boolean isLineCompleted(char[] ox, char turnPlayer) {
        return((ox[0] == turnPlayer && ox[3] == turnPlayer && ox[6] == turnPlayer) || //縦一列
                (ox[1] == turnPlayer && ox[4] == turnPlayer && ox[7] == turnPlayer) ||
                (ox[2] == turnPlayer && ox[5] == turnPlayer && ox[8] == turnPlayer) ||
                (ox[0] == turnPlayer && ox[1] == turnPlayer && ox[2] == turnPlayer) || //横一列
                (ox[3] == turnPlayer && ox[4] == turnPlayer && ox[5] == turnPlayer) ||
                (ox[6] == turnPlayer && ox[7] == turnPlayer && ox[8] == turnPlayer) ||
                (ox[0] == turnPlayer && ox[4] == turnPlayer && ox[8] == turnPlayer) || //斜め一列
                (ox[2] == turnPlayer && ox[4] == turnPlayer && ox[6] == turnPlayer));
    }
}
