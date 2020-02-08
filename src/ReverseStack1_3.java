import java.util.Stack;

/**
 * Created By xfj on 2020/1/25
 * 仅用递归函数逆序一个栈
 */
public class ReverseStack1_3 {
    public static Integer getLast(Stack<Integer> stack){
        //返回栈底元素
        Integer pop = stack.pop();
        if(stack.empty()){
            return pop;
        }else {
            Integer last = getLast(stack);
            stack.push(pop);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
            Integer pop = stack.pop();
            reverse(stack);
            stack.push(pop);
        }

    }

    public static void main(String[] args) {
        Stack<Integer> intSatck = new Stack<>();
        intSatck.push(1);
        intSatck.push(2);
        intSatck.push(3);
        intSatck.push(4);
        intSatck.push(5);
        reverse(intSatck);
        while (!intSatck.isEmpty()){
            System.out.println(intSatck.pop());
        }
    }
}

