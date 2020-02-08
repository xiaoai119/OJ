import java.util.HashSet;

/**
 * Created By xfj on 2020/1/29
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 */
public class JumpFrog {
    public int JumpFloorII(int target) {
        if(target==1)return 1;
        int result=0;
        for(int i=1;i<target+1;i++)
            result+=JumpFloorII(i);
        return result+1;
    }

    public static void main(String[] args) {
        JumpFrog jumpFrog = new JumpFrog();
        System.out.println(jumpFrog.JumpFloorII(2));
    }
}
