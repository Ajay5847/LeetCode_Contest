// Given the head of a linked list head, in which each node contains an integer value.
// Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
// Return the linked list after insertion.
// The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

// Example 1:

// Input: head = [18,6,10,3]
// Output: [18,6,6,2,10,1,3]
// Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
// - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
// - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
// - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
// There are no more adjacent nodes, so we return the linked list.

// Constraints:
// The number of nodes in the list is in the range [1, 5000].
// 1 <= Node.val <= 1000

//problem link - https://leetcode.com/contest/biweekly-contest-110/problems/insert-greatest-common-divisors-in-linked-list/

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            ListNode node = new ListNode(gcd(temp.val,temp.next.val));
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        return head;
    }
    
    int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // difference(a,b) as long as b != 0
        else
            return gcd(b, Math.abs(a - b));
    }
}