/**
 * Created By xfj on 2020/1/28
 * 反转链表
 */
public class reverseList {
    public static class Node{
        int data;
        Node next;
        public Node(int val){
            this.data=val;
        }

    }

    public Node reverseList(Node head){
        Node pre=null;
        Node next=null;
        while(head!=null){
            next =head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public void printLinkedList(Node head){
        while (head!=null){
            System.out.print(head.data);
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverseList reverseList = new reverseList();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        reverseList.printLinkedList(head1);
        head1 = reverseList.reverseList(head1);
        reverseList.printLinkedList(head1);

    }
}

