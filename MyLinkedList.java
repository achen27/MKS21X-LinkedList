class MyLinkedList{

  class Node{
    private Interger data;
    private Node next,prev;

    public Node(int d, Node n, Node p){
      data = d;
      next = n;
      prev = p;
    }

    public int getData(){
      return data;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }

    public void setData(Integer i){
      data = i;
    }
    public void setNext(Node n){
      next = n;
    }
    public void setPrev(Node p){
      prev = p;
    }

    public String toString(){
    return "";
    }
  }

  private int size;
  private Node start,end;

  //public MyLinkedList();

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
    while(current.next() != null){
      output += current.getData() + ", ";
      current = current.next();
    }
    output += end.getData();
    return output;
  }

}
