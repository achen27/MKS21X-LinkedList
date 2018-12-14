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
    return "[" + data + "]";
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
      end = newEnd;
    }
    size++;
    return true;
  }

  public String toString(){
    if (size == 0){
      return "[]";
    } else{
      String output = "[";
      Node current = start;
      while(current.next() != null){
        output += current.getData() + ", ";
        current = current.next();
      }
      output += end.getData() + "]";
      return output;
    }
  }

  private Node getNthNode(int i){
    //System.out.println(this);
    int index = 0;
    Node current = start;
    while(index < i){
      //System.out.println(index);
      current = current.next();
      index++;
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
      Node prev = getNthNode(index-1);
      Node next = prev.next();
      Node newNode = new Node(prev, value, next);
      prev.setNext(newNode);
      next.setPrev(newNode);
    }
  }

  public Integer remove(int index){
    if(index == 0){
      Node removing = start;
      Integer old = start.getData();
      Node next = start.next();
      start = next;
      return old;
    }else if(index == size - 1){
      Node removing = end;
      Integer old = end.getData();
      Node prev = start.prev();
      end = prev;
      return old;
    }else{
      Node removing = getNthNode(index);
      Integer old = removing.getData();
      Node prev = removing.prev();
      Node next = removing.next();
      prev.setNext(next);
      next.setPrev(prev);
      return old;
    }
  }

  public boolean remove(Integer value){
    int index = 0;
    Node current = start;
    while(current.next() != null && current.getData() != value){
      index++;
      current = current.next();
    }
    if (index < size - 1 || current.getData() == value){
      remove(index);
      return true;
    }
    return false;
  }

}
