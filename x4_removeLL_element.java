package LINKED_LIST.LL_easy;

import java.util.Scanner;

/*
======================
PROBLEM: #203 (EASY)
======================
Remove all elements from a linked list of integers that have value 'val'.
*/

/*
===============
APPROACH:)
===============
we make teo temp nodes, c(to head.next) and prev (head) 
while prev.next is not null we compare to see whether the value at 'c' node is same as the value that we want to remove
if yes, we make prev.next point to c.next (unlink said node)
else, we just shift c and prev forward

time complexity: O(n)
space complexity: O(1)

*/
public class x4_removeLL_element {

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

 public static ListNode removeElements(ListNode head, int val) {
  while (head != null && head.val == val) { // if LL has only one element and we have to remove that element
   head = head.next;
  } // if the elements are the same in the list and we have to remove them

  if (head == null) { // when there is no element in the LL
   return null;
  }

  if (head.next == null) { // when there is only 1 element in the LL but you have to remove a different
                           // element
   return head;
  } else {
   ListNode c = head.next;
   ListNode prev = head;

   while (prev.next != null) {
    if (c.val == val) {
     prev.next = c.next;
     c = c.next;
    } else {
     c = c.next;
     prev = prev.next;
    }
   }
  }
  return head;

 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int l1 = s.nextInt();
  ListNode h1 = new ListNode(s.nextInt());
  ListNode a1 = h1;
  while (l1-- > 0) {
   a1.next = new ListNode(s.nextInt());
   a1 = a1.next;
  }
  int val = s.nextInt();
  ListNode m = removeElements(h1, val);
  System.out.println();
  if (m == null) {
   System.out.println("null");
  }
  while (m != null) {
   System.out.print(m.val + " ");
   m = m.next;
  }
  s.close();
 }
}
