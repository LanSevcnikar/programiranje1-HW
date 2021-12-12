package cheetsheet;

public class Dict {
  private static class Node {
    Object key;
    Object value;
    Node next;

    Node(Object key, Object value, Node next){
      this.key = key;
      this.value = value;
      this.next = next;
    }   
  }

  private static final int TABLE_SIZE = 100;
  private Node[] data;

  public Dict() {
    this(TABLE_SIZE);
  }

  public Dict(int table_size){
    this.data = new Node[table_size];
  }

  
  private int index(Object key){
    int n = this.data.length;
    return (key.hashCode() % n);
  }

  private Node find(Object key) {
    int index = this.index(key);
    Node node = this.data[index];
    while(node != null && !node.key.equals(key)) {
      node = node.next;
    }
    return node;
  }

  public Object getValue(Object key){
    Node node = find(key);
    if(node == null) return null;
    return node.value;
  }

  public void save(Object key, Object value){
    Node node = this.find(key);
    if(node != null){
      node.value = value;
    }else{
      int index = this.index(key);
      node = new Node(key, value, this.data[index]);
      this.data[index] = node;
    }
  }
}
