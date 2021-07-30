package LL_easy;

//done; explain ur and alternative approach
import java.util.Scanner;

/*
PROBLEM:) 
Reverse a DLL
eg: Input:
LinkedList: 75 <--> 122 <--> 59 <--> 196
Output: 196 59 122 75
*/

/*
APPROACH:)
we take three nodes p(to head), c(to p.next), n(to c.next)
we make a seperate case for when there are only 2 elements in the linked list 

for LL having 3 or more elements:

we change the p.prev and c.next of elements till n is not null
only n is null(when there are only 2 elements left) we change the p.prev and c.next for then and
then sever the link p.prev.prev between them to point to null
and shift head to the last element i.e. p.prev

time Complexity: O(n)
space Complexity: O(1)

*/
public class p8_reverse_DLL {

 public static class Node {
  int data;
  Node prev, next;

  Node(int x) {
   data = x;
   prev = null;
   next = null;
  }
 }

 public static Node reverseDLL(Node head) {
  if (head == null || head.next == null) {
   return head;
  }

  Node p = head;
  Node c = p.next;
  Node n = c.next;

  if (head.next.next == null) { // if LL has only two elements
   p.prev = c;
   c.next = p;
   p.next = null;
   c.prev = null;
   head = c;
   return head;
  }

  while (n != null) {
   p.prev = c;
   c.next = p;
   if (p == head) {
    p.next = null;
   }
   p = c;
   c = n;
   n = n.next;
  }

  p.prev = c;
  c.next = p;
  p.prev.prev = null; // to sever the one link between last two nodes else there will be a loop
                      // between them
  head = p.prev; // head points to last element of LL

  return head;
 }

 static void printlist(Node head) {
  if (head == null) {
   System.out.println("null");
  } else {
   while (head.next != null) {
    System.out.print(head.data);
    head = head.next;
   }
   System.out.println(head.data);
   System.out.println("\n");
  }
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t-- > 0) {
   Node head = null;
   Node tail = null;
   int n = s.nextInt();
   while (n-- > 0) {
    int i = s.nextInt();
    if (head == null) {
     head = new Node(i);
     tail = head;
    } else {
     tail.next = new Node(i);
     tail.next.prev = tail;
     tail = tail.next;
    }
   }
   Node sol = reverseDLL(head);
   printlist(sol);
  }
  s.close();

 }
}

// alternate code
/*
 * void reverse() { Node temp = null; Node current = head;
 * 
 * 
 * while(current!=null) { temp = current.prev; current.prev = current.next;
 * current.next = temp; current = current.prev; }
 * 
 * 
 * if(temp!=null) { head = temp.prev; }
 */
