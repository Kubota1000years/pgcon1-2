import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = line.length() - 1; i >= 0; i--) {
            sb.append(line.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
