
public class FloorCutTree<E> extends AbstractBinaryTree<E> {

  //---------------- nested Node class ----------------


	public int max=0;
	public int top1=0;
	public int top2=0;
	public int max2=0;
  protected static class Node<E> implements Position<E> {
    private E element;          // an element stored at this node
    private Node<E> parent;     // a reference to the parent node (if any)
    private Node<E> left;       // a reference to the left child (if any)
    private Node<E> right;      // a reference to the right child (if any)
 

    public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
      element = e;
      parent = above;
      left = leftChild;
      right = rightChild;
    }


    public E getElement() { return element; }
    public Node<E> getParent() { return parent; }
    public Node<E> getLeft() { return left; }
    public Node<E> getRight() { return right; }

  
    public void setElement(E e) { element = e; }
    public void setParent(Node<E> parentNode) { parent = parentNode; }
    public void setLeft(Node<E> leftChild) { left = leftChild; }
    public void setRight(Node<E> rightChild) { right = rightChild; }
  } //----------- end of nested Node class -----------

  /** Factory function to create a new node storing element e. */
  protected Node<E> createNode(E e, Node<E> parent,
                                  Node<E> left, Node<E> right) {
    return new Node<E>(e, parent, left, right);
  }

  // LinkedBinaryTree instance variables
  /** The root of the binary tree */
  protected Node<E> root = null;     // root of the tree

  /** The number of nodes in the binary tree */
  private int size = 0;              // number of nodes in the tree

  // constructor
  /** Construts an empty binary tree. */
  public FloorCutTree() { }      // constructs an empty binary tree

  static int count = 0;


 

  

 
  protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not valid position type");
    Node<E> node = (Node<E>) p;       // safe cast
    if (node.getParent() == node)     // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  
  
  @Override
  public int size() {
    return size;
  }

  
  
  
  @Override
  public Position<E> root() {
    return root;
  }


  
  
  @Override
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getParent();
  }


  
  
  @Override
  public Position<E> left(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getLeft();
  }


  
  
  @Override
  public Position<E> right(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getRight();
  }


  
  
  public Position<E> addLeft(Position<E> p, E e)
                          throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getLeft() != null)
      throw new IllegalArgumentException("p already has a left child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setLeft(child);
    size++;
    return child;
  }

 
  
  
  public Position<E> addRight(Position<E> p, E e)
                          throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getRight() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setRight(child);
    size++;
    return child;
  }


  
  
  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E temp = node.getElement();
    node.setElement(e);
    return temp;
  }

  
  
  public void attach(Position<E> p, FloorCutTree<E> t1,
		  FloorCutTree<E> t2) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
    size += t1.size() + t2.size();
    if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
      t1.root.setParent(node);
      node.setLeft(t1.root);
      t1.root = null;
      t1.size = 0;
    }
    if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
      t2.root.setParent(node);
      node.setRight(t2.root);
      t2.root = null;
      t2.size = 0;
    }
  }


  
  
  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (numChildren(p) == 2)
      throw new IllegalArgumentException("p has two children");
    Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
    if (child != null)
      child.setParent(node.getParent());  // child's grandparent becomes its parent
    if (node == root)
      root = child;                       // child becomes root
    else {
      Node<E> parent = node.getParent();
      if (node == parent.getLeft())
        parent.setLeft(child);
      else
        parent.setRight(child);
    }
    size--;
    E temp = node.getElement();
    node.setElement(null);                // help garbage collection
    node.setLeft(null);
    node.setRight(null);
    node.setParent(node);                 // our convention for defunct node
    return temp;

  }
  
  
  
  
  public Position<E> search(String target)           
  {
	for (Position<E> po : this.preorder())
	{
		if (((Ýcerik) po.getElement()).getisim().equals(target)) return po;                  //Bulursa position bulamazsa  null donecek ( null karsilastirma icin)
	}

	return null;        
  }
  
  
  
  
  
  
  
  
  public Position<E> CreateRoot(String  v) throws IllegalStateException {
	    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
	    
	    Ýcerik c=new Ýcerik();
	    
	    c.setisim(v);
	    c.setheight(0);
	    c.setwidth(0);
	    
	    root = createNode((E) c, null, null, null);                   
	    size = 1;
	    return root;
	  }

  
 public  void cut_horizontal(String v, String lv, String rv) {
	 
	 
	 
	 
	 Position<E>  p =this.search(v);
	 
	 
	 if(p==null)
	      throw new IllegalArgumentException("nothing found");
	 
	 
	 Node<E> temp=validate(p);

	 
	 
	  if (numChildren(temp) >0)
	      throw new IllegalArgumentException("p has two children");


	  
	  ((Ýcerik) temp.getElement()).setwidth(0);
	  ((Ýcerik) temp.getElement()).setheight(0);
	  ((Ýcerik) temp.getElement()).setisim("-");

	
	  
	  
	  Ýcerik lvv=new Ýcerik();
	  
	  lvv.setheight(0);
	  lvv.setwidth(0);
	  lvv.setisim(lv);
	  
  Ýcerik rvv=new Ýcerik();
	  
  rvv.setheight(0);
  rvv.setwidth(0);
  rvv.setisim(rv);
	  
	 
	 Node<E>  newNodeL =createNode((E) lvv,temp,null,null);          // leftnode
	 
	 Node<E>  newNodeR =createNode((E) rvv,temp,null,null);         //rightnode
 
	 
	 
	 temp.setLeft(newNodeL);
	 
	 temp.setRight(newNodeR);
	 
	 
 }
  
  
public  void cut_vertical(String v, String lv, String rv) {
	 
	 
	 
	 Position<E>  p =this.search(v);
	 
	 if(p==null)
	      throw new IllegalArgumentException("nothing found");                  

	 
	 Node<E> temp=validate(p);

	 
	 
	  if (numChildren(temp) >0)
	      throw new IllegalArgumentException("p has two children");

	  
	  ((Ýcerik) temp.getElement()).setwidth(0);                     
	  ((Ýcerik) temp.getElement()).setheight(0);

	  ((Ýcerik) temp.getElement()).setisim("|");

	  
	  Ýcerik lvv=new Ýcerik();
	  
	  lvv.setheight(0);
	  lvv.setwidth(0);                              // atamalar
	  lvv.setisim(lv);
	  
	  Ýcerik rvv=new Ýcerik();
	  
	  rvv.setheight(0);             
	  rvv.setwidth(0);
	  rvv.setisim(rv);
	  
	  
	 
	 Node<E>  newNodeL =createNode((E) lvv,temp,null,null);            // leftnode
	 
	 Node<E>  newNodeR =createNode((E) rvv,temp,null,null);               //rightnode

	 
	 
	 
	 temp.setLeft(newNodeL);
	 
	 temp.setRight(newNodeR);
	 
	 
 }
  
		public void compact() {
	
	
				for (Position<E> po: this.inorder()) 
					{

		
			if(numChildren(po)==2  && ( ((Ýcerik) po.getElement())).getheight()==0  &&  ( ((Ýcerik) po.getElement())).getwidth()==0  ) {                                                            
				  
				 if( ((Ýcerik) po.getElement()).getisim().equals("-") )			{

					max=Math.max( ((Ýcerik) left(po).getElement()).getwidth(),  ((Ýcerik) right(po).getElement()).getwidth());                // max(w(w), w(z))
				
					 top2=((Ýcerik) left(po).getElement()).getheight()  + ((Ýcerik) right(po).getElement()).getheight();    //   h(w) + h(z)
						((Ýcerik) po.getElement()).setheight(top2);
						((Ýcerik) po.getElement()).setwidth(max);
				
				 }
					
					
					 if( ((Ýcerik) po.getElement()).getisim().equals("|") )	{
						
						
					top1=((Ýcerik) left(po).getElement()).getwidth()  + ((Ýcerik) right(po).getElement()).getwidth();   // w(w) + w(z)
					max2=Math.max( ((Ýcerik) left(po).getElement()).getheight(),  ((Ýcerik) right(po).getElement()).getheight());    //  max(h(w), h(z))
					
					((Ýcerik) po.getElement()).setheight(max2);
					((Ýcerik) po.getElement()).setwidth(top1);
					
					 }
					
				
				 }
				
					
		
		
		
	}
	}
	



  
  
  public void assign_height(String v, int height) {
	  
	  Position<E>  p =this.search(v);
		 
		 if(p==null)
		      throw new IllegalArgumentException("nothing found");
	  
	  
		 Node<E> temp=validate(p);
	  
		 
		 if (numChildren(temp) >0)
		      throw new IllegalArgumentException("p has two children");
		 
		 ((Ýcerik) temp.getElement()).setheight(height);                 //height guncelledik
		 
	    
  }
  

  
  
public void assign_width(String v, int width) {
	  
	
	
	
	  Position<E>  p =this.search(v);
		 
		 if(p==null)
		      throw new IllegalArgumentException("nothing found");
	  
		 Node<E> temp=validate(p);
	  
		 
		 if (numChildren(temp) >0)
		      throw new IllegalArgumentException("p has two children");
		 
		  
		 ((Ýcerik) temp.getElement()).setwidth(width);          //width guncelledik

	  
  }

public void display() {
	
	
	for (Position<E> po: this.inorder()) 
	{
		  for(int i=0;i<this.depth(po);i++)
			  System.out.print(".");
		
		System.out.println(((Ýcerik) po.getElement()).getisim()+"(:" +"," +((Ýcerik) po.getElement()).getwidth() +"," + ((Ýcerik) po.getElement()).getheight() +"))");
		
	}
	
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
} 

