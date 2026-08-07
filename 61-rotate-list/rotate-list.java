/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        //We have to find out the tail and the size
        ListNode tail=null;
        int size=0;
        ListNode curr=head;
        while(curr!=null){
            tail=curr;
            curr=curr.next;
            size++;
        }
        //Calculating the diff and newK
        int newK=k%size;
        if(newK==0){
            return head;
        }
        int diff=size-newK;
        int i=0;
        curr=head;
        while(i<diff-1){
            curr=curr.next;
            i++;
        }
        //finding the newTail and newHead
        ListNode newTail=curr;
        ListNode newHead=newTail.next;
        newTail.next=null;
        tail.next=head;
        return newHead;
    }
}