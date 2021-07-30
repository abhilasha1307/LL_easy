package LL_easy;

/*
=====================================================
PROBLEM:)
=====================================================
Given a linked list consisting of L nodes and given a number N. 
The task is to find the Nth node from the end of the linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 103
1 <= N <= 103

=======================================================
EXAMPLE : 
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
========================================================
*/

/*
=============================================================================
APPROACH:)
=============================================================================
to get the Nth node we have to first know the total number of nodes in the list
if the value of N is more than the number of total nodes we return -1 (EG: asking for 5th node from the end in a linked list w/ only 4 nodes)
'i' is the upper limit (c-n+1)
k is 1 as temp is already there on the first Node 

if temp points to null initially we can keep k = 0 and i = c-n; 
Time : O(N)
Space : O(1)
*/

/*
==================================================================================
ALTERNATE:)
===================================================================================
public static int NthNode(Node head, int n)
{
 Node temp = reverse(head);
 while(n>1 && temp != null)
 {
  temp = temp.next;
  n--
 }
 if(temp == null)
 {
  return -1;
 }
 return temp.val;
}

public static Node Reverse(Node node)
{
 Node c = node;
 Node n = node.next;
 Node p;

 while(c!=null)
 {
  c.next = p;
  p = c;
  c = n;
  if(n != null)
  {n = n.next;}
 }

 node = p;
 return node;
}

reverse the list and traverse normally 
EG:
a given list 5-10-15-20 is reversed and becomes: 20-15-10-5
to find 3rd node from end i.e. 15 here we have to traverse 3 steps in the reversed list w/o needing an additional variable 'k' and; (4-3+1) times in the original list
*/
public class p2_nth_node_from_end_ofLL extends helper {

 public static void main(String[] args) {

  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  head.next.next.next = new Node(4);
  head.next.next.next.next = new Node(5);
  head.next.next.next.next.next = new Node(6);
  head.next.next.next.next.next.next = new Node(7);
  head.next.next.next.next.next.next.next = new Node(8);
  head.next.next.next.next.next.next.next.next = new Node(9);
  int n = 2;

  System.out.println(getNthFromLast(head, n));

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

}
