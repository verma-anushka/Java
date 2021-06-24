
//Day 23: 
//Problem Statement: Reverse Linked List II

// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [5], left = 1, right = 1
// Output: [5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
 

// Follow up: Could you do it in one pass?


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head==null) return head;
        
        ListNode prev=null, curr=head;
        int count=n-m;

        while(m-->1 && curr!=null) {
            prev=curr;
            curr=curr.next;
        }
        
        ListNode head2=prev, tail=curr, next=null;

        while(curr!=null && count-->=0) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        if(head2!=null)
            head2.next=prev;
        else
            head=prev;
           
        tail.next=curr;
        return head;
    }
}
//Complexity: O(n)