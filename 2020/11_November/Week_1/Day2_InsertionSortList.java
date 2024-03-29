
//Day 2: 
//Problem Statement: Insertion Sort List

// Sort a linked list using insertion sort.


// A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
// With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

// Algorithm of Insertion Sort:

// Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
// It repeats until no input elements remain.

// Example 1:

// Input: 4->2->1->3
// Output: 1->2->3->4
// Example 2:

// Input: -1->5->3->4->0
// Output: -1->0->3->4->5

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
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null) return head;
        ListNode start=new ListNode(head.val);
        head=head.next;
        
        while(head != null) {
            ListNode prev=null, curr=start;
            while(curr!=null && curr.val<head.val) {
                prev=curr;
                curr=curr.next;
            }
            ListNode temp=new ListNode(head.val);
            if(prev==null) {
                temp.next = curr;
                start=temp;
            } else {
                prev.next=temp;
                temp.next=curr;
            }
            head=head.next;
        }
        return start;
    }
}
//Complexity: O(n^2)

