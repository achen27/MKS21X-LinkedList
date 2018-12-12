class MyLinkedList{
  class Node{
    private int data;
    private Node next,prev;

    public Node(int d, Node n, Node p){
      data = d;
      next = n;
      prev = p;
    }

    public int getData(){
      return data;
    }

    public Node getNext(){
      return next;
    }

    public Node getPrev(){
      return prev;
    }

    public void setData(int d){
      data = d;
    }

    public void setNext(Node n){
      next = n;
    }

    public void setPrev(Node p){
      prev = p;
    }
  }
  private int size;
  private Node start,end;

  public int size(){
    return size;
  }
  public boolean add(int value){
    Node newEnd = new Node(value, end, null);
    end.setNext(newEnd);
    return true;
  }
  public String toString(){
    String output = "";
    Node current = start;
    while(current.getNext() != null){
      output += current.getData() + ", ";
      current = current.getNext();
    }
    output += end.getData();
    return output;
  }
}
