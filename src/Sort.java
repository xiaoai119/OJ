
import java.util.Arrays;

/**
 * Created By xfj on 2020/1/28
 * 冒泡，快排，归并
 *
 */
public class Sort {
    public static int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }

//        首先将数组分为两部分
        int[] a1 = new int[array.length / 2];
        int[] a2 = new int[array.length / 2 + array.length % 2];
        int i = -1;
        while (++i < array.length) {
            if (i < array.length / 2) {
                a1[i] = array[i];
            } else {
                a2[i-array.length/2] = array[i];
            }
        }

        //递归两个归并
        int[] sort1 = sort(a1);
        int[] sort2 = sort(a2);

        //合并两个数组
        int p1 = 0;
        int p2 = 0;

        int[] result = new int[sort1.length + sort2.length];

        while (p1 <sort1.length || p2 < sort2.length) {
            if (p1 < sort1.length && p2 < sort2.length) {
                result[p1 + p2] = sort1[p1] <= sort2[p2] ? sort1[p1] : sort2[p2];
                //移动指针
                if (sort1[p1] < sort2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            } else if (p1 ==sort1.length) {
                result[p1 + p2] = sort2[p2];
                p2++;
            } else if (p2 ==sort2.length) {
                result[p1 + p2] = sort1[p1];
                p1++;
            }
        }

        return result;
    }


    public static int[] mergeSort(int[] array,int low ,int high){
        if(low==high){
            return array;
        }
        int mid= (low+high)/2;

        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);

        merge(array ,low ,high);
        return array;

    }

    public static void merge(int[]array, int low,int high){
        int[] temp = new int[high-low+1];
        int tempIndex=0;
        //temp 0 .. high-low
        int mid =(low+high)/2;
        int p1=low;
        int p2=mid+1;

        while(p1<=mid&&p2<=high){
            if(array[p1]<=array[p2]){
                temp[tempIndex++]=array[p1++];
            }else {
                temp[tempIndex++]=array[p2++];
            }
        }

        while(p1<=mid){
            temp[tempIndex++]=array[p1++];
        }
        while(p2<=high){
            temp[tempIndex++]=array[p2++];
        }

        for(int i=0;i<temp.length;i++){
            array[low+i]=temp[i];
        }

    }

    private static void bubleSort(int[] a) {
        int l=a.length;
        for(int i=0;i<l;i++)
            for(int j=0;j<l-i-1;j++){
                if(a[j]>a[j+1]){
                    //swap
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
    }

    public static void QuickSort(int[] array, int low, int high){
        //获取桩下标
        if(low>=high){
            return ;
        }
        int pivot = getPivot(array, low, high);
        QuickSort(array,low,pivot);
        QuickSort(array,pivot+1,high);
    }

    public static void QuickSort(int[] array){
        QuickSort(array,0,array.length-1);
    }

    public static int getPivot(int[] array, int low ,int high){
        int keyOfPivot = array[low];
        while(low<high){
            //从后往前查询小于pivot的数，若存在，交换位置
            while(array[high]>=keyOfPivot&&low<high){
                high--;
            }
            //交换key与array[high]
            // TODO: 2020/1/28
            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;

            while(array[low]<=keyOfPivot&&low<high){
                low++;
            }
            // TODO: 2020/1/28

            temp=array[high];
            array[high]=array[low];
            array[low]=temp;
        }

        return high;
    }


    public static boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }

            boolean matchFirst=(!s.isEmpty()&&s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');


        if(p.length()>=2&&s.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||(matchFirst&&isMatch(s.substring(1),p));
        }else{
            return matchFirst&&isMatch(s.substring(1),p.substring(1));
        }
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,1,5,4,3,5,1,2,6,1};

        String s = "awd";
        String substring1 = s.substring(9);
        String substring = s.substring(1, 2);
        QuickSort(a);
        System.out.println(isMatch("ss",".s"));
//        int[] sorted = sort2(a,0,a.length-1);
        System.out.println();
    }


}
