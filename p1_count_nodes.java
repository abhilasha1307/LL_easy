package LINKED_LIST.LL_easy;

//done 
import java.util.Scanner;

/* 
PROBLEM:) Given a singly linked list. 
The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.
*/

/*
APPROACH:)
make a int variable count and count nodes till the temp Node(which points to head) becomes null

time Complexity : O(n); n is the number of nodes
spcace is constant O(1)

ALTERNATIVE APPROACH:)
we can solve the problem recursively too
if head is null we return zero as no nodes are present
else 
we make a temp Node point to head and for each recursive call we +1 to count the value to be returned.

time complexity ; //write recursive eq.
space complexity : O(n)
*/
public class p1_count_nodes {

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static int Count(Node head) {
    Node temp = head;
    int count = 0;
    while (temp != null) {

      count++;
      temp = temp.next;
    }
    return count;
    /*
     * recursive approach: if(head == null) { return 0; } Node temp = head; return 1
     * + Count(temp.next);
     */
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    int i = 0;
    Node head = new Node(s.nextInt());
    Node tail = head;
    for (; i < t - 1; i++) {
      tail.next = new Node(s.nextInt());
      tail = tail.next;
    }

    int x = Count(head);
    System.out.println("No. of nodes is:" + x);
    s.close();
  }
}
