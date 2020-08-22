import java.util.Scanner;

/**
 * Created By xfj on 2020/8/20
 */
public class sf2 {
    int result=0;
    public static void main(String[] args) {
        int maxcol=0;
        Scanner sc = new Scanner(System.in);
        int taskNum = Integer.parseInt(sc.nextLine());
        if(taskNum==0){
            System.out.println(0);
            return;
        }
        int[][]tasks=new int[taskNum][3];
        for(int i=0;i<taskNum;i++){
            String[] split = sc.nextLine().split(" ");
            for (int j=0;j<3;j++) {
                tasks[i][j]=Integer.parseInt(split[j]);
            }
           maxcol=maxcol>tasks[i][1]?maxcol:tasks[i][1];
        }
        //接下来可以用dp
        int[] dp=new int[maxcol+1];
        sf2 sf2 = new sf2();
        for (int[] task : tasks) {
            sf2.calcu(dp,task);
        }
        System.out.println(sf2.result);
    }


    public void calcu(int[] dp,int[]task){
        //0起始，1结束，2最大值
        //找开始时间之前的最大值
        int max = findMax(dp, task[0]-1);
        int newmax=max+task[2];
        //新的最大值向后更新
        for(int i=task[1];i<dp.length;i++){
            if(dp[i]<newmax)dp[i]=newmax;
            else break;
        }
        result=result>newmax?result:newmax;
    }

    public int findMax(int[]dp,int start){
        for(int i=start;i>=0;i--){
            if(dp[i]!=0)return dp[i];
        }
        return 0;
    }
}
