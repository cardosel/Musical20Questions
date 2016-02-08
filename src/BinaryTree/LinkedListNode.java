package BinaryTree;

public class LinkedListNode<T>
{
  private T data;
  private LinkedListNode<T> next;
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public void setData(T data)
  {
    this.data = data;
  }
  
  public LinkedListNode<T> getNext()
  {
    return this.next;
  }
  
  public void setNext(LinkedListNode<T> node)
  {
    this.next = node;
  }
  
  public String toString()
  {
    return this.data.toString();
  }
}