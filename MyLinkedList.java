class MyLinkedList{

  class Node{
    private Integer data;
    private Node next,prev;

    public Node(Node p, int d, Node n){
      prev = p;
      data = d;
      next = n;
    }

    public Node prev(){
      return prev;
    }
    public Integer getData(){
      return data;
    }
    public Node next(){
      return next;
    }

    public void setPrev(Node p){
      prev = p;
    }
    public void setData(Integer i){
      data = i;
    }
    public void setNext(Node n){
      next = n;
    }

    public String toString(){
    return "";
    }
  }

  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(Integer value){
    if (size == 0){
      Node newNode = new Node(null, value, null);
      start = newNode;
      end = newNode;
    } else {
      Node newEnd = new Node(end, value, null);
      end.setNext(newEnd);
    }
    size++;
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

  private Node getNthNode(int i){
    int index = 0;
    Node current = start;
    while(index < i){
      current = current.next();
    }
    return current;
  }

  public Integer get(int index){
    Node current = getNthNode(index);
    return current.getData();
  }

  public Integer set(int index, Integer value){
    Node current = getNthNode(index);
    Integer old = current.getData();
    current.setData(value);
    return old;
  }

  public boolean contains(Integer value){
    Node current = start;
    while(current.next() != null){
      if(current.getData() == value){
        return true;
      }
      current = current.next();
    }
    return current.getData() == value;
  }

  public int indexOf(Integer value){
    Node current = start;
    int index = -1;
    while(current.next() != null){
      if(current.getData() == value){
        index = current.getData();
        return index;
      }
      current = current.next();
    }
    return index;
  }

  public void add(int index, Integer value){
    if(index == 0){
      Node newNode = new Node(null, value, start);
      start.setPrev(newNode);
    }else if(index == size - 1){
      add(value);
    }else{
      Node prev = getNthNode(index);
      Node next = prev.next();
      Node newNode = new Node(prev, value, next);
      prev.setNext(newNode);
      next.setPrev(newNode);
    }
  }

  public Integer remove(int index){
    if(index == 0){

    }else if(index == size - 1){

    }else{
      Node removing = getNthNode(index);
      Integer old = removing.getData();
      Node prev = removing.prev();
      Node next = removing.next();
      prev.setNext(next);
      next.setPrev(prev);
      return old;
    }
    return 1;
  }

}
