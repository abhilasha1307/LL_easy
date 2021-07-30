package LL_easy;

/*
=================================================================================
PROBLEM:)
=================================================================================
Given a linked list of size N. Find the length of the loop(if present) in the LL given
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 500
0 <= C <= N-1

=============================================================================
EXAMPLES:
============================================================================
N = 10
value[]={25,14,19,33,10,21,39,90,58,45}
C = 4
Output: 7

N = 2
value[] = {1,0}
C = 1
Output: 2
*/

/*
==============================================================================
APPROACH:)
==============================================================================
First we detect the loop(if not present, return 0)
if slow == fast, we call count function (param = slow)

make var int count = 1 (for where the slow is current at) and count till Node temp.next (set to slow) is not slow
return the count

Time : O(N)
Space : O(1)
*/
public class p18_length_of_the_loop extends helper {

 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  head.next.next.next = new Node(4);
  head.next.next.next.next = new Node(5);
  head.next.next.next.next.next = new Node(6);
  head.next.next.next.next.next.next = new Node(7);

  int position = 2;
  MakeLoop(head, position);
  System.out.println(Length_of_the_loop(head));
 }

 public static void MakeLoop(Node head, int p) {
  if (p == 0) {
   return;
  }
  int c = 1;
  Node current = head;
  Node last = head;

  while (c < p) {
   current = current.next;
   c += 1;
  }

  while (last.next != null) {
   last = last.next;
  }

  last.next = current;
  return;
 }

 public static int Length_of_the_loop(Node head) {

  if (head == null)
   return 0;
  Node slow = head;
  Node fast = head;

  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;

   if (slow == fast) {
    return countUtil(slow);
   }
  }

  return 0;
 }

 public static int countUtil(Node slow) {
  int count = 1;
  Node t = slow;

  while (t.next != slow) {
   count++;
   t = t.next;
  }

  return count;
 }

}
