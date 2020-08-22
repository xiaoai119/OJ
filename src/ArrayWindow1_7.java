import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By xfj on 2020/1/26
 * 双端队列，滑动窗
 */
public class ArrayWindow1_7 {
    public void getMaxByWindow(int[] array ,int window){
        LinkedList<Object> l = new LinkedList<>();
       //若队列为空直接入队
        int index=0;
        while(index<array.length){
            if(l.isEmpty()){
        //直接入队
            l.push(array[index]);
            index++;
            }else{
                //若不为空
//                if(array[index] >= l.peekLast()){
//
//                }
            }

        }


    }


}
