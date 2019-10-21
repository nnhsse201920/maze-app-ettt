class Node<T> {
    T key;
    Node next;

    public Node(T key)
    {
        this.key = key;
        this.next = null;
    }
    public Node()
    {
        this.key = null;
        this.next = null;
    }
} 
  