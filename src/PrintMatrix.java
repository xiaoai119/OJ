import java.util.ArrayList;

/**
 * Created By xfj on 2020/1/29
 * 按顺时针打印一个二维数组，搜索
 */
public class PrintMatrix {
    //搜索问题，若节点已访问，则记为1
    //第一个方向向右
    //可能的方向：若原方向不变，则按照原方向。若变，每次只能向可能的方向前进
    int[][] flag;
    final int up=0;
    final int down=1;
    final int left=2;
    final int right=3;
    //当前位置坐标
    int x;
    int y;
    ArrayList<Integer> list=new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        //初始化flag
        flag=new int[matrix.length][matrix[0].length];
        for(int i=0;i<flag.length;i++){
            for(int j=0;j<flag[i].length;j++){
                flag[i][j]=0;
            }
        }
        move(0,-1,right,matrix);
        return list;
    }

    public boolean canMove(int x, int y,int target){
        int lengthx=flag.length;
        int lengthy=flag[0].length;
        if(x<0||y<0||x==lengthx||y==lengthy){
            return false;
        }
        switch(target){
            case right:
                if(y==lengthy-1||flag[x][y+1]==1)
                    return false;
                break;
            case left:
                if(y==0||flag[x][y-1]==1)
                    return false;
                break;
            case up:
                if(x==0||flag[x-1][y]==1)
                    return false;
                break;
            case down:
                if(x==lengthx-1||flag[x+1][y]==1)
                    return false;
                break;
        }
        return true;
    }

    public void move(int x,int y,int target,int[][] matrix){
        //根据target改变x，y
        switch(target){
            case right:
                y=y+1;
                System.out.print(matrix[x][y]);
                list.add(matrix[x][y]);
                flag[x][y]=1;
                if(canMove(x,y,right)){move(x,y,right,matrix);return;}
                if(canMove(x,y,up)){move(x,y,up,matrix);return;}
                if(canMove(x,y,down)){move(x,y,down,matrix);return;}
                break;
            case left:
                y=y-1;
                System.out.print(matrix[x][y]);
                list.add(matrix[x][y]);
                flag[x][y]=1;
                if(canMove(x,y,left)){move(x,y,left,matrix);return;}
                if(canMove(x,y,up)){move(x,y,up,matrix);return;}
                if(canMove(x,y,down)){move(x,y,down,matrix);return;}
                break;
            case up:
                x=x-1;
                System.out.print(matrix[x][y]);
                list.add(matrix[x][y]);
                flag[x][y]=1;
                if(canMove(x,y,up)){move(x,y,up,matrix);return;}
                if(canMove(x,y,right)){move(x,y,right,matrix);return;}
                if(canMove(x,y,left)){move(x,y,left,matrix);return;}
                break;
            case down:
                x=x+1;
                System.out.print(matrix[x][y]);
                list.add(matrix[x][y]);
                flag[x][y]=1;
                if(canMove(x,y,down)){move(x,y,down,matrix);return;}
                if(canMove(x,y,right)){move(x,y,right,matrix);return;}
                if(canMove(x,y,left)){move(x,y,left,matrix);return;}
                break;
        }
    }

    public static void main(String[] args) {
        int[][] pushA=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        new PrintMatrix().printMatrix(pushA);
        System.out.println();
    }
}
