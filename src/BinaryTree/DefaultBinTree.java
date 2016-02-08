package BinaryTree;

public class DefaultBinTree<T>
  implements BinTree<T>
{
  private BinTreeNode<T> root;
  
  public DefaultBinTree()
  {
    this.root = null;
  }
  
  public BinTreeNode<T> getRoot()
  {
    return this.root;
  }
  
  public void setRoot(BinTreeNode<T> root)
  {
    this.root = root;
  }
  
  public boolean empty()
  {
    return this.root == null;
  }
  
  public LinkedList<T> inorderTraversal()
  {
    LinkedList<T> traversal = new LinkedList<T>();
    inorderTraversal(this.root, traversal);
    return traversal;
  }
  
  private void inorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
  {
    if (node == null) {
      return;
    }
    if (node.isLeaf())
    {
      traversal.insertLast(node.getData());
    }
    else
    {
      inorderTraversal(node.getLeftChild(), traversal);
      traversal.insertLast(node.getData());
      inorderTraversal(node.getRightChild(), traversal);
    }
  }
  
  public LinkedList<T> preorderTraversal()
  {
    LinkedList<T> traversal = new LinkedList<T>();
    preorderTraversal(this.root, traversal);
    return traversal;
  }
  
  private void preorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
  {
    if (node == null) {
      return;
    }
    if (node.isLeaf())
    {
      traversal.insertLast(node.getData());
    }
    else
    {
      traversal.insertLast(node.getData());
      preorderTraversal(node.getLeftChild(), traversal);
      preorderTraversal(node.getRightChild(), traversal);
    }
  }
  
  public LinkedList<T> postorderTraversal()
  {
    LinkedList<T> traversal = new LinkedList<T>();
    postorderTraversal(this.root, traversal);
    return traversal;
  }
  
  private void postorderTraversal(BinTreeNode<T> node, LinkedList<T> traversal)
  {
    if (node == null) {
      return;
    }
    if (node.isLeaf())
    {
      traversal.insertLast(node.getData());
    }
    else
    {
      postorderTraversal(node.getLeftChild(), traversal);
      postorderTraversal(node.getRightChild(), traversal);
      traversal.insertLast(node.getData());
    }
  }
  
  public String inorderString()
  {
    return inorderTraversal().minimalString();
  }
  
  public String preorderString()
  {
    return preorderTraversal().minimalString();
  }
  
  public String postorderString()
  {
    return postorderTraversal().minimalString();
  }
}
