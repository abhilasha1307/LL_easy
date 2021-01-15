package LINKED_LIST.LL_easy;

//new concept of concatenation and string.charat() function 
import java.util.Scanner;

/*
==================
PROBLEM:)
==================
Given a linked list of strings having n nodes check to see whether the combined string formed is palindrome or not. 
EG: abccba 
eg: madam 
*/

/*
============
APPROACH:
============
we have to first convert the given LL into string
we take a string variable 'a' and append/concatenate the value in each node of linked list into 'a'

with a for loop we check if the char at i as same as character at l-i-1 till we reach l/2

time Complexity:
sapce Complexity: O(1)
*/
public class p7_LL_of_strings_isa_palindrome {

 public static class Node {
  String data;
  Node next;

  Node(String x) {
   data = x;
   next = null;
  }
 }

 public static boolean compute(Node head) {
  if (head == null) {
   return false;
  }
  Node t = head;
  String a = "";
  while (t != null) {
   a = a.concat(t.data);
   t = t.next;
  }

  int l = a.length();
  for (int i = 0; i < l / 2; i++) {
   if (a.charAt(i) != a.charAt(l - i - 1)) {
    return false;
   }
  }
  return true;
 }

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  while (t > 0) {
   int n = s.nextInt();
   Node head = new Node(s.next());
   Node temp = head;
   while (n-- > 0) {
    temp.next = new Node(s.next());
    temp = temp.next;
   }
   boolean val = compute(head);
   System.out.println(val);
   t--;
  }

  s.close();
 }
}
