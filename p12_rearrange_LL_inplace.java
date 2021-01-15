package LINKED_LIST.LL_easy;

//done
import java.util.Scanner;
/*
PROBLEM:)
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. 
Rearrange the nodes in the list so that the new formed list is: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2.
*/

/*
APPROACH:
 
*/
public class p12_rearrange_LL_inplace {

   static class Node {
      int data;
      Node next;

      Node(int d) {
         data = d;
         next = null;
      }
   }

   public static Node reorderlist(Node head) {

      Node first = head;
      Node t = MiddleNode(head);
      Node temp = t.next;
      t.next = null;
      Node second = reverseList(temp);

      Node a = first;
      Node b = second;

      while (a != null && b != null) {
         Node n1 = a.next;
         Node n2 = b.next;

         a.next = b;
         b.next = n1;
         a = n1;
         b = n2;
      }

      while (a != null) {
         a = a.next;
      }

      return first;
   }

   public static Node MiddleNode(Node head) {
      Node slow = head;
      Node fast = slow.next;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;
   }

   public static Node reverseList(Node head) {
      Node curr = head;
      Node next = null, prev = null;

      while (curr != null) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      head = prev;

      return head;
   }

   static void printList(Node head) {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
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

         Node head = reorderlist(h1);
         printList(head);
      }

      s.close();
   }

}