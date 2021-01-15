// done
package LINKED_LIST.LL_easy;

import java.util.Scanner;

/* 
=================
PROBLEM:) #21 easy
=================
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
Eg:) l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
 */

/*
==========
APPROACH: 
==========
here we make a separate LL to store the elements from both LLs
s1 and s2 r the temp nodes for l1 and l2
for the first element we compare them and put the smaller one as first in the new LL
and shift the node ahead in the list whose data is inserted

we make a temp node ptrNode that points to l3

we compare elements in given 2 lists, making new nodes for additional list, linking them and storing data as required. this is done till one list is over

if lists are of unequal lenghts, we simply insert the remaining elements of the longer list till we reach null (they already sorted(see ques))

time Complexity: O(m+n) m and n are number of elements in both lists

space complexity: O(m+n) : new list will contain elements of both given lists combined
*/
public class x1_merge_sorted_lists {
  public static class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static Node mergeTwoLists(Node l1, Node l2) {
    Node s1 = l1;
    Node s2 = l2;
    if (s1 == null && s2 == null) {
      return s1;
    }

    if (s1 == null) {
      return s2;
    }
    if (s2 == null) {
      return s1;
    }

    Node l3;
    if (s1.data <= s2.data) {
      l3 = new Node(s1.data);
      s1 = s1.next;
    } else {
      l3 = new Node(s2.data);
      s2 = s2.next;
    }

    Node ptrNode = l3;

    while (s1 != null && s2 != null) {
      if (s1.data <= s2.data) {
        Node temp = new Node(s1.data);
        ptrNode.next = temp;
        ptrNode = temp;
        s1 = s1.next;
      } else {
        Node temp = new Node(s2.data);
        ptrNode.next = temp;
        ptrNode = temp;
        s2 = s2.next;
      }
    }
    while (s1 != null) {
      Node temp = new Node(s1.data);
      ptrNode.next = temp;
      ptrNode = temp;
      s1 = s1.next;
    }
    while (s2 != null) {
      Node temp = new Node(s2.data);
      ptrNode.next = temp;
      ptrNode = temp;
      s2 = s2.next;
    }
    return l3;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int l1 = s.nextInt();
    int l2 = s.nextInt();
    int x = l1 + l2;
    Node h1 = new Node(s.nextInt());
    Node a1 = h1;
    Node h2 = new Node(s.nextInt());
    Node a2 = h2;
    while (l1 > 0) {
      a1.next = new Node(s.nextInt());
      a1 = a1.next;

      l1--;
    }
    while (l2 > 0) {
      a2.next = new Node(s.nextInt());
      a2 = a2.next;
      l2--;
    }
    Node sol = mergeTwoLists(h1, h2);
    while (x-- > 0) {
      System.out.println(sol.data + " ");
      sol = sol.next;
    }
    s.close();
  }

}
