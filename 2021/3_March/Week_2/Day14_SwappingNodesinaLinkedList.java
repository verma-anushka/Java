
//Day 14: 
//Problem Statement: Swapping Nodes in a Linked List

// You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]
// Example 3:

// Input: head = [1], k = 1
// Output: [1]
// Example 4:

// Input: head = [1,2], k = 1
// Output: [2,1]
// Example 5:

// Input: head = [1,2,3], k = 2
// Output: [1,2,3]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= k <= n <= 105
// 0 <= Node.val <= 100

//Solution:
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp1=head;
        
        k=k-1;
        
        while(k>0) {
            temp1=temp1.next;
            k--;
        }

        ListNode kth=temp1, temp2=head;
        while(kth.next!=null) {
            temp2=temp2.next;
            kth=kth.next;
        }

        int temp=temp1.val;
        temp1.val=temp2.val;
        temp2.val=temp;

        return head;   
    }
}
//Complexity: O(n)

