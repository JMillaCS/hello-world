class BST<Key extends Comparable<? super Key>, E> implements IDictionary<Key, E> {
    private BSTNode<Key,E> root;
    private int nodecount;
    
    BST() { 
        root = null; 
        nodecount = 0; 
    }
    
    public void clear () { 
        root = null; nodecount = 0; 
    }
    
    public void insert(Key k, E e) {
        root = inserthelp(root, k, e); 
        nodecount++;
    }
    
    public E remove(Key k) {
        E temp = findhelp(root, k);
        if (temp != null) {
            root = removehelp(root, k);
            nodecount--;
        }
        return temp;
    }
    
    public E removeAny() {
        if (root == null) return null; 
        E temp = root.element();
        root = removehelp(root, root.key()); 
        nodecount--; 
        return temp;
    }
    
    public E find(Key k) { 
        return findhelp(root, k); 
    }
    
    public int size() { 
        return nodecount; 
    }
    
    public void print(){
        System.out.print("[ ");
        print(this.root);
        System.out.println("]");
    }
        
    private void print(BSTNode tree) {
        if ( tree == null )
        {
            return;
        }
        print( tree.left() );
        System.out.println();
        System.out.println(tree.element());
        System.out.print(" ");
        print( tree.right() );
    }
    
    public void printhelp(BSTNode<Key, E> rt){
        if (rt == null) return;
        printhelp(rt.left());
        System.out.println(rt.key() + ":" + rt.element());
        printhelp(rt.right());
    }
    
    private BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) {
        if (rt == null){
            return new BSTNode<Key,E>(k, e); 
        }
        else if (rt.key().compareTo(k) > 0){ 
          rt.setLeft(inserthelp(rt.left(), k, e));
        }
        else{ 
          rt.setRight(inserthelp(rt.right(), k, e)); 
        }   
        return rt;
    }
    
    private BSTNode<Key,E> getmin(BSTNode<Key,E> rt) { 
        if (rt.left() == null) return rt;
        return getmin(rt.left());
    }
   
    private E findhelp(BSTNode<Key,E> rt, Key k) { 
        if (rt == null) return null; 
        if (rt.key().compareTo(k) > 0)
        return findhelp(rt.left(), k);
        else if (rt.key().compareTo(k) == 0) return rt.element(); 
        else return findhelp(rt.right(), k);
    }
    
    private BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) { 
        if (rt.left() == null) return rt.right(); 
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }
    
    private BSTNode<Key,E> removehelp(BSTNode<Key,E> rt,Key k) { 
        if (rt == null){
            return null;
        }
        else if (rt.key().compareTo(k) > 0){ 
            rt.setLeft(removehelp(rt.left(), k)); 
        }
        else if (rt.key().compareTo(k) < 0){
        rt.setRight(removehelp(rt.right(), k)); 
        }
        else { // Found given node
            if (rt.left() == null){
                return rt.right();
            }
        else { // The chilren of the node
         if(rt.right() == null){
          BSTNode<Key,E> temp = getmin(rt.left()); 
          rt.setElement(temp.element()); 
          rt.setKey(temp.key()); 
          rt.setRight(deletemin(rt.left()));
         }
         else{
          BSTNode<Key,E> temp = getmin(rt.right()); 
          rt.setElement(temp.element()); 
          rt.setKey(temp.key()); 
          rt.setRight(deletemin(rt.right())); 
             
          }
        }
    }
    return rt;
   }
}
