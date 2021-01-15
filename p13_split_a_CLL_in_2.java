package LINKED_LIST.LL_easy;

//done
import java.util.Scanner;
/*
===============
PROBLEM:)
==============
Given a Cirular Linked List split it into two halves circular lists. 
If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists, first list should have one node more than the second list. The resultant lists should also be circular lists and not linear lists.

eg: 1 5 7

op : 1 5
     7
*/

/*
============
APPROACH:
============
firstly we have to make the list circular.
here we have made 3 instance variables: head, head1, head2

as the return type for splitList function is void we will have to use objects to reflect changes made to achieve the objective of the question

we will make head1 point to the 1st node of LL i.e. 'head'
and head2 points to the node just after the middle node of the list

t1 is the temp node for head1 and t2 for head2;

we need to shift t1 forward till t1.next is not head2
we will make the next part of this node point to head1 hence making the first part of the LL circular

as the list is already circular, with t2 we need to traverse till the last element of the said LL i.e. till t2.next != List.head1 
and then when we reach the required node we link it to head2 (t2.next = List.head2)

return control to main

time : O(n) //check
space : O(1) 
*/
public class p13_split_a_CLL_in_2 {

     Node head1;
     Node head2;
     Node head;

     static class Node {
          int data;
          Node next;

          Node(int x) {
               data = x;
               next = null;
          }
     }

     static void splitList(p13_split_a_CLL_in_2 List) {

          if (List.head == null) {
               return;
          }
          List.head1 = List.head;
          List.head2 = middleNode(List.head);
          Node t1 = List.head1;
          while (t1.next != List.head2) {
               t1 = t1.next;
          }
          t1.next = List.head1;

          Node t2 = List.head2;
          while (t2.next != List.head1) {
               t2 = t2.next;
          }

          t2.next = List.head2;

          return;
     }

     static void Circular(Node head) {
          Node last = head;
          while (last.next != null) {
               last = last.next;
          }
          last.next = head;

          return;
     }

     public static Node middleNode(Node head) {
          Node slow = head;
          Node fast = head;

          while (fast.next != head && fast.next.next != head) {
               slow = slow.next;
               fast = fast.next.next;
          }

          slow = slow.next;
          return slow;

     }

     static void printlist(Node head) {
          Node t = head;
          while (t.next != head) {
               System.out.print(t.data + " ");
               t = t.next;
          }
          System.out.print(t.data);
     }

     public static void main(String[] args) {
          p13_split_a_CLL_in_2 list = new p13_split_a_CLL_in_2();
          Scanner s = new Scanner(System.in);
          int t = s.nextInt();
          while (t > 0) {
               int l = s.nextInt();
               list.head = new Node(s.nextInt());
               Node temp = list.head;
               while (l-- > 0) {
                    temp.next = new Node(s.nextInt());
                    temp = temp.next;
               }

               Circular(list.head);

               splitList(list);

               printlist(list.head1);
               System.out.println();
               printlist(list.head2);
               t--;
          }
          s.close();
     }
}
