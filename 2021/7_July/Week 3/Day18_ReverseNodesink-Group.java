
//Day 18: 
//Problem Statement: Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
// Example 3:

// Input: head = [1,2,3,4,5], k = 1
// Output: [1,2,3,4,5]
// Example 4:

// Input: head = [1], k = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
 

// Follow-up: Can you solve the problem in O(1) extra memory space?

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null) return null;
        
        ListNode prev=null, curr=head, next=head.next, temp=head;
        int nodes=k, n=0;
        
        while(temp!=null) {
            n++;
            temp=temp.next;
        }
        
        if(n<k) return head;
        
        while(curr!=null && nodes>0) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            nodes--;
        }
        
        head.next=reverseKGroup(curr, k);
        
        return prev;
    }
}
//Complexity: O(n)
