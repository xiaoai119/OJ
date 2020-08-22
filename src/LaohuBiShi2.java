/**
 * Created By xfj on 2020/8/9
 */
public class LaohuBiShi2 {
    /**
     * int，返回做完x个任务后能达到的最高等级
     * @param x int整型 需要完成的任务数量
     * @param level int整型 初始等级
     * @param tasks int整型二维数组 表示可供选择的任务，tasks[i][0]表示第i个任务所需的最低等级，task[i][1]表示第i个任务完成后能提升的等级
     * @return int整型
     */
    //这题是贪心，首先需要根据task[i][0]的值进行排序，选择当前能够提升到的最大等级。
    public int maxLevel (int x, int level, int[][] tasks) {
        if(tasks.length==0)return level;
        int[] flag=new int[tasks.length];
        // write code here
        //当前的等级
        int currentLevel=level;
        //当前已完成任务数量
        int currentTask=0;
        while(currentTask<x) {
            int[] max=new int[2];
            //找到task中能够达到的最大等级
            for(int i=0;i<tasks.length;i++){
                if(tasks[i][0]<=currentLevel&&flag[i]==0){
                    if(tasks[i][1]>max[0]){
                        max[0]=tasks[i][1];
                        max[1]=i;
                    }

                }
            }
            currentLevel+=max[0];
            flag[max[1]]=1;
            currentTask++;
        }
        return currentLevel;
    }

    public static void main(String[] args) {
        LaohuBiShi2 solution = new LaohuBiShi2();
        int i = solution.maxLevel(2, 1, new int[][]{{0, 1}, {1, 2}, {1, 3}});
        System.out.println(i);
    }
}