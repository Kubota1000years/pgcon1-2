import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] card = line.split(" ");
        int[] spead = new int[card.length];
        int[] dia   = new int[card.length];
        int[] club  = new int[card.length];
        int[] heart = new int[card.length];
        int s = 0, d = 0, c = 0, h = 0;
        
        for(int i = 0; i < card.length; i++) {
            String mark   = card[i].substring(0, 1);
            String number = card[i].substring(1, 2);
            int convertNumber = 0;
            
            if(number.equals("A")) {
                convertNumber = 1;
            } else if(number.equals("0")) {
                convertNumber = 10;
            } else if(number.equals("J")) {
                convertNumber = 11;
            } else if(number.equals("Q")) {
                convertNumber = 12;
            } else if(number.equals("K")) {
                convertNumber = 13;
            } else {
                convertNumber = Integer.parseInt(number);
            }

            if(mark.equals("S")) spead[s++] = convertNumber;
            if(mark.equals("D")) dia[d++]   = convertNumber;
            if(mark.equals("C")) club[c++]  = convertNumber;
            if(mark.equals("H")) heart[h++] = convertNumber;
        }
        Arrays.sort(spead);
        Arrays.sort(dia);
        Arrays.sort(club);
        Arrays.sort(heart);

        printCardNumber(spead, s, "S");
        printCardNumber(dia, d, "D");
        printCardNumber(club, c, "C");
        printCardNumber(heart, h, "H");
        
        br.close();
    }
    
    static void printCardNumber(int[] markArray, int markCount, String mark) {
        if(markCount == 0) return;
        
        int number = 0;
        String outputNumber = "";
        System.out.print(mark + ":");
        for(int i = 0; i < markArray.length; i++) {
            number = markArray[i];
            if(number == 0) {
                continue;
            } else if(number == 1) {
                outputNumber = "A";
            } else if(number == 10) {
                outputNumber = "0";
            } else if(number == 11) {
                outputNumber = "J";
            } else if(number == 12) {
                outputNumber = "Q";
            } else if(number == 13) {
                outputNumber = "K";
            } else {
                outputNumber = String.valueOf(number);
            }

            if(i == markArray.length - 1) {
                System.out.println(outputNumber);
            } else {
                System.out.print(outputNumber + ",");
            }
        }
    }
}