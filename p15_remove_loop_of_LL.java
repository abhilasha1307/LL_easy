package LINKED_LIST.LL_easy;

//done
import java.util.*;
/*
You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.

N = 4
value[] = {1,8,3,4}
X = 0
Output: 1

N = 3
value[] = {1,3,4}
X = 2
Output: 1
*/

/*

*/

public class p15_remove_loop_of_LL {
 public static class Node {
  int data;
  Node next;

  Node(int d) {
   data = d;
   next = null;
  }
 }

 // we dont know to which internal node is last node attached to
 // concept of keeping 2 nodes to see which one is attached to the last node of
 // LL so as no sever that circle forming link
 public static void removeLoop(Node head) {
  // remove the loop without losing any nodes
  if (head == null || head.next == null) {
   return;
  }

  Node slow = head;
  Node fast = head;

  while (fast != null && fast.next != null) {

   slow = slow.next;
   fast = fast.next.next;

   if (slow == fast) {
    remove(slow, head);
    return;
   }
  }
  return;
 }

 public static void remove(Node slow, Node head) {
  Node p1 = slow;
  Node p2 = slow;

  int k = 1;
  while (p1.next != p2) {
   p1 = p1.next;
   k++;
  }

  p1 = head;
  p2 = head;

  for (int i = 0; i < k; i++) {
   p2 = p2.next;
  }

  while (p1 != p2) {
   p1 = p1.next;
   p2 = p2.next;
  }

  while (p2.next != p1) {
   p2 = p2.next;
  }

  p2.next = null;

  return;
 }

 public static void makeloop(Node head, int p) {
  if (p == 0)
   return;
  int c = 1;
  Node current = head;
  Node last = head;

  while (c < p) {
   current = current.next;
   c++;
  }

  while (last.next != null) {
   last = last.next;
  }

  last.next = current;
  return;
 }

 public static boolean detectloop(Node head) {
  Node slow = head;
  Node fast = head.next;

  while (slow != fast) {
   if (fast == null || fast.next == null) {
    return false;
   }
   slow = slow.next;
   fast = fast.next.next;
  }

  return true;
 }

 public static int length(Node head) {
  int result = 0;
  while (head != null) {
   result++;
   head = head.next;
  }

  return result;
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int l = s.nextInt();
   Node head = new Node(s.nextInt());
   Node temp = head;
   for (int i = 0; i < l - 1; i++) {
    temp.next = new Node(s.nextInt());
    temp = temp.next;
   }

   int position = s.nextInt();

   makeloop(head, position);
   removeLoop(head);

   if (detectloop(head) || length(head) != l) {
    System.out.print("0");
   }

   else {
    System.out.print("1");
   }
   t--;
  }

  s.close();

 }

}
