package BinaryTree;

public abstract interface BinTreeNode<T>
{
  public abstract T getData();
  
  public abstract BinTreeNode<T> getLeftChild();
  
  public abstract BinTreeNode<T> getRightChild();
  
  public abstract void setLeftChild(BinTreeNode<T> paramBinTreeNode);
  
  public abstract void setRightChild(BinTreeNode<T> paramBinTreeNode);
  
  public abstract boolean isLeaf();
}
