package BinaryTree;

public class DefaultBinTreeNode<T>
  implements BinTreeNode<T>
{
  private T data;
  private BinTreeNode<T> leftChild;
  private BinTreeNode<T> rightChild;
  
  public DefaultBinTreeNode(T data)
  {
    this.data = data;
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public BinTreeNode<T> getLeftChild()
  {
    return this.leftChild;
  }
  
  public BinTreeNode<T> getRightChild()
  {
    return this.rightChild;
  }
  
  public void setLeftChild(BinTreeNode<T> left)
  {
    this.leftChild = left;
  }
  
  public void setRightChild(BinTreeNode<T> right)
  {
    this.rightChild = right;
  }
  
  public boolean isLeaf()
  {
    return (this.leftChild == null) && (this.rightChild == null);
  }
}
