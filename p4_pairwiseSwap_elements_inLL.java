package LINKED_LIST.LL_easy;

import java.util.Scanner;
/*
======================
PROBLEM:)
======================
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
 */

/*
============================
APPROACH: i was swapping values but here we gotta actually swap the nodes with e/o
============================
we set up 3 nodes previous(points to head), current(points to head.next) and next(points to current.next)

we will make the next of current node point to the previous node 
if the next node is the last in LL or null, make prev.next point to next and come out of the loop

else make prev.next point to next.next(we have to swap the next 2 elements too)
now shift the prev node to next and current to next.next

time complexity:
space complexity: O(1)
*/

/*
==============================
my approach and problem with it:
==============================
while(n.next!=null&&n!=null){c.next=p;p.next=n.next;c=n.next;p=n;n=n.next;}

if(n!=null){c.next=p;p.next=null;}

else if(n==null){c.next=p;p.next=n;}return head;

problem with the above approach is that for even and odd number of nodes it has to be coded differently .
we have to also unlink the internal nodes from inside to prevent the formation of infinite loop between nodes
this is tricky and sometimes gives unexpected results 
*/

public class p4_pairwiseSwap_elements_inLL {
 static class Node {
  int data;
  Node next;

  Node(int x) {
   data = x;
   next = null;
  }
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

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int n = s.nextInt();
   Node head = new Node(s.nextInt());
   Node temp = head;
   while (n-- > 0) {
    temp.next = new Node(s.nextInt());
    temp = temp.next;
   }
   Node sol = pairwiseSwap(head);
   printlist(sol);
   t--;
  }

  s.close();
 }
}
