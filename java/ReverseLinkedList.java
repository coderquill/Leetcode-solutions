/*https://leetcode.com/discuss/interview-question/124617/Print-out-an-immutable-singly-linked-list-in-reverse/*/

import java.util.*;

class ReverseLinkedList{

  public static class Node{
    int data;
    Node next;
  }

  public static Node reverse(Node root){
    Node cur = new Node();
    Node prev = new Node();
    Node nextNode = new Node();
    cur = root;
    prev = null;

    while(cur!=null){
      nextNode = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nextNode;
    }
    root = prev;
    return root;
  }

  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Node curNode = new Node();
    Node root= new Node();
    for(int i= 0; i<n; i++){
      int k = scan.nextInt();
      if(i == 0){
          Node temp = new Node();
          temp.data = k;
          temp.next = null;
          root = temp;
          curNode = root;
      }else{
        Node newNode = new Node();
        newNode.data = k;
        newNode.next = null;
        curNode.next = newNode;
        curNode = newNode;
      }
    }
    Node temp = new Node();
    temp = root;
    while(temp!=null){
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    Node rHead = new Node();
    rHead = reverse(root);

    System.out.println();

    temp = rHead;
    while(temp!=null){
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
  }
}
