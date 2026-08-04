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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //Making the Dummy Node
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        //Making the two pointers
        ListNode fast=dummy;
        ListNode slow=dummy;

        //Traverse by using the fast node only
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }

        //Moving the two pointers parallely by the value of 'n+1'
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

        return dummy.next;
    }
}