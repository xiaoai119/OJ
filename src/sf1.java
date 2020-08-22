import java.util.*;

/**
 * Created By xfj on 2020/8/20
 */
public class sf1 {
//    输入第一行包含两个数n,m
//
//    接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小。
//
//    接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
//
//    n,m≤1000 , 1≤ai,bi,ci≤1000

//    3 4
//            1 2 3
//            2 1
//            3 2
//            3 3
//            1 1


    public static void main(String[] args) {
//        Collections.sort(new ArrayList<Integer>(), new Comparator<Integer>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.compareTo(o2) < 0 ){
//                    return -1;
//                }else if(o1.compareTo(o2) == 0){
//                    return 0;
//                }else{
//                    return 1;
//                }
//            }
//        });

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split0 = s.split(" ");//第一个是n，服务器个数，第二个是m，客户个数
        int n=Integer.parseInt(split0[0]);
        int m=Integer.parseInt(split0[1]);

        int[] v = new int[n];
        int[] flag=new int[m];
        int[] val=new int[m];
        int[] weight=new int[m];

        Arrays.sort(v);
        String s1 = sc.nextLine();
        String[] split1 = s1.split(" ");//服务器带宽
        for(int i=0;i<n;i++){
            v[i]=Integer.parseInt(split1[i]);
        }

        for(int i=0;i<m;i++){
            String s2 = sc.nextLine();
            String[] split = s2.split(" ");
            weight[i]=Integer.parseInt(split[0]);
            val[i]=Integer.parseInt(split[1]);
        }

        //背包从小到大贪心计算
        int result=0;
        sf1 main = new sf1();
        for (int i : v) {
            result+=main.ZeroOnePack2(val,weight,i,flag);
        }
        System.out.println(result);

    }


    public int ZeroOnePack2(int[]val ,int[]weight,int v,int[] flag){
        int length = val.length;
        int[] state=new int[v+1];
        //state[j]表示前i个物品装在容量j的最优解
        for(int i=0;i<length;i++)
            for(int j=v;j>=weight[i];j--){
                //状态转移方程
                if(flag[i]==1)continue;
                if(state[j]>state[j-weight[i]]+val[i])
                    state[j]=state[j];
                else{
                    state[j]=state[j-weight[i]]+val[i];
                    flag[i]=1;
                }
            }
        return state[v];
    }
}
