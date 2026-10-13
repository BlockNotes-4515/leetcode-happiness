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
    public int pairSum(ListNode head) {

        List<Integer> list=new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        //getting array like this [3,32,45,6];
        int i=0;
        int j=list.size()-1;
        int max=Integer.MIN_VALUE;

        while(i<j){
            int sum=(list.get(i)+list.get(j));
            max=Math.max(max,sum);
            i++;
            j--;
        }
        return max;
    }
}