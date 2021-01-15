// done

package LINKED_LIST.LL_easy;

import java.util.Scanner;

/*
=====================
PROBLEM:) #83 (easy)
=====================
Given a sorted linked list, delete all duplicates such that each element appear only once.
*/

/*
============
APPROACH:)
============
as the list is already sorted, if there are any duplicated, they will all be one after the other. we just have keep one and unlink others and as there is no element pointing at them, GC will pick them up

we make 2 nodes c and n. c to head and n to c.next
if c.val is same as n.val is same we make c.next point to n.next and shift n forward by one node (n = n.next)
else
we shift both c and n forward
return head;

time Complexity: O(n)
Space Complexity: O(1)

*/
public class x2_delete_duplicates {

 public static class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
   this.val = val;
  }

  ListNode(int val, ListNode next) {
   this.val = val;
   this.next = next;
  }
 }

 public static ListNode deleteDuplicates(ListNode head) {
  if (head == null)
   return null;
  ListNode c = head;
  ListNode n = c.next;
  while (n != null) {
   if (c.val == n.val) {
    c.next = n.next;
    n = n.next;
   } else {
    c = c.next;
    n = n.next;
   }
  }
  return head;

 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int length = s.nextInt();
  ListNode head = new ListNode(s.nextInt());
  ListNode temp = head;
  while (length > 0) {
   temp.next = new ListNode(s.nextInt());
   temp = temp.next;
   length--;
  }

  ListNode sol = deleteDuplicates(head);

  while (sol != null) {
   System.out.print(sol.val);
   sol = sol.next;
  }
  System.out.println();
  s.close();
 }
}