package LINKED_LIST.LL_easy;

//done; explain approach
import java.util.Scanner;

/*
PROBLEM:)
Given a linked list consisting of L nodes and given a number N. 
The task is to find the Nth node from the end of the linked list.
 */

/*
APPROACH:)
to get the Nth node we have to first know the total number of nodes in the list
if the value of N is more than the number of total nodes we return -1 (EG: asking for 5th node from the end in a linked list w/ only 4 nodes)
'i' is the upper limit (c-n+1)
k is 1 as temp is already there on the first Node 

if temp points to null initially we can keep k = 0 and i = c-n; 
*/
/*
ALTERNATE:)
reverse the list and traverse normally 
EG:
a given list 5-10-15-20 is reversed and becomes: 20-15-10-5
to find 3rd node from end i.e. 15 here we have to traverse 3 steps in the reversed list w/o needing an additional variable 'k' and; (4-3+1) times in the original list

loop is : while(n-->1) as temp is already at first node and we need to go ahead 2 steps to find 3rd node from end.
*/
public class p2_nth_node_from_end_ofLL {

 static class Node {
  int data;
  Node next;

  Node(int x) {
   data = x;
   next = null;
  }
 }

 static int getNthFromLast(Node head, int n) {
  int c = 0;
  Node temp = head;
  while (temp != null) {
   c++;
   temp = temp.next;
  }

  if (c < n) {
   return -1;
  }

  temp = head;
  int i = c - n + 1;
  int k = 1;
  while (k < i) {
   temp = temp.next;
   k++;
  }
  return temp.data;
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
   int k = s.nextInt();
   int sol = getNthFromLast(head, k);
   System.out.println(sol);
   t--;
  }
  s.close();
 }
}