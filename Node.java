public class Node {
    
    private int value;
    private Node next;
    
    public Node(int value) {
      this.value = value;
      next = null;
    }

    public void setValue(int newValue) {
      value = newValue;
    }

    public int getValue() {
      return value;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public Node getNext() {
      return next;
    }
}
