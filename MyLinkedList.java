class MyLinkedList{
  class Node{
    private int data;
    private Node next,prev;

    public Node(int d, Node n, Node p){
      data = d;
      next = n;
      prev = p;
    }
  }
   private int size;
   private Node start,end;

   public int size(){
     return size;
   }
   public boolean add(int value){
     return true;
   }
   public String toString(){
     return "";
   }
}
