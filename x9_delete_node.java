package LINKED_LIST.LL_easy;

//done
import java.util.Scanner;

/*
=====================
PROBLEM:) #237 (easy)
=====================
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list. 
*/

/*
MY APPROACH:) actually trying to delete the said node, using DLL
public static class ListNode {
  int val;
  ListNode next;
  ListNode prev;

  ListNode() {
  }

  ListNode(int x) {
   val = x;
  }
 }

 public static void deleteNode(ListNode node) {
  ListNode temp = node;
  if (node.prev == null) {
   temp = temp.next;
   node.next = null;
   temp.prev = null;
   node = temp;
  } else {
   temp.prev = temp.next;
   temp.next = temp.prev;
  }
 }

 public static void append(int data, ListNode a1) {
  ListNode a2 = new ListNode(data);
  while (a1.next != null) {
   a1 = a1.next;
  }
  a1.next = a2;
  a2.prev = a1;
 }
*/

/*
==================
BETTER APPROACH:) 
==================
(LOOPHOLE) just swap the val of the given node with next node and make to point to where node.next is pointing. No actual deletion required
we are just changing the represenation of the list

complexity(time and space): O(1)
*/

public class x9_delete_node {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int l1 = s.nextInt();
    ListNode h1 = new ListNode(s.nextInt());
    ListNode a1 = h1;
    while (l1 > 0) {
      a1.next = new ListNode(s.nextInt());
      a1 = a1.next;
      l1--;
    }
    a1 = h1;

    int target = s.nextInt();
    while (a1.next != null) {
      if (a1.val == target) {
        deleteNode(a1);
      }
      a1 = a1.next;
    }
    a1 = h1;
    while (a1 != null) {
      System.out.println(a1.val + " ");
      a1 = a1.next;
    }
    s.close();
  }
}
