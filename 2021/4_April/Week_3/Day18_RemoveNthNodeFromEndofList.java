
//Day 18: 
//Problem Statement: Remove Nth Node From End of List

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Follow up: Could you do this in one pass?

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow=head, fast=head;
        
        for(int i=0; i<n; i++) fast=fast.next;
        
        if(fast==null) {
            if(slow.next==null) return null;
            else return head.next;
        }
        
        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next=slow.next.next;        
        return head;
    }
}
//Complexity: O(n)

