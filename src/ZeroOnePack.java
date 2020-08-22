import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created By xfj on 2020/2/13
 */
public class ZeroOnePack {
    public int ZeroOnePack1(int[]val ,int[]weight,int v){
        int length = val.length+1;
        int[][] state=new int[length][v];
        //state[i][j]表示前i个物品装在容量j的最优解
        for(int i=1;i<length;i++)
            for(int j=1;j<v;j++){
                if(j-weight[i-1]<0){
                    state[i][j]=state[i-1][j];
                    continue;
                }
                //状态转移方程
                state[i][j]=Math.max(state[i-1][j],state[i-1][j-weight[i-1]]+val[i-1]);
            }
        return state[length-1][v-1];
    }

    public int ZeroOnePack2(int[]val ,int[]weight,int v){
        int length = val.length;
        int[] state=new int[v+1];
        //state[j]表示前i个物品装在容量j的最优解
        for(int i=0;i<length;i++)
            for(int j=v;j>=weight[i];j--){
                //状态转移方程
                state[j]=Math.max(state[j],state[j-weight[i]]+val[i]);
            }
        return state[v];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {2, 3, 3, 1}; //物品重量
        int[] val = {1,2,3,1}; //物品价值
        int m = 1; //背包容量
        ZeroOnePack zeroOnePack = new ZeroOnePack();
        int i = zeroOnePack.ZeroOnePack1(val, weight, m);
        System.out.println(i);
        HashSet<Integer> integerHsahSet = new HashSet<Integer>();
        for (Integer integer : integerHsahSet) {
            
        }
    }
}
