import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String reverseLine = "";
    	for(int i = line.length(); i > 0; i--) {
    		reverseLine += line.substring(i - 1, i);
    	}
    	System.out.println(reverseLine);
        br.close();
    }
}