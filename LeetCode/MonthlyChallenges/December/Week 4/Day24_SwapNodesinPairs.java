//Day 24: 
//Problem Statement: Swap Nodes in Pairs

// Given a linked list, swap every two adjacent nodes and return its head.

// You may not modify the values in the list's nodes. Only nodes itself may be changed.

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// Example 2:

// Input: head = []
// Output: []
// Example 3:

// Input: head = [1]
// Output: [1]
 

// Constraints:

// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100

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
    public ListNode swapPairs(ListNode head) {
                
        if(head==null) return head;
        if(head.next==null) return head;
        
        ListNode prev=null, curr=head, next=head.next;
        head=next;
        
        while(curr!=null && next!=null) {
            curr.next=next.next;
            next.next=curr;
            
            if(prev!=null) prev.next=next;
            prev=curr;
            curr=curr.next;

            if(curr!=null) next=curr.next;
        
        }
        return head;
    }
}
//Complexity: O(n)

