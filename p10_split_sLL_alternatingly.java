package LINKED_LIST.LL_easy;

//done (submission problem)
import java.util.Scanner;
/*
============
PROBLEM:)
============
Given a singly linked list of size N. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller list. The sublists should be made from alternating elements from the original list.
Note: the sublist should be in the order with respect to original list.
*/

/*
==========
APPROACH:
==========
if we have only one element in the list; we print that element
if we have 2 elements, we print them separately

for more than 2 elements
we take 2 temp node ta and tb; till tb is not null and also not the last element
we make ta.next point to tb.next and tb.next to tb.next.next

if we have even no. of nodes; the last two nodes will have a link and the loop will terminate before severing the link

so if the ta != null we make ta.next point to null.

time complexity : O(n);
space Complexity : O(1);
*/
public class p10_split_sLL_alternatingly {

 static class Node {
  int data;
  Node next;

  Node(int data) {
   this.data = data;
   this.next = null;
  }
 }

 public static Node a;
 public static Node b;

 public static void alternatingSplitList(Node head) {
  /*
   * if (head == null) { System.out.println("null"); }
   * 
   * if (head.next == null) { System.out.println(head.data); }
   * 
   * int count = 0; Node t = head;
   * 
   * while (t != null) { count++; t = t.next; } a = head; b = head.next; if (count
   * % 2 == 0) {
   * 
   * Node ta = head; Node tb = head.next;
   * 
   * while (ta.next.next != null && tb.next != null) { ta.next = ta.next.next;
   * tb.next = tb.next.next;
   * 
   * ta = ta.next; tb = tb.next; } ta.next = null; }
   * 
   * else { Node ta = head; Node tb = head.next;
   * 
   * while (ta.next != null && tb.next.next != null) { ta.next = ta.next.next;
   * tb.next = tb.next.next;
   * 
   * ta = ta.next; tb = tb.next; } ta.next = tb.next; tb.next = null; }
   */
  if (head == null) {
   System.out.println("null");
  }

  else if (head.next == null) {
   System.out.println(head.data);
  }

  else if (head.next.next == null) {
   a = head;
   b = head.next;
   a.next = null;
  } else {
   a = head;
   Node ta = head;
   b = head.next;
   Node tb = head.next;

   while (tb != null && tb.next != null) {
    ta.next = tb.next;
    tb.next = tb.next.next;

    ta = ta.next;
    tb = tb.next;

   }
   if (ta != null) {
    ta.next = null;
   }
  }
 }

 static void printlist(Node head) {
  Node t = head;
  while (t != null) {
   System.out.print(t.data + " ");
   t = t.next;
  }
  System.out.println();
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   a = null;
   b = null;
   int n = s.nextInt();
   Node head = new Node(s.nextInt());
   Node temp = head;
   while (n-- > 0) {
    temp.next = new Node(s.nextInt());
    temp = temp.next;
   }

   alternatingSplitList(head);
   printlist(a);
   printlist(b);
   t--;
  }

  s.close();
 }

}
/*
 * static void moveNode(Node a, Node b) { if (b == null || a == null) return;
 * 
 * if (a.next != null) a.next = a.next.next;
 * 
 * if (b.next != null) b.next = b.next.next;
 * 
 * moveNode(a.next, b.next); }
 * 
 * // function to split linked list static void alternateSplitLinkedList(Node
 * head) { Node curr = head; a = curr; b = curr.next; Node aRef = a, bRef = b;
 * moveNode(aRef, bRef); }
 * 
 */