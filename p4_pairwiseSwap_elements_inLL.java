package LL_easy;

/*
==============================================
PROBLEM:)
==============================================
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
Constraints:
1 ≤ N ≤ 103

=================================================
EXAMPLES:
LinkedList: 1->2->2->4->5->6->7->8
Output: 2 1 4 2 6 5 8 7
=================================================
*/

/*
====================================================
APPROACH: 
====================================================
we set up 3 nodes previous(points to head), current(points to head.next) and next(points to current.next)

we will make the next of current node point to the previous node 
if the next node is the last in LL or null, make prev.next point to next and come out of the loop

else make prev.next point to next.next(we have to swap the next 2 elements too)
now shift the prev node to next and current to next.next

time complexity: o(N)
space complexity: O(1)
*/

public class p4_pairwiseSwap_elements_inLL extends helper {

 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  head.next.next.next = new Node(4);
  head.next.next.next.next = new Node(5);
  head.next.next.next.next.next = new Node(6);

  printlist(pairwiseSwap(head));
 }

 public static Node pairwiseSwap(Node head) {
  if (head == null || head.next == null)
   return head;

  Node p = head;
  Node c = head.next;
  head = c; // after swapping head will should be at head.next

  while (true) {
   Node n = c.next;
   c.next = p;
   if (n == null || n.next == null) {
    p.next = n;
    break; // to break from loop }
   }
   p.next = n.next;
   p = n;
   c = n.next;
  }
  return head;

 }

 static void printlist(Node head) {
  if (head == null) {
   System.out.println("null");
  }
  Node t = head;
  while (t != null) {
   System.out.print(t.data + " ");
   t = t.next;
  }
  System.out.println("\n");
 }
}
