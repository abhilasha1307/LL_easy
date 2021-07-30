package LL_easy;

//done; see if GFG solution is better in terms of time
import java.util.Scanner;
/*
==========
PROBLEM:)
==========
Given a singly linked list of size N. 
The task is to rotate the linked list counter-clockwise by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
**k should be less than or equal to count of nodes.**

eg:
Input:
N = 8
value[] = {1,2,3,4,5,6,7,8}
k = 4
Output: 5 6 7 8 1 2 3 4
*/

/*
===========
APPROACH:
===========
rotating CCW means that for a given 'k' we have to make elements before 'k' go to the end and elements after k should come in front

first we count the number of nodes; k shd be less than this and greater than 0
we set 2 temperory nodes temp1 (at element just before which all elements are to be sent to the back, here,4) 
and temp2 (at element just after which all element are to be brought in front, here, 5)

we make temp1.next (after above traversal) = null as temp1 is going to be the last element after rotation is compelete

we make another temp node temp3 which points to temp2 and will traverse till the last element, here, 8
now we link temp3.next to head and shift the head pointer to temp2

return head and print the rotated list

time complexity: O(n) list is traversed 4 times in the rotate funtion below 
space complexity: O(1)

*/

/*
===========
ALTERNATE: ONLY 2 TRAVERSALS OF THE LIST [COMPLEXITY O(N)]
===========
void rotate(int k) 
    { 
        if (k == 0) 
            return; 
  
        // Let us understand the below code for example k = 4 
        // and list = 10->20->30->40->50->60. 
        Node current = head; 
  
        // current will either point to kth or NULL after this 
        // loop. current will point to node 40 in the above example 
        int count = 1; 
        while (count < k && current != null) { 
            current = current.next; 
            count++; 
        } 
  
        // If current is NULL, k is greater than or equal to count 
        // of nodes in linked list. Don't change the list in this case 
        if (current == null) 
            return; 
  
        // current points to kth node. Store it in a variable. 
        // kthNode points to node 40 in the above example 
        Node kthNode = current; 
  
        // current will point to last node after this loop 
        // current will point to node 60 in the above example 
        while (current.next != null) 
            current = current.next; 
  
        // Change next of last node to previous head 
        // Next of 60 is now changed to node 10 
  
        current.next = head; 
  
        // Change head to (k+1)th node 
        // head is now changed to node 50 
        head = kthNode.next; 
  
        // change next of kth node to null 
        kthNode.next = null; 
    } 

*/
public class p5_rotate_LL {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static Node rotate(Node head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        Node t = head;
        while (t != null) {
            count++;
            t = t.next;
        }

        if (k == 0) {
            return head;
        }

        if (k >= count) {
            return head;
        }

        int n = k;
        Node temp1 = head;
        Node temp2 = head;
        while (n > 0) {
            temp2 = temp2.next;
            n--;
        }

        n = k - 1;
        while (n-- > 0) {
            temp1 = temp1.next;
        }
        temp1.next = null;

        Node temp3 = temp2;
        while (temp3.next != null) {
            temp3 = temp3.next;
        }
        temp3.next = head;
        head = temp2;

        return head;
    }

    static void printlist(Node head) {
        if (head == null) {
            System.out.println("null");
        }
        Node t = head;
        while (t != null) {
            System.out.println(t.data + " ");
            t = t.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            Node head = new Node(s.nextInt());
            Node temp = head;
            while (n-- > 0) {
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }

            int k = s.nextInt();

            Node sol = rotate(head, k);
            printlist(sol);
            t--;
        }

        s.close();
    }
}
