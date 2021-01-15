package LINKED_LIST.LL_easy;

import java.util.Scanner;
/*
=================
PROBLEM:)
=================
Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data. Sort the linked list according to the actual values.
Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
    Output: -5 -> -3 -> -2 -> 1 -> 4
 */

/*
=======================
APPROACH:
=======================
As the list is in ascending order based on the absolute values, the negative values present will be in decreasing order
we basically have to shift the negative values to front to be the first value of the LL and keep the positive values in the same order in which they appear

we make two pointers prev(to head) and current(to head.next) 
we check if value at current is bigger than value at prev while current is not null
if yes, we make current.next point to the prev value and prev.next point to the value just after current(current.next)
we shift the head to current as this will where our list be starting from now
and then we shift the current to prev to check if the on coming values are more negative from the head value

else
we shift prev to current and current to current.next

time complexity : O(n);
Space complexity: O(1);
*/
public class p6_absolute_list_sorting {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node sortedList(Node head) {
        if (head.next == null) {
            return head;
        }
        Node prev = head;
        Node current = prev.next;

        while (current != null) {
            if (current.data < prev.data) {
                prev.next = current.next;
                current.next = head;
                head = current;
                current = prev;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    private static void printlist(Node temp) {
        if (temp == null) {
            System.out.println("null");
        }

        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
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
            Node sol = sortedList(head);
            printlist(sol);
            t--;
        }

        s.close();
    }

}