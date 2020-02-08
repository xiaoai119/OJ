import java.util.Stack;

/**
 * Created By xfj on 2020/2/8
 */
public class RobotMovingCount {
    //搜索
    //使用栈记录轨迹
    Stack<Position> stack;
    //定义方向
    static final int UP=0;
    static final int DOWN=1;
    static final int LEFT=2;
    static final int RIGHT=3;
    //记录状态
    int[][] flag;
    //一些成员变量
    int rows;
    int cols;
    int thre;
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0)return 0;
        stack=new Stack<Position>();
        flag=new int[rows][cols];
        flag[0][0]=1;
        stack.push(new Position(0,0));
        this.rows=rows;
        this.cols=cols;
        this.thre=threshold;

        Position p=new Position(0,0);
        if(canMove(p,RIGHT))move(RIGHT);
        if(canMove(p,DOWN))move(DOWN);
        int sum=0;
        //统计到达格子
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(flag[i][j]==1)
                    sum++;

        return sum;
    }

    public boolean canMove(Position p,int direct){
        switch(direct){
            case UP:{
                if(p.x<=0||calcuSum(p.x-1,p.y)>thre||flag[p.x-1][p.y]==1)return false;
                return true;
            }
            case DOWN:{
                if(p.x>=rows-1||calcuSum(p.x+1,p.y)>thre||flag[p.x+1][p.y]==1)return false;
                return true;
            }
            case LEFT:{
                if(p.y<=0||calcuSum(p.x,p.y-1)>thre||flag[p.x][p.y-1]==1)return false;
                return true;
            }
            case RIGHT:{
                if(p.y>=cols-1||calcuSum(p.x,p.y+1)>thre||flag[p.x][p.y+1]==1)return false;
                return true;
            }
        }
        return false;
    }

    public void move(int direct){
        if(stack.isEmpty())return;
        Position p=stack.pop();
        flag[p.x][p.y]=1;
        System.out.println(p.x+","+p.y);
        Position newp=null;

        if(canMove(p,UP)){
            newp= new Position(p.x-1,p.y);
            stack.push(newp);
            move(UP);
        }
        if(canMove(p,DOWN)){
            newp= new Position(p.x+1,p.y);
            stack.push(newp);
            move(DOWN);
        }
        if(canMove(p,LEFT)){
            newp= new Position(p.x,p.y-1);
            stack.push(newp);
            move(LEFT);
        }
        if(canMove(p,RIGHT)){
            newp= new Position(p.x,p.y+1);
            stack.push(newp);
            move(RIGHT);
        }

    }

    public int calcuSum(int x,int y){
        int sum=0;
        int temp=0;
        while(x>0){
            temp=x%10;
            x/=10;
            sum+=temp;
        }
        while(y>0){
            temp=y%10;
            y/=10;
            sum+=temp;
        }
        return sum;
    }

    public class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x=x;
            this.y=y;
        }
    }


    public int movingCount1(int threshold, int rows, int cols)
    {
        boolean[][] help = new boolean[rows][cols];
        return DFS(help,0,0,rows,cols,threshold);

    }
    int DFS(boolean[][] help,int row,int col,int rows,int cols,int threshold){
        if(row < 0 || col < 0 || row >= rows || col >= cols
                || help[row][col] == true || getSum(row) + getSum(col) > threshold ){
            return 0;
        }
        help[row][col] = true;
        return 1 + DFS(help,row - 1,col,rows,cols,threshold)+
                DFS(help,row + 1,col,rows,cols,threshold)+
                DFS(help,row,col - 1,rows,cols,threshold)+
                DFS(help,row,col + 1,rows,cols,threshold);
    }

    int getSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }


}
