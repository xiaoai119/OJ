import java.util.HashSet;
import java.util.Stack;

/**
 * Created By xfj on 2020/1/29\
 * 给定一个指定的入栈顺序，可能有哪些出栈顺序？
 */
public class OrderOfPop {
    static final int POP=0;
    static final int PUSH=1;

    //数组的指针
    int index=0;
    HashSet<Integer> statusSet =new HashSet<Integer>();

    public void getOrder(int[] array){
        getOrder(array,0,0);
        statusSet.forEach(integer ->{
            System.out.println(integer);
        } );

    }
    public void getOrder(int[]array,int index,int status){
        //结束条件，返回
        if(!canPush(array,index)&&!canPop(status)){
            statusSet.add(status);
        }
        //如果可以Push，继续搜索
        if(canPush(array,index)){
            status=status*10+1;
            index++;
            getOrder(array,index,status);
        }
        //如果可以Pop，继续搜索
        if(canPop(status)){
            status=status*10;
            getOrder(array,index,status);
        }
    }

    public boolean canPush(int[]array,int index){
        return index<array.length;
    }

    public boolean canPop(int status){
        //判断status中01个数，若1多返回true
        int num1=0;
        int num0=0;
        //status为非0
        while (status/10!=0){
            num1=status%2==1?num1+1:num1;
            num0=status%2==0?num0+1:num0;
            status=status/10;
        }
            num1=status%2==1?num1+1:num1;
            num0=status%2==0?num0+1:num0;
            return num1>num0;
    }

    public static void main(String[] args) {
        int[] num =new int[]{1,2,3,4,5};
        OrderOfPop orderOfPop = new OrderOfPop();
        orderOfPop.getOrder(num);
    }


}
