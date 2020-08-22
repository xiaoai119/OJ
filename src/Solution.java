/**
 * Created By xfj on 2020/8/9
 */
public class Solution {
    /**
     * 返回最少需要多少辆车
     * @param trips int整型二维数组 二维int数组，用于表示一组乘客的行程信息，其中`trip[i]`表示第i组乘客，`trip[i][0]`表示第i组乘客的乘客数量，`trip[i][1]`表示上车站点，`trip[i][2]`表示下车站点。
     * @param capacity int整型 int类型，表示每辆车最多能承载多少名乘客
     * @return int整型
     */
    public int minCarCount (int[][] trips, int capacity) {
        // write code here
        //一个数组记录上站人数，一个数组记录下站人数
        int[] up=new int[1000];
        int[] down=new int[1000];
        //遍历trips
        for(int i=0;i<trips.length;i++){
            up[trips[i][1]]+=trips[i][0];
            down[trips[i][2]]+=trips[i][0];
        }
        //计算最多同时在路上的乘客
        int current=0;
        double max=0;
        for(int i=0;i<1000;i++){
            current+=up[i];
            current-=down[i];
            max=max>current?max:current;
        }

        return (int) Math.ceil(max/capacity);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minCarCount(new int[][]{{2, 1, 4}, {4, 2, 6}}, 5);
        System.out.println(i);
    }
}