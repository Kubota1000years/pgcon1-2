import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        LinkedList<Character> rgbList = new LinkedList<Character>();
        char rgb;
        char left;
        char right;
        char afterRgb;

        for(int i = 0; i < line.length(); i++) {
            rgb = line.charAt(i);
            if(rgbList.size() == 0) {
                rgbList.addLast(rgb);
                continue;
            }

            left = rgbList.getFirst();
            right = rgbList.getLast();

            if(rgbList.size() == 1) {
                if(rgb == rgbList.get(0)) {
                    rgbList.removeFirst();
                } else {
                    rgbList.addLast(rgb);
                }
                continue;
            }

            if(left == rgb) {
                rgbList.removeFirst();
            } else if(right == rgb) {
                rgbList.removeLast();
            } else if(i == line.length() - 1)  {
                rgbList.addLast(rgb);
                continue;
            } else {
                afterRgb = line.charAt(i + 1);
                if(left == afterRgb) {
                    rgbList.addLast(rgb);
                } else if(right == afterRgb) {
                    rgbList.addFirst(rgb);
                } else {
                    rgbList.addLast(rgb);
                }
            }
        }

        System.out.println(rgbList.size());
    }
}
