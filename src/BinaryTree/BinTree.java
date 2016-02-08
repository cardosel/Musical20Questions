package BinaryTree;

public abstract interface BinTree<T>
{
  public abstract BinTreeNode<T> getRoot();
  
  public abstract void setRoot(BinTreeNode<T> paramBinTreeNode);
  
  public abstract boolean empty();
  
  public abstract LinkedList<T> inorderTraversal();
  
  public abstract LinkedList<T> preorderTraversal();
  
  public abstract LinkedList<T> postorderTraversal();
  
  public abstract String inorderString();
  
  public abstract String preorderString();
  
  public abstract String postorderString();
}
