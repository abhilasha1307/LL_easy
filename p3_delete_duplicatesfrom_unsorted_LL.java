package LL_easy;

import java.util.*;
/*
=====================================
PROBLEM:)
=====================================
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= size of linked lists <= 106
0 <= numbers in list <= 104

==================================================
EXAMPLES:
N = 4
value[] = {5,2,2,4}
Output: 5 2 4

N = 5
value[] = {2,2,2,2,2}
Output: 2
=====================================================
*/

/*
=========================================================
APPROACH:)
=========================================================
we make two nodes : current (points to head) and prev
we use a hashSet to store the current node's value in the set (if its not present in the set)
if the value of the current node is not present, we store it in the set and make prev point to current and current to current.next
if the value of current node is in set already, we make previous's next point to the current's next and move current pointer ahead too
this way, the duplicate node, will be picked by by GC, as there is no variable or node pointing to it


Time :  O(N) on average (assuming that hash table access time is O(1) on average)
Space : O(N)
*/
public class p3_delete_duplicatesfrom_unsorted_LL extends helper {

  public static void main(String[] args) {
    Node head = new Node(5);
    head.next = new Node(2);
    head.next.next = new Node(2);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(4);

    printlist(removeDuplicates(head));
  }

  static Node removeDuplicates(Node head) {
    // Hash to store seen values
    HashSet<Integer> hs = new HashSet<>();

    /* Pick elements one by one */
    Node current = head;
    Node prev = null;
    while (current != null) {
      int curval = current.data;

      // If current value is seen before
      if (hs.contains(curval)) {
        prev.next = current.next;
      } else {
        hs.add(curval);
        prev = current;
      }
      current = current.next;
    }
    return head;
  }

  static void printlist(Node temp) {
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println("\n");
  }
}
