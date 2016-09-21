package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int bookCount = Integer.parseInt(line); //巻数

        line = br.readLine();
        String[] myBookList = line.split(" ");   //持っている巻のリスト

        line = br.readLine();
        String[] soldBookList = line.split(" "); //売られている巻のリスト
        
        br.close();

        boolean[] hasBookList = new boolean[bookCount]; //持っている巻はTrue

        for(int i = 0; i < myBookList.length; i++) {
            int myBook = Integer.parseInt(myBookList[i]);
            if(myBook > bookCount || myBook == 0) continue;
            hasBookList[myBook-1] = true;
        }

        ArrayList<Integer> outputBookList = new ArrayList<Integer>(); //出力する巻のリスト
        
        //持っていなくて売られている巻をリスト化
        for(int i = 0; i < soldBookList.length; i++) {
            int soldBook = Integer.parseInt(soldBookList[i]);
            if(soldBook > bookCount || soldBook == 0) continue;
            if(hasBookList[soldBook-1] == false) {
                outputBookList.add(soldBook);
            }
        }

        //出力する巻をソート
        Collections.sort(outputBookList);

        String outputBook = "";
        if(outputBookList.size() != 0) {
            for(int i = 0; i < outputBookList.size(); i++) {
                outputBook += outputBookList.get(i);
                if(i != outputBookList.size() - 1) outputBook += " ";
            }
        } else {
            System.out.println("None");
        }
    }
}
