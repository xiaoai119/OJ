import java.util.ArrayList;
import java.util.Stack;

/**
 * Created By xfj on 2020/2/11
 */
public class BinaryTreeSum {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    Stack<TreeNode> ts;
    Stack<Integer> help;
    ArrayList<ArrayList<Integer>> aal;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        aal=new ArrayList<ArrayList<Integer>>();
        ts=new Stack<TreeNode>();
        help=new Stack<Integer>();
        FindPath(root,target);
        return aal;
    }

    public void FindPathHelp(TreeNode root,int target){
        if(target==0){
            ArrayList<Integer> al=new ArrayList<Integer>();
            al.addAll(help);
            aal.add(al);
            return;
        }
        if(root==null)return;
        //if(target<root.val)return;
        //root 入栈
        ts.push(root);
        help.push(root.val);
        target=target-root.val;
        FindPathHelp(root.left,target);
        FindPathHelp(root.right,target);
        ts.pop();
        help.pop();
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        BinaryTreeSum binaryTreeSum = new BinaryTreeSum();
        ArrayList<ArrayList<Integer>> arrayLists =binaryTreeSum.FindPath(treeNode1, 3);
        System.out.println(arrayLists);


    }
}
