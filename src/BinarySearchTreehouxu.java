import java.util.ArrayList;
import java.util.Stack;

/**
 * Created By xfj on 2020/2/11
 */
public class BinarySearchTreehouxu {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySquenceOfBST(int[] seq ,int s ,int e){
        if(s>e)System.out.println("error");
        if(s==e)return true;
        //若仅有两元素
        if(s+1==e)return seq[s]<seq[e];
        //若至少三元素
        int root=seq[e];
        int pivot=s;
        while(seq[pivot]<root&&pivot<e){
            pivot++;
        }
        if(pivot==e)return VerifySquenceOfBST(seq,s,pivot-1)&&VerifySquenceOfBST(seq,pivot-1,e-1);
        return VerifySquenceOfBST(seq,s,pivot-1)&&VerifySquenceOfBST(seq,pivot,e-1);

    }
    public static void main(String[] args) {
        BinarySearchTreehouxu binarySearchTreehouxu = new BinarySearchTreehouxu();
//        System.out.println(binarySearchTreehouxu.VerifySquenceOfBST(new int[]{5,4,3,2,1} ));
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(1);
        integers.push(2);
        integers.push(3);
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.addAll(integers);
        System.out.println(integers1);
    }
}
