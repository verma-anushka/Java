
//Day 7: 
//Problem Statement: Add Two Numbers II

// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

// Example:

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=null;        
        String a="", b="";
    
        while(l1!=null) {         
            a+=l1.val;             
            l1=l1.next;
        }
        // System.out.println("a "+ a);
        
        while(l2!=null) {     
            b+=l2.val; 
            l2=l2.next;
        }
        // System.out.println(b);
        

        int l=a.length()-1, r=b.length()-1, carry=0;  
        
        while(l>=0 || r>=0 || carry==1) {
            int c = (l>=0 ? a.charAt(l)-'0' : 0) + ( r>=0 ? b.charAt(r)-'0' : 0) + carry;    
            l--; r--;
            ListNode temp=new ListNode(c%10);
            temp.next=ans;
            ans=temp;
            carry=c/10;
        }  
        return ans;

    }
}

//Complexity: O(n)

