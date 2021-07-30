package LL_easy;

/*
==================================================================================
PROBLEM:)
=================================================================================
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^3

===========================================================
EXAMPLE:
===========================================================
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
*/

/*
=================================================================================
APPROACH:)
=================================================================================

Time: O(N)
Space: O(1)
*/

/*
===============================================================================
ALTERNATE APPROACH:)
================================================================================
public static Node(Node head)
{
 Node node = head;
 int[] count = {0,0,0};
 while(node!=null)
 {
  count[node.data]++;
  node.next;
 }

 int i =0;
 node = head;

 while(node!=null)
 {
  if(count[i] == 0)
  {
   i++;
  }

  else
  {
   node.data = i;
   --count[i];
   node = node.next;
  }
 }

 return head;
}
*/

public class p17_sort_LL_of_0_1_and_2 extends helper {

 public static void main(String[] args) {

  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(2);
  head.next.next.next = new Node(1);
  head.next.next.next.next = new Node(2);
  head.next.next.next.next.next = new Node(0);
  head.next.next.next.next.next.next = new Node(2);
  head.next.next.next.next.next.next.next = new Node(2);

  Node r = segregate(head);
  while (r != null) {
   System.out.print(r.data + " ");
   r = r.next;
  }
 }

 static Node segregate(Node head) {

  if (head == null || head.next == null) {
   return head;
  }

  Node curr = head;
  Node zeroD = new Node(0);
  Node oneD = new Node(0);
  Node twoD = new Node(0);

  Node zero = zeroD, one = oneD, two = twoD;

  while (curr != null) {
   if (curr.data == 0) {
    zero.next = curr;
    zero = zero.next;
    curr = curr.next;
   } else if (curr.data == 1) {
    one.next = curr;
    one = one.next;
    curr = curr.next;
   } else {
    two.next = curr;
    two = two.next;
    curr = curr.next;
   }
  }

  zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next);
  one.next = twoD.next;
  two.next = null;

  head = zeroD.next;
  return head;
 }
}
