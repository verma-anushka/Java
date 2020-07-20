
//Day 20: 
//Problem Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
//Problem Statement: Remove Linked List Elements

//Remove all elements from a linked list of integers that have value val.

//Example:

//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5

//Solution:
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        
        ListNode curr=head, prev=null;
        
        while(curr!=null) {
            if(curr.val == val) {
                if(prev!=null) prev.next = curr.next;
                else head=curr.next;
            } else {
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}
//Complexity: O(n)
