import java.util.Scanner;

/**
 * Created By xfj on 2020/8/22
 */
public class Main {
//    小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
//
//    已知货物最初是按1~n的顺序堆放的，每件货物的重量为w_i,小美会根据单据依次不放回的取出货物。请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n=Integer.parseInt(s);
        //n表示有n堆货物
        //取出货物可以将值记为-1，那么每取出一次货物，均需遍历一次数组
        int[] goods = new int[n];
        String s1 = sc.nextLine();
        String[] split = s1.split(" ");
        for(int i=0;i<split.length;i++){
            goods[i]=Integer.parseInt(split[i]);
        }

        int[] takes = new int[n];

        String s2 = sc.nextLine();
        String[] split2 = s2.split(" ");
        for(int i=0;i<split.length;i++){
            takes[i]=Integer.parseInt(split2[i]);
        }

        int max=0;
        for (int take : takes) {
            int temp=0;
            goods[take-1]=-1;
//            for(int i=take-1;dp)
            for (int good : goods) {
                if(good!=-1){
                    temp+=good;
                    max=max>temp?max:temp;
                }else{
                    temp=0;
                }
            }
            System.out.println(max);
            max=0;
        }
    }
}
