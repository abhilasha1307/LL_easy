package LL_easy;

/*
=======================================================
PROBLEM :) 1290
========================================================
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1

=================================================
EG :)

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
=================================================
*/

/*
================================================================
APPROACH:)
================================================================
We count the nodes in the list. The maximum power of base 2 will be (total nodes - 1)
Keep a counter for power (here, i) and traverse over the list where the value of the first node is multiplied by the highest power of base 2 and this is stored in a variable 'result' which will be returned

Time : O(n) + O(n) = O(n)
Space : O(1)
*/

class LL_Node {
 int data;
 LL_Node next;

 LL_Node(int data) {
  this.data = data;
  next = null;
 }
}

public class x10_Convert_Binary_Number_in_a_LL_to_Integer {

 public static void main(String[] args) {
  LL_Node head = new LL_Node(1);
  head.next = new LL_Node(0);
  head.next.next = new LL_Node(1);

  System.out.println(getDecimalValue(head));
 }

 public static int getDecimalValue(LL_Node head) {

  int nodes = count(head);
  int result = 0;
  LL_Node temp = head;
  for (int i = nodes - 1; i >= 0; i--) {
   result = result + (temp.data * (int) (Math.pow(2, i)));
   temp = temp.next;
  }

  return result;
 }

 public static int count(LL_Node node) {
  int res = 0;
  while (node != null) {
   res++;
   node = node.next;
  }
  return res;
 }

}
