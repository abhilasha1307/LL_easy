package LL_easy;

/*
==================
PROBLEM:) #206 (easy)
====================
Reverse a singly linked list.
*/
/*
==========
APPROACH:)
==========
we make 3 temp nodes, c(to head), p and n (to null)
we make n point to c.next
while c is not null; we will make c.next point to p (null initially)
we will move p to c and c to n

time complexity: O(n)
space comlexity: O(1)
*/
public class x5_reverse_linked_list {

 public static class ListNode {
  int data;
  ListNode next;

  ListNode() {
  }

  ListNode(int data) {
   this.data = data;
  }

  ListNode(int data, ListNode next) {
   this.data = data;
   this.next = next;
  }
 }

 static ListNode head1;
 static ListNode head2;

 public static void main(String[] args) {
  head1 = new ListNode(1);
  head1.next = new ListNode(2);
  head1.next.next = new ListNode(3);
  head1.next.next.next = new ListNode(40);

  ListNode ans = reverseList(head1);
  while (ans != null) {
   System.out.print(ans.data + " ");
   ans = ans.next;
  }

  System.out.println();

  head2 = new ListNode(1);
  head2.next = new ListNode(2);
  head2.next.next = new ListNode(3);
  head2.next.next.next = new ListNode(40);

  ListNode result = reverseListRec(head2);
  while (result != null) {
   System.out.print(result.data + " ");
   result = result.next;
  }
 }

 // Iterative version
 public static ListNode reverseList(ListNode head) {
  ListNode c = head;
  ListNode p = null;
  ListNode n = null;

  while (c != null) {
   n = c.next;
   c.next = p;
   p = c;
   c = n;
  }
  head = p;
  return head;
 }

 // Recursive version

 public static ListNode reverseListRec(ListNode head) {
  if (head == null)
   return head;
  ListNode current = head;
  ListNode prev = null;
  return Util(current, prev);
 }

 public static ListNode Util(ListNode curr, ListNode prev) {
  if (curr == null)
   return curr;

  if (curr.next == null) {
   head2 = curr;
   curr.next = prev;

   return head2;
  }

  ListNode next = curr.next;
  curr.next = prev;

  Util(next, curr);
  return head2;
 }

}
