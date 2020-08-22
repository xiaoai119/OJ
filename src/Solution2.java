import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created By xfj on 2020/8/20
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize;
        String str = sc.nextLine();
        arraySize = Integer.parseInt(str);
        List<String> collect = new ArrayList<String>();
        int[][] data = new int[arraySize][arraySize];
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            if(str.trim().isEmpty()&&!sc.hasNextLine()){break;}
            String[] split = str.split(" ");
            collect.addAll(Arrays.stream(split).filter(s -> !s.equals("")).collect(Collectors.toList()));
            if(collect.size()==arraySize*arraySize){break;}
        }
    }
}
