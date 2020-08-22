/**
 * Created By xfj on 2020/2/10
 */
/**
 * 最小堆
 * @author dwl
 *
 */
public class MinHeap {
    //使用数组存储堆中的数据
    private int[] data;

    public MinHeap(int[] data ){
        this.data = data;
        bulidHeap();
    }

    /**
     * 建立最小堆
     */
    private void bulidHeap(){
        for(int i = (data.length)/2-1;i>=0;i--){//下标小于等于i的节点拥有子节点
            change(i);
        }

    }

    /**
     * 根据父节点判断是否
     * 与左右孩子交换
     * @param i
     */
    private void change(int i){

        int temp = 0;
        int left = left(i);
        int right = right(i);
        if(left>=data.length||right>data.length)return;

        //存在右节点则存在左节点
        if(right<data.length){
            //拿到左右孩子中小的下标
            temp = min(left, right);
            if(data[i]>data[temp]){
                swap(i, temp);
                //如果和子节点发生交换，则要对子节点的左右孩子进行调整
                change(temp);
            }
        }else if(right>=data.length){
            //不存在右节点但存在左节点，则左节点无孩子节点
            if(data[i]>data[left])
                swap(i, left);
            //孩子节点大于父节点，直接交换位置
        }

    }

    /**
     * 获取两个节点中较小的节点的下标
     * @param i
     * @param j
     * @return
     */
    private int min(int i,int j){
        if(data[i]>=data[j])
            return j;
        return i;
    }


    /**
     * 根据父节点下标获取
     * 左孩子节点下表
     * @param i
     * @return
     */
    private int left(int i){
        return ((i+1)<<1)-1;

    }

    /**
     * 根据父节点下表获取
     * 右孩子节点下标
     * @param i
     * @return
     */
    private int  right(int i){
        return (i+1)<<1;//左移1位相当于乘2

    }

    /**
     * 根据下标交换数组中的位置
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;

    }

    /**
     * 重置堆顶
     * @param root
     */
    public void newRoot(int root){
        data[0] = root;
        change(0);

    }

    /**
     * 获取堆顶
     * @return
     */
    public int getRoot(){
        return data[0];
    }

    /**
     * 获取堆数据
     * @return
     */
    public int[] getData(){
        return data;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {33,8,4,6,7,342,354,11,19,345,64,25,45,32,343,754};
        int[] data = {33,8,4,6,7,342,354,11,19};//取前7个数据建立最小堆
        MinHeap heap = new MinHeap(data);

        for(int i=7;i<num.length;i++){
            //循环与堆顶比较，大于于堆顶则重置堆顶
            if(num[i]>heap.getRoot()){
                heap.newRoot(num[i]);
            }
        }
        //循环输出前7个最大的数
        for(int n:heap.getData()){
            System.out.println(n);
        }

    }


}