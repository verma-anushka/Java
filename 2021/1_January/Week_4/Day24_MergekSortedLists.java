//Day 24: 
//Problem Statement: Merge k Sorted Lists

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.

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
    public ListNode mergeTwoSortedLists(ListNode h1, ListNode h2) {
        
        if(h1==null) return h2;
        if(h2==null) return h1;

        ListNode h=null, t=null;
        ListNode t1=h1, t2=h2;
        
        if(t1.val<=t2.val) {
            h=t1; t=t1;
            t1=t1.next;
        } else {
            h=t2; t=t2;
            t2=t2.next;
        }
        while(t1!=null && t2!=null) {
            if(t1.val<=t2.val) {
                t.next=t1;
                t1=t1.next;
            } else {
                t.next = t2;
                t2=t2.next;
            }
            t=t.next;
        }
        
        if(t1==null) t.next=t2;
        if(t2==null) t.next=t1;

        return h;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        
        if(left>=right) return lists[left];
        
        int mid=left+(right-left)/2;
        ListNode l1=mergeKLists(lists, left, mid);
        ListNode l2=mergeKLists(lists, mid+1, right);

        return mergeTwoSortedLists(l1, l2);
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0) return null;
        
        return mergeKLists(lists, 0, lists.length-1);
        
    }
}
//Complexity: O(n*logn)

