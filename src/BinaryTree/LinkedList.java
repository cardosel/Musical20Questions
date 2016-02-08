package BinaryTree;

import java.io.PrintStream;

public class LinkedList<T>
{
  private LinkedListNode<T> head;
  
  public T getFirst()
  {
    return (T)this.head.getData();
  }
  
  public LinkedListNode<T> getFirstNode()
  {
    return this.head;
  }
  
  public T getLast()
  {
    LinkedListNode<T> node = getLastNode();
    
    return (T)node.getData();
  }
  
  public LinkedListNode<T> getLastNode()
  {
    LinkedListNode<T> node = this.head;
    if (isEmpty()) {
      System.err.println("getLast was called and there aren't any nodes!");
    } else {
      while (node.getNext() != null) {
        node = node.getNext();
      }
    }
    return node;
  }
  
  public void insertFirst(T data)
  {
    LinkedListNode<T> node = new LinkedListNode();
    
    node.setData(data);
    
    insertFirstNode(node);
  }
  
  public void insertFirstNode(LinkedListNode<T> node)
  {
    node.setNext(this.head);
    
    this.head = node;
  }
  
  public void insertAfter(LinkedListNode<T> currentNode, T data)
  {
    LinkedListNode<T> node = new LinkedListNode();
    
    node.setData(data);
    
    insertNodeAfter(currentNode, node);
  }
  
  public void insertNodeAfter(LinkedListNode<T> currentNode, LinkedListNode<T> node)
  {
    node.setNext(currentNode.getNext());
    
    currentNode.setNext(node);
  }
  
  public void insertLast(T data)
  {
    LinkedListNode<T> newNode = new LinkedListNode();
    
    newNode.setData(data);
    
    insertLastNode(newNode);
  }
  
  public void insertLastNode(LinkedListNode<T> newNode)
  {
    LinkedListNode<T> currentNode = this.head;
    if (isEmpty())
    {
      this.head = newNode;
    }
    else
    {
      while (currentNode.getNext() != null) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(newNode);
    }
  }
  
  public void deleteFirst()
  {
    this.head = this.head.getNext();
  }
  
  public void deleteLast()
  {
    LinkedListNode<T> node = this.head;
    while (node.getNext().getNext() != null) {
      node = node.getNext();
    }
    node.setNext(null);
  }
  
  public void deleteNext(LinkedListNode<T> currentNode)
  {
    currentNode.setNext(currentNode.getNext().getNext());
  }
  
  public int size()
  {
    int length = 0;
    
    LinkedListNode<T> node = this.head;
    while (node != null)
    {
      length++;
      
      node = node.getNext();
    }
    return length;
  }
  
  public boolean isEmpty()
  {
    if (this.head == null) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    LinkedListNode<T> node = this.head;
    
    String representation = "";
    if (isEmpty())
    {
      representation = "Nothing to see here!";
    }
    else
    {
      while (node.getNext() != null)
      {
        representation = representation + node.toString() + " -> ";
        
        node = node.getNext();
      }
      representation = representation + node.toString();
    }
    return representation;
  }
  
  public String minimalString()
  {
    LinkedListNode<T> node = this.head;
    String minStr = "";
    if (!isEmpty())
    {
      while (node.getNext() != null)
      {
        minStr = minStr + node.toString() + " ";
        node = node.getNext();
      }
      minStr = minStr + node.toString();
    }
    return minStr;
  }
}