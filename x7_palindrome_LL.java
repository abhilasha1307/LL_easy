package LINKED_LIST.LL_easy;

//done
//look for better solutions
import java.util.Scanner;
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

public class x7_palindrome_LL {
 public static class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
   this.val = val;
  }

  ListNode(int val, ListNode next) {
   this.val = val;
   this.next = next;
  }
 }

 public static boolean isPalindrome(ListNode head) {

  if (head == null) {
   return false;
  }

  ListNode mid = middleNode(head);
  ListNode second = reverse(mid.next);
  mid.next = second; // to bring second to mid.next again

  ListNode t1 = head;
  ListNode t2 = second;

  while (t1 != second && t2 != null) {
   if (t1.val != t2.val) {
    return false;
   }
   t1 = t1.next;
   t2 = t2.next;
  }

  return true;
 }

 static ListNode middleNode(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  while (fast.next != null && fast.next.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }

  return slow;
 }

 static ListNode reverse(ListNode head) {
  ListNode c = head;
  ListNode p = null;
  ListNode n = null;

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
  Scanner s = new Scanner(System.in);
  int l1 = s.nextInt();
  ListNode h1 = new ListNode(s.nextInt());
  ListNode a1 = h1;
  while (l1 > 0) {
   a1.next = new ListNode(s.nextInt());
   a1 = a1.next;
   l1--;
  }
  boolean value = isPalindrome(h1);
  System.out.println(value);
  s.close();
 }
}
