import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<String> rgbList = new ArrayList<String>();
        String rgb = "";
        String left = "";
        String right = "";
        String afterRgb = "";

        for(int i = 0; i < line.length(); i++) {
            rgb = line.substring(i, i + 1);
            if(rgbList.size() == 0) {
                rgbList.add(rgb);
                continue;
            }

            left = rgbList.get(0);
            right = rgbList.get(rgbList.size() - 1);

            if(rgbList.size() == 1) {
                if(rgb.equals(rgbList.get(0))) {
                    rgbList.remove(rgbList.size() - 1);
                } else {
                    rgbList.add(rgb);
                }
                continue;
            }

            if(left.equals(rgb)) {
                rgbList.remove(0);
            } else if(right.equals(rgb)) {
                rgbList.remove(rgbList.size() - 1);
            } else if(i == line.length() - 1)  {
                rgbList.add(rgb);
                continue;
            } else {
                afterRgb = line.substring(i + 1, i + 2);
                if(left.equals(afterRgb)) {
                    rgbList.add(rgb);
                } else if(right.equals(afterRgb)) {
                    rgbList.add(0, rgb);
                } else {
                    rgbList.add(rgb);
                }
            }
        }

        System.out.println(rgbList.size());
    }
}
