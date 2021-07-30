package LL_easy;

//done
//look for better solutions
/*
==================
PROBLEM:)
======================
Given a singly linked list, determine if it is a palindrome.
eg:
1->2->2->1
Output: true

1-2-3-2-1 is also a palindrome
*/

/*
====================
APPROACH:) 
===================

find middle node and reverse the list from there on
we make a node mid and store the middle node in it
we make a node reverse and we will reverse the list after the middle node not from middle node
we will place two temp nodes at head and second (t1 an t2)
while t1 is not scond and t2 is not null, for every element encountered we check if they are not same and if true we return false
but if we go through the list without above condition getting encountered even once, the list is a palindrome. return true

time: O(n) //check
space: O(1)
*/

public class x7_palindrome_LL extends helper {

 public static boolean isPalindrome(Node head) {

  if (head == null) {
   return false;
  }

  Node mid = middleNode(head);
  Node second = reverse(mid.next);
  mid.next = second; // to bring second to mid.next again

  Node t1 = head;
  Node t2 = second;

  while (t1 != second && t2 != null) {
   if (t1.data != t2.data) {
    return false;
   }
   t1 = t1.next;
   t2 = t2.next;
  }

  return true;
 }

 static Node middleNode(Node head) {
  Node slow = head;
  Node fast = head;
  while (fast.next != null && fast.next.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }

  return slow;
 }

 static Node reverse(Node head) {
  Node c = head;
  Node p = null;
  Node n = null;

  while (c != null) {
   n = c.next;
   c.next = p;
   p = c;
   c = n;
  }

  head = p;
  return head;
 }

 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(1);

  System.out.println(isPalindrome(head));

 }
}
