import java.util.*;

public class LlPractice {

  public static void main(String[] args) {
    
    Node n1 = new Node(5);
    Node n2 = new Node(4);
    Node n3 = new Node(7);
    Node n4 = new Node(3);
    Node n5 = new Node(6);
    Node n6 = new Node(15);

    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);
    n5.setNext(n6);
    
    Node result = getKthFromLast1(n1, 2);
    System.out.println(result.getValue());

    /*
    removeDuplicates(n1);
    while (n1 != null) {
      System.out.print(n1.getValue() + " ");
      n1 = n1.getNext(); 
    }
    System.out.println();
    */
  }

  private static Node getKthFromLast1(Node node, int k) {
     
    Node curr = node;
    int size = 0;

    while (curr != null) {
      size++;
      curr = curr.getNext();
    }

    if (k > size) {
      return null;
    }

    int requiredNode = size - k;
    
    for (int skip = 1; skip < requiredNode; skip++) {
      node = node.getNext();
    }
    return node;
  } 

  private static void removeDuplicates(Node node) {

    Set<Integer> valueSet = new HashSet<Integer>();
    Node prev = null;
    Node curr = node;

    while (curr != null) {
      if (valueSet.contains(curr.getValue())) {
        prev.setNext(curr.getNext());
      } else {
        valueSet.add(curr.getValue());
        prev = curr;
      }
      curr = curr.getNext();
    }
  }
  
}
