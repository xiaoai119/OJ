import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int e=array.length-1;
        //先查找是否是第一个元素
        while(array[0]==array[e]&&e>0){
            e--;
        }
        if(array[0]<=array[e])return array[0];
        return minNumberInRotateArray(array,0,array.length-1);
    }

    public int minNumberInRotateArray(int[] array, int s,int e ){
        //二分法查找
        if(s>e)return 0;
        //若仅有一元素，左大于右，返回右，否则返回0
        if(s==e&&s>0)return array[s-1]>=array[s]?array[s]:0;
        //若仅有一元素，且为a[0]
        if(s==e&&s==0)return array[0]<=array[array.length-1]?array[0]:0;
        //若有两元素
        if(e==s+1)return array[s]>array[e]?array[e]:minNumberInRotateArray(array,s,s);

        //若有多个元素，找到分割点
        int pivot=(s+e)/2;
        while(array[s]==array[pivot]&&pivot<e){
            pivot++;
        }
        //若没找到分割点，则查找前半部分数组
        if(pivot==e&&array[pivot]==array[s]){
            return minNumberInRotateArray(array,s,(s+e)/2-1);
        }

        //若中间数大，查找右边
        if(array[pivot]>array[s])
            return minNumberInRotateArray(array,pivot+1,e);
        //若中间数小，查找左边
        if(array[pivot]<array[s]){
            if(pivot==e)return array[s]<array[pivot]?array[s]:array[pivot];
            return minNumberInRotateArray(array,s,pivot);
        }
        return array[0];

    }

    public void test(int t){
        t++;
    }

    public static void main(String[] args) {
//        int[] ints = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int[] ints = {2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        Solution solution = new Solution();
        int i = solution.minNumberInRotateArray(ints);
        System.out.println(i);
        int t=0;
        List<Integer> integers = new ArrayList<>();
        solution.test(t);
        System.out.println(t);
    }
}