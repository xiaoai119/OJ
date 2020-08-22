/**
 * Created By xfj on 2020/3/3
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
class TreeIter {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    static List<List<Integer>> l;
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        l=new ArrayList<List<Integer>>();
        if(root==null)return l;

        LinkedList<TreeNode> ll1= new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2= new LinkedList<TreeNode>();
        ll2.offerFirst(root);
        boolean inorder=true;
        while(!ll1.isEmpty()||!ll2.isEmpty()){
            //将下层节点装入
            ll1.addAll(ll2);
            //若为空说明该层已经遍历完
            int k = ll2.size();
            if(inorder==true){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                for(int i=0;i<k;i++){
                    temp.add(ll2.pollFirst().val);
                }
                l.add(temp);
                inorder=false;
            }else{
                ArrayList<Integer> temp=new ArrayList<Integer>();
                for(int i=0;i<k;i++){
                    temp.add(ll2.pollLast().val);
                }
                l.add(temp);
                inorder=true;
            }

            while(!ll1.isEmpty()){
                TreeNode tn=ll1.pollFirst();
                if(tn.left!=null)ll2.offerFirst(tn.left);
                if(tn.right!=null)ll2.offerFirst(tn.right);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        zigzagLevelOrder(treeNode1);
    }
}