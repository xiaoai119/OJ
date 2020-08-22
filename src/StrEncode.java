import java.io.IOException;

/**
 * Created By xfj on 2020/2/8
 */
public class StrEncode {
    public static void main(String[] args) throws IOException {
        String str="ab你好cd谢谢";
        int len =str.getBytes("gbk").length;
        for(int i=0;i<len;i++) {
            System.out.println("GBK截取"+(i+1)+"个字节结果是："+cutStringByBytes(str,i+1));
        }

        len =str.getBytes("UTF-8").length;
        for(int i=0;i<len;i++) {
            System.out.println("UTF截取"+(i+1)+"个字节结果是："+cutStringByUTFBytes(str,i+1));
        }
    }

    /**
     * 思想：UTF-8编码，中文是三个字节表示，英文是一个字节
     * 并且中文字中有第一个字节码是小于零的
     * 97,98,-28,-67,-96,-27,-91,-67,99,100,-24,-80,-94,-24,-80,-94
     * 根据截取位置向前计数，查看计数除3取余，为零：不舍，为1：舍1位，为21：舍2位
     * @param str
     * @param len
     * @return
     * @throws IOException
     */
    private static String cutStringByUTFBytes(String str, int len) throws IOException {
        byte[] buf=str.getBytes("UTF-8");
        int count=0;
        for(int i=len-1;i>=0;i--) {
            if(buf[i]<0)
                count++;
            else {
                break;
            }
        }
        if(count%3==0)
            return new String(buf,0,len,"UTF-8");
        else if(count%3==1)
            return new String(buf,0,len-1,"UTF-8");
        else
            return new String(buf,0,len-2,"UTF-8");

    }

    /**
     * 思想：gbk编码，中文是两个字节表示，英文是一个字节
     * 并且中文字中有第一个字节码是小于零的
     * 97,98,-60,-29,-70,-61,99,100,-48,-69,-48,-69
     * 根据截取位置向前计数，查看计数的奇偶数，奇数舍弃，偶数保留
     * @param str
     * @param len
     * @return
     * @throws IOException
     */
    private static String cutStringByBytes(String str, int len) throws IOException {
        byte[] buf=str.getBytes("gbk");
        int count=0;
        for(int i=len-1;i>=0;i--) {
            if(buf[i]<0)
                count++;
            else {
                break;
            }
        }
        if(count%2==0)
            return new String(buf,0,len,"gbk");
        else
            return new String(buf,0,len-1,"gbk");
    }
}
