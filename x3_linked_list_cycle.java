package LL_easy;

//done
import java.util.Scanner;

/*
==================================
PROBLEM:) #141 linked list cycle
==================================
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Follow up:
Can you solve it using O(1) (i.e. constant) memory?

eg:
Input: head = [3,2,0,-4], pos = 1 (-4 to 2)
Output: true
*/

/*
==============
APPROACH:)
==============
we input a SLL and then we have to make a cycle in the LL
for a LL to be actually CLL some element has to be visted twice in the same traversal; the last element shd not point to null but to an internal element
doesnt have to be necessarily the first node

after making the list circular we make two temp nodes slow and fast
till slow and fast point to the same node in the list we shift the slow and fast nodes forward by one and two nodes respectively
if fast is null or its the last element and the no element is visited twice or slow and fast never pointed to the same node (SLL and not CLL)
we return false

time Complexity : O(n)
space complexity: O(1)
*/
public class x3_linked_list_cycle {
 public static class ListNode {
  int val;
  ListNode next;

  ListNode(int d) {
   val = d;
   next = null;

  }
 }

 public static boolean hasCycle(ListNode head) {

  if (head == null) {
   return false;
  }

  ListNode slow = head;
  ListNode fast = head.next;
  while (slow != fast) {
   if (fast == null || fast.next == null) { // this will only happen if the LL is actually a SLL
    return false;
   }

   slow = slow.next;
   fast = fast.next.next;
  }

  return true;
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);

  int length = s.nextInt();
  ListNode head = new ListNode(s.nextInt());
  ListNode t = head;
  while (length > 0) {
   t.next = new ListNode(s.nextInt());
   t = t.next;
   length--;
  }

  ListNode temp = head;
  int pos = s.nextInt();
  while (pos > 0) { // reaching the node where we want the last node to point at. 0 would mean that
                    // we want to link last to first and so on
   temp = temp.next;
   pos--;
  }
  if (pos >= 0) { // linking to make CLL
   t.next = temp;
  }

  boolean value = hasCycle(head);
  System.out.println(value);
  s.close();
 }
}
