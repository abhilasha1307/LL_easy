package LINKED_LIST.LL_easy;

import java.util.*;
/*
 PROBLEM:)
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

eg:
Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
 */

/*
APPROACH:)


*/
public class p16_reverse_LL_in_grps_of_given_size {

 public static class Node {
  int data;
  Node next;

  Node(int d) {
   data = d;
   next = null;
  }
 }

 public static Node reverse(Node node, int k) { // think iteratively

  Node c = node;
  Node p = null;
  Node n = null;
  int count = 0;
  while (count < k && c != null) {
   n = c.next;
   c.next = p;
   p = c;
   c = n;
   count++;
  }

  if (n != null) {
   node.next = reverse(n, k);
  }

  return p;
 }

 public static void printList(Node head) {
  while (head != null) {
   System.out.print(head.data + " ");
   head = head.next;
  }
  System.out.println();
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int m = s.nextInt();
   Node h1 = new Node(s.nextInt());
   Node t1 = h1;
   while (m-- > 0) {
    t1.next = new Node(s.nextInt());
    t1 = t1.next;
   }
   int k = s.nextInt();

   Node head = reverse(h1, k);
   printList(head);
  }

  s.close();
 }

}