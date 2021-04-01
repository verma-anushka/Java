
//Day 1:
//Problem Statement: Palindrome Linked List

// Given the head of a singly linked list, return true if it is a palindrome.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 

// Follow up: Could you do it in O(n) time and O(1) space?

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
    public boolean isPalindrome(ListNode head) {
            
        if(head==null) return true;

        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;

        ListNode prev=null, curr=slow;
        while(curr!=null) {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        slow=prev;
        
        while(slow!=null) {
            // cout << slow->val << " " << fast->val << endl;
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        
        return true;
    
    }
}
//Complexity: O(n)

