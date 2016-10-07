import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//未完成です

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int escIndex = 0, nextIndex = 0;
        String command = "";
        int hCursol = 0, wCursol = 0;
        String[] escape_sequence = new String[N];
        String[][] screen = new String[25][80];
        screen = command1_clear(screen);

        for(int i = 0; i < N; i++) {
            line = br.readLine();
            escIndex = 0;
            while((escIndex = line.indexOf("<ESC>", escIndex)) != -1) {
                nextIndex = line.indexOf("<ESC>", escIndex + 1);
                if(nextIndex == -1) break;

                command = line.substring(escIndex + 5, nextIndex);
                if(command.startsWith("[2J")) {
                    command1_clear(screen);
                    hCursol = 0;
                    wCursol = 0;
                } else if(command.contains(";")) {
                    hCursol = command2_moveHCursor(command);
                    wCursol = command2_moveWCursor(command);
                    screen = command2_printValue(screen, hCursol, wCursol, escIndex, nextIndex, command);
                } else if(command.equals("[nB")) {
                    hCursol = command3_moveDown(command, hCursol);
                } else if(command.equals("[nD")) {
                    wCursol = command4_moveLeft(command, wCursol);
                } else if(command.equals("[nC")) {
                    hCursol = command5_moveUp(command, hCursol);
                } else if(command.equals("[nA")) {
                    wCursol = command6_moveRight(command, wCursol);
                }
                escIndex++;
                nextIndex++;
            }
        }

        for(int i = 0; i < 25; i++) {
            for(int j = 0; j < 80; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }

        br.close();
    }

    static String[][] command1_clear(String[][] screen) {
        for(int i = 0; i < 25; i++) {
            for(int j = 0; j < 80; j++) {
                screen[i][j] = " ";
            }
        }
        return screen;
    }

    static int command2_moveHCursor(String command) {
        int hCursol = 0;
        try {
            hCursol = Integer.parseInt(command.substring(1, 2));
        } catch(Exception e) {
            return hCursol;
        }
        return hCursol;
    }

    static int command2_moveWCursor(String command) {
        int wCursol = 0;
        try {
            wCursol = Integer.parseInt(command.substring(3, 4));
            wCursol = Integer.parseInt(command.substring(3, 5));
        } catch(NumberFormatException e) {
            return wCursol;
        }
        return wCursol;
    }

    static String[][] command2_printValue(String[][] screen, int hCursol, int wCursol,
        int escIndex, int nextIndex, String command) {
        String value = "";
        int h = hCursol / 10 + 1;
        int w = wCursol / 10 + 1;
        for(int i = 0; i < nextIndex - escIndex - h - w - 1; i++) {
            value = command.substring(i + h + w + 2, i + h + w + 3);
            screen[hCursol][wCursol] = value;
        }
        return screen;
    }

    static int command3_moveDown(String command, int hCursol) {
        int moveNum = Integer.parseInt(command.substring(1, 2));
        return hCursol + moveNum;
    }

    static int command4_moveLeft(String command, int wCursol) {
        int moveNum = Integer.parseInt(command.substring(1, 2));
        return wCursol + moveNum;
    }


    static int command5_moveUp(String command, int hCursol) {
        int moveNum = Integer.parseInt(command.substring(1, 2));
        return hCursol - moveNum;
    }

    static int command6_moveRight(String command, int wCursol) {
        int moveNum = Integer.parseInt(command.substring(1, 2));
        return wCursol - moveNum;
    }

}
