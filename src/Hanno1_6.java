/**
 * Created By xfj on 2020/1/26
 */
public class Hanno1_6 {
    public void hano(int num){
        //若不是最后一片，则先整体右移
        if(num>1){
            hano(num-1);
        }
        //将最后1片移至中间
        System.out.println("move"+num);
        //若最右存在，则整体左移
    }
}
