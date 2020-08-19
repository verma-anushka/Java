
//Day 20: 
//Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/
//Problem Statement: Reorder List

// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You may not modify the values in the list's nodes, only nodes itself may be changed.

// Example 1:

// Given 1->2->3->4, reorder it to 1->4->2->3.
// Example 2:

// Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

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
    public void reorder(ListNode h1, ListNode h2) {
        
        while(h1!=null) {

            ListNode h1next=h1.next;
            ListNode h2next=h2.next;

            h1.next=h2;
            if(h1next==null) break;
            h2.next = h1next;
            h1=h1next;
            h2=h2next;

        }
    }
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null) return;
        ListNode h1=head;
        ListNode prev=null, slow=head, fast=head;
        
        while(fast!=null && fast.next!=null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        prev.next=null;
        
        prev=null;
        ListNode curr=slow;
        while(curr!=null) {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode h2=prev;
        
        reorder(h1, h2);
    }
}
//Complexity: O(n)

