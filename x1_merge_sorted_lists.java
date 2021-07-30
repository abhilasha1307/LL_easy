package LL_easy;

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

/*
==================================================================
ALTERNATE APPROACH: Time : O(m+n), Space: O(1)
====================================================================
public static Node sortedMerge(Node A, Node B)
{
  if(A == null)
  {
    return B;
  }
  if(B == null)
  {
    return A;
  }

  if(A.data<B.data)
  {
    A.next = sortedMerge(A.next, B);
    return A;
  }
  else
  {
    B.next = sortedMerge(A, B.next);
    return B:
  }

}
*/
public class x1_merge_sorted_lists extends helper {

  public static void main(String[] args) {
    Node A = new Node(5);
    A.next = new Node(10);
    A.next.next = new Node(15);
    A.next.next.next = new Node(40);

    Node B = new Node(2);
    B.next = new Node(3);
    B.next.next = new Node(20);

    Node res = mergeTwoLists(A, B);
    while (res != null) {
      System.out.print(res.data + " ");
      res = res.next;
    }
  }

  public static Node mergeTwoLists(Node A, Node B) {
    Node result = new Node(0);
    Node tail = result;

    while (true) {
      if (A == null) {
        tail.next = B;
        break;
      }

      if (B == null) {
        tail.next = A;
        break;
      }

      if (A.data <= B.data) {
        tail.next = A;
        A = A.next;
      }

      else {
        tail.next = B;
        B = B.next;
      }

      tail = tail.next;
    }

    return result.next;
  }

}
