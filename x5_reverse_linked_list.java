package LINKED_LIST.LL_easy;

import java.util.Scanner;

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

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int l1 = s.nextInt();
  ListNode h1 = new ListNode(s.nextInt());
  ListNode a1 = h1;
  while (l1 > 0) {
   a1.next = new ListNode(s.nextInt());
   a1 = a1.next;
   l1--;
  }
  ListNode value = reverseList(h1);
  while (value != null) {
   System.out.println(value.val);
   value = value.next;
  }
  s.close();
 }
}
