import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    static final String CONVERT_TABLE = "A234567890JQK";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] card = line.split(" ");
        
        ArrayList<Integer> sList = new ArrayList<Integer>(); //スペードの数値のリスト
        ArrayList<Integer> dList = new ArrayList<Integer>(); //ダイアの数値のリスト
        ArrayList<Integer> cList = new ArrayList<Integer>(); //クラブの数値のリスト
        ArrayList<Integer> hList = new ArrayList<Integer>(); //ハートの数値のリスト

        for(int i = 0; i < card.length; i++) {
            char mark = card[i].charAt(0);
            char number = card[i].charAt(1);
            int convertNumber = convertCharNumberToInt(number);
            
            if(mark == 'S') sList.add(convertNumber);
            if(mark == 'D') dList.add(convertNumber);
            if(mark == 'C') cList.add(convertNumber);
            if(mark == 'H') hList.add(convertNumber);
        }

        Collections.sort(sList);
        Collections.sort(dList);
        Collections.sort(cList);
        Collections.sort(hList);

        printCardNumber(sList, 'S');
        printCardNumber(dList, 'D');
        printCardNumber(cList, 'C');
        printCardNumber(hList, 'H');
    }
    
    static int convertCharNumberToInt(char number) {
        for(int i = 1; i <= 13; i++) {
            if(CONVERT_TABLE.charAt(i - 1) == number) return i;
        }
        return 0;
    }

    static char convertIntNumberToChar(int number) {
        return CONVERT_TABLE.charAt(number - 1);
    }
    
    static void printCardNumber(List<Integer> markList, char mark) {
        if(markList.size() == 0) return;

        System.out.print(mark + ":");
        
        int number;
        char convertNumber;
        
        for(int i = 0; i < markList.size(); i++) {
            number = markList.get(i);
            convertNumber = convertIntNumberToChar(number);

            if(i == markList.size() - 1) {
                System.out.println(convertNumber);
            } else {
                System.out.print(convertNumber + ',');
            }
        }
    }
}
