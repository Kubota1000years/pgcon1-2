package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ox = new char[9];
        for(int i = 0; i < 3; i++) {
            String line = br.readLine();
            ox[i * 3] = line.charAt(0);
            ox[i * 3 + 1] = line.charAt(1);
            ox[i * 3 + 2] = line.charAt(2);
        }

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
        int[][] idx = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                       {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                       {0, 4, 8}, {2, 4, 6}};

        for(int i = 0; i < 8; i++) {
            boolean isComplete = true;
            for(int j = 0; j < 3; j++) {
                isComplete &= (ox[idx[i][j]] == turnPlayer);
            }
            if (isComplete) return true;
        }
        return false;
    }
}
