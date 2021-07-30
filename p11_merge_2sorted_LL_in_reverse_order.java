package LL_easy;

//done
import java.util.Scanner;
/*
============
PROBLEM:) 
================
Given two linked lists of size N and M, which are sorted in non-decreasing order. The task is to merge them in such a way that the resulting list is in decreasing order.
eg:
5 10 15 40 
2 3 20

op: 40 20 15 10 5 3 2
*/

/*
===============
APPROACH:
===============
here we will have to store the data of nodes of the 2 LL given in a new LL
we make a new head headtemp and a temp node 
we will compare the elements in the lists given and store them accordingly in the new list made 

if the list are of different sizes then when the shorter list ends we will simply copy all the remaining elements of the longer list (lists are already in non decreasing order)

when we get the final list, we simply reverse it and return the head of the reversed list

time complexity:  O(m+n) m and n are the number of nodes in both lists 
space complexity: O(m+n) as we are making a new list and this list will contain all the elements of the 2 given lists
*/

public class p11_merge_2sorted_LL_in_reverse_order {
 static class Node {
  int data;
  Node next;

  Node(int d) {
   data = d;
   next = null;
  }
 }

 static Node mergeResult(Node node1, Node node2) {

  if (node1 == null && node1 == null) {
   return null;
  }

  Node ta = node1;
  Node tb = node2;

  Node headtemp = new Node(0);

  Node temp = headtemp;

  while (ta != null && tb != null) {
   if (ta.data <= tb.data) {
    temp.next = new Node(ta.data);
    temp = temp.next;
    ta = ta.next;
   }

   else {
    temp.next = new Node(tb.data);
    temp = temp.next;
    tb = tb.next;

   }
  }

  while (tb != null) {
   temp.next = new Node(tb.data);
   tb = tb.next;
   temp = temp.next;
  }

  while (ta != null) {
   temp.next = new Node(ta.data);
   ta = ta.next;
   temp = temp.next;
  }

  headtemp = headtemp.next;
  Node head = reverselist(headtemp);
  return head;
 }

 // ==========================
 // print the list
 static void printlist(Node head) {
  Node temp = head;

  while (temp != null) {
   System.out.print(temp.data + " ");
   temp = temp.next;
  }
  System.out.println();
 }

 // =======================
 // reverse the list
 static Node reverselist(Node h) {
  if (h == null || h.next == null) {
   return h;
  }
  Node p = null;
  Node c = h;
  Node n = c.next;

  while (n != null) {
   c.next = p;
   p = c;
   c = n;
   n = n.next;
  }
  c.next = p;
  p = c;
  h = p;
  return h;
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int m = s.nextInt();
   int n = s.nextInt();
   Node h1 = new Node(s.nextInt());
   Node t1 = h1;
   while (m-- > 0) {
    t1.next = new Node(s.nextInt());
    t1 = t1.next;
   }

   // Node s1 = reverselist(h1);

   Node h2 = new Node(s.nextInt());
   Node t2 = h2;
   while (n-- > 0) {
    t2.next = new Node(s.nextInt());
    t2 = t2.next;
   }
   // Node s2 = reverselist(h2);

   Node sol = mergeResult(h1, h2);
   printlist(sol);
  }
  s.close();
 }
}
