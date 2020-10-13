
//Day 13: 
//Problem Statement: Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.

// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105

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
    
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode mid=middle(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        
        return mergeTwoLists(left, right);
    
    }
    
    public ListNode middle(ListNode head) {
    
        ListNode slow=head, fast=head, mid;
        
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        mid=slow.next;
        slow.next=null;
        
        return mid;
    
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        ListNode temp=new ListNode(-1), curr=temp;
        
        while(l1!=null && l2!=null) {
            
            if(l1.val<=l2.val) {
                curr.next=l1;
                l1=l1.next;
            } else {
                curr.next=l2;
                l2=l2.next;
            }
            
            curr=curr.next;
        }
        
        curr.next = (l1!=null) ? l1 : l2;
        
        return temp.next;
    }
}

//Complexity: O(n^2)
