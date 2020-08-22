import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created By xfj on 2020/8/22
 */
public class Main {
//    小美的一个兼职是美团的一名跑腿代购员，她有n个订单可以接，订单编号是1~n，但是因为订单的时效性，他只能选择其中m个订单接取，精明的小美当然希望自己总的获利是最大的，已知，一份订单会提供以下信息，跑腿价格v，商品重量w kg，商品每重1kg，代购费用要加2元，而一份订单可以赚到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。请问小美应该选择哪些订单，使得自己获得的钱最多。
//
//    请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案
//
//    5 2
//            5 10
//            8 9
//            1 4
//            7 9
//            6 10

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int n=Integer.parseInt(split[0]);
        int m=Integer.parseInt(split[1]);
        int[][] value=new int[n][2];

        for(int i=0;i<n;i++){
            String s1 = sc.nextLine();
            String[] split1 = s1.split(" ");
            value[i][0]=i+1;
            value[i][1]=Integer.parseInt(split1[0])+2*Integer.parseInt(split1[1]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> heap=new  PriorityQueue<int[]>((n1,n2)->{
            if(n2[1]-n1[1]!=0)
                return n2[1]-n1[1];
            else
                return n1[0]-n2[0];
        });
        for (int[] ints : value) {
            heap.add(ints);
        }
        for(int i=0;i<m;i++){
            int[] poll = heap.poll();
            result.add(poll[0]);
        }

        for(int i=0;i<result.size();i++){
            if(i!=result.size()-1)
                System.out.print(result.get(i)+" ");
            else
                System.out.print(result.get(i));
        }


    }
}
