package LINKED_LIST.LL_easy;

//done (submission problem)
import java.util.Scanner;
/*
============
PROBLEM:)
============
Given two linked lists, your task is to complete the function mergeList() which inserts nodes of second list into first list at alternate positions of first list.

eg:
9 10

5 4 3 2 1 6

o/p: 10 6 9 1 2 3 4 5 
*/

/*
==========
APPROACH:
==========
 we make two nodes c1 for head1 and c2 for head2 
 till c1 and c2 are not null we will make n1 point to c1.next and n2 point c2.next

 now to merge we make c1.next point to c2 and c2.next to n1 and then shift c1 and c2 to n1 and n2 respectively

 time complexity: O(n)

 space complexity: O(1)
*/
public class p9_merge_lists_alternatingly {
 static class Node {
  int data;
  Node next;

  Node(int x) {
   data = x;
   next = null;
  }
 }

 /*
  * if (head1 == null && head2 == null) { System.out.println("null"); }
  * 
  * if (head1 == null) { printList(head2); // show function in GFG }
  * 
  * if (head2 == null) { printList(head1); }
  * 
  * Node c1 = head1; Node n1 = c1.next; Node c2 = head2; Node n2 = c2.next;
  * 
  * while (n1 != null && n2 != null) { c1.next = c2; c2.next = n1; c1 = n1; n1 =
  * n1.next; c2 = n2; n2 = n2.next; }
  * 
  * if (n1 == null) { printList(head1); System.out.print(c1.next.data + " ");
  * c1.next = c2; System.out.print("\n"); c2 = n2; while (c2 != null) {
  * 
  * System.out.print(c2.data + " "); c2 = c2.next; } }
  * 
  * if (n2 == null) { c1.next = c2; c2.next = n1; c1 = n1; while (c1 != null) {
  * c1 = c1.next; } printList(head1); }
  */
 public static void mergeAlt(Node head1, Node head2) {
  if (head1 == null && head2 == null) {
   printList(head1);
  }

  if (head1 == null) {
   printList(head2);
  }

  if (head2 == null) {
   printList(head1);
  }

  Node c1 = head1;
  Node c2 = head2;

  while (c1 != null && c2 != null) {
   Node n1 = c1.next;
   Node n2 = c2.next;

   c1.next = c2;
   c2.next = n1;
   c1 = n1;
   c2 = n2;
  }

  printList(head1);

  if (c1 != null) {
   printList(c1);
  }

  if (c2 != null) {
   printList(c2);
  }

 }

 static void printList(Node head) {
  if (head == null) {
   System.out.println("null");
  }
  Node temp = head;
  while (temp != null) {
   System.out.print(temp.data + " ");
   temp = temp.next;
  }
  System.out.println("\n");
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int n1 = s.nextInt();
   Node head1 = new Node(s.nextInt());
   Node t1 = head1;
   while (n1-- > 0) {
    t1.next = new Node(s.nextInt());
    t1 = t1.next;
   }

   int n2 = s.nextInt();
   Node head2 = new Node(s.nextInt());
   Node t2 = head2;
   while (n2-- > 0) {
    t2.next = new Node(s.nextInt());
    t2 = t2.next;
   }

   mergeAlt(head1, head2);
  }
  s.close();
 }
}
