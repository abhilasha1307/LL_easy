package LL_easy;

import java.util.Scanner;
/*

Given two numbers represented by two linked lists of size N and M.
 The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers.
*/

/*

*/

public class p14_add_2numbers_represented_by_LL {

 static class Node {

  int data;
  Node next;

  Node(int d) {
   data = d;
   next = null;
  }
 }

 static Node addLists(Node first, Node second) {

  // return head of sum list

  Node temp1 = reverseList(first);
  Node temp2 = reverseList(second);
  Node head = new Node(0);
  Node temp = head;

  int carry = 0;
  int add = 0;

  while (temp1 != null && temp2 != null) {
   add = temp1.data + temp2.data + carry;
   if (add >= 10) {
    temp.data = add - 10;
    carry = 1;
   }

   else {
    temp.data = add;
    carry = 0;
   }

   temp.next = new Node(0);
   temp = temp.next;

   temp1 = temp1.next;
   temp2 = temp2.next;
  }

  if (temp1 != null) {

   add = temp1.data + carry;
   if (add >= 10) {
    temp.data = add - 10;
    carry = 1;
    temp.next = new Node(0);
    temp = temp.next;
   } else {
    temp.data = add;
    carry = 0;
   }

   temp1 = temp1.next;
  }

  if (temp2 != null) {
   add = temp2.data + carry;
   if (add >= 10) {
    temp.data = add - 10;
    carry = 1;
    temp.next = new Node(0);
    temp = temp.next;
   } else {
    temp.data = add;
    carry = 0;
   }

   temp2 = temp2.next;
  }

  if (temp1 == null && temp2 == null && carry == 1) {

   temp.data = 1;
   temp = temp.next;
  }

  Node fnode = reverseList(head);
  return fnode;
 }

 public static Node reverseList(Node head) {
  Node c = head;
  Node p = null;
  Node n = null;

  while (c != null) {
   n = c.next;
   c.next = p;
   p = c;
   c = n;
  }

  head = p;
  return head;
 }

 static void print(Node head) {
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
   int n = s.nextInt();
   Node head1 = new Node(s.nextInt());
   Node t1 = head1;
   while (n-- > 0) {
    t1.next = new Node(s.nextInt());
    t1 = t1.next;
   }

   int m = s.nextInt();
   Node head2 = new Node(s.nextInt());
   Node t2 = head2;
   while (m-- > 0) {
    t2.next = new Node(s.nextInt());
    t2 = t2.next;
   }

   Node head3 = addLists(head1, head2);

   print(head3);

   t--;
  }

  s.close();
 }

}
