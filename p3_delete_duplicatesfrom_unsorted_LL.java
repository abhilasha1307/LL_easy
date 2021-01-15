package LINKED_LIST.LL_easy;

import java.util.HashSet;
//done; see hashtable mtd in this ques (V.imp)
import java.util.Scanner;
/*
====================
PROBLEM:)
====================
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.
*/

/*
==============
APPROACH:)
==============


*/
public class p3_delete_duplicatesfrom_unsorted_LL {

  static class Node {
    int data;
    Node next;

    Node(int x) {
      data = x;
      next = null;
    }
  }

  /*
   * public static Node removeDuplicates(Node head) {
   * 
   * Node h1 = merge_sort(head);
   * 
   * Node p = h1; Node c = p.next; while (c != null) { if (p.data == c.data) {
   * p.next = c.next; c = c.next; } else { p = p.next; c = c.next; } } return h1;
   * }
   */

  /*
   * public static Node remove_duplicates(Node head) {
   * 
   * if (head == null || head.next == null) { return head; } Node ptr1 = null,
   * ptr2 = null, dup = null; ptr1 = head;
   * 
   * 
   * while (ptr1 != null && ptr1.next != null) { ptr2 = ptr1;
   * 
   * while (ptr2.next != null) {
   * 
   * 
   * if (ptr1.data == ptr2.next.data) {
   * 
   * 
   * dup = ptr2.next; ptr2.next = ptr2.next.next; System.gc(); } else { ptr2 =
   * ptr2.next; } } ptr1 = ptr1.next; } return head; }
   */

  static Node removeDuplicates(Node head) {
    // Hash to store seen values
    HashSet<Integer> hs = new HashSet<>();

    /* Pick elements one by one */
    Node current = head;
    Node prev = null;
    while (current != null) {
      int curval = current.data;

      // If current value is seen before
      if (hs.contains(curval)) {
        prev.next = current.next;
      } else {
        hs.add(curval);
        prev = current;
      }
      current = current.next;
    }
    return head;
  }

  /*
   * public static Node sorting_lists(Node a, Node b) { // to merge lists that are
   * divided and given by merge_sort function Node temp = null; if (a == null) {
   * return b; }
   * 
   * if (b == null) { return a; }
   * 
   * if (a.data <= b.data) { temp = a; temp.next = sorting_lists(a.next, b); }
   * 
   * else { temp = b; temp.next = sorting_lists(a, b.next); }
   * 
   * return temp; }
   * 
   * public static Node merge_sort(Node head) { // merge_sort algo if (head ==
   * null || head.next == null) { return head; }
   * 
   * Node middle = middleNode(head); Node next_m = middle.next;
   * 
   * middle.next = null;
   * 
   * Node left = merge_sort(head);
   * 
   * Node right = merge_sort(next_m);
   * 
   * Node final_list = sorting_lists(left, right); return final_list; }
   * 
   * public static Node middleNode(Node head) { // divide into two list (w/ nodes
   * itself) and return the middle node if (head == null || head.next == null) {
   * return head; }
   * 
   * Node c = head; Node n = head; while (n.next != null && n.next.next != null) {
   * c = c.next; n = n.next.next; } return c; }
   */

  static void printlist(Node temp) {
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
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

      Node s1 = removeDuplicates(head);
      printlist(s1);
      t--;
    }
    s.close();
  }
}
