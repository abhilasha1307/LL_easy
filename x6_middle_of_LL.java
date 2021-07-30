package LL_easy;

//done
import java.util.Scanner;
/*
PROBLEM:)  #876 (EASY)
Given a non-empty, singly linked list with head node, return a middle node of linked list.
If there are two middle nodes, return the second middle node.
*/

/*
================
APPROACH:)
================
count the total nodes 
if the total nodes are even we have to place the pointer on the second middle node (eg: in 1-2-3-4 node will be placed at 3 and not two, result: 3-4)
with even nodes we traverse till we reach second middle node
with odd total nodes, we traverse till we just get to the middle node
return the node 't'
print the list from middle node returned

time: O(n) //check
space: O(1)

*/

/*
=================
ALTERNATE CODE:
=================
slow = head
fast = head

while(fast.next !=null && fast != null)
{
 slow = slow.next;
 fast = fast.next.next;
}
return slow;
*/

public class x6_middle_of_LL {

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

 public static ListNode middleNode(ListNode head) {
  ListNode t = head; // t is temp node
  int count = 0;
  while (t != null) {
   count++;
   t = t.next;
  }
  t = head;

  if (count % 2 == 0) {
   int n = 1;
   int i = (count / 2) + 1;
   while (n < i) {
    t = t.next;
    n++;
   }
   return t;
  }

  else {
   int k = 1;
   int c = (int) (count / 2 + 1);
   while (k < c) {
    t = t.next;
    k++;
   }
  }
  return t;
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
  ListNode sol = middleNode(h1);
  while (sol != null) {
   System.out.println(sol.val);
   sol = sol.next;
  }
  s.close();
 }
}
