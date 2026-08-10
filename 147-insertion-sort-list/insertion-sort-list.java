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
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy=new ListNode(0);
        while(head!=null){
            ListNode next=head.next;
            ListNode p=dummy;
            while(p.next!=null && p.next.val<head.val){
                p=p.next;
            }
            head.next=p.next;
            p.next=head;
            head=next;
        }
        return dummy.next;
    }
}