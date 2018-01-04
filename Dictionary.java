public class Dictionary<Key extends Comparable<Key>, E> implements IDictionary<Key, E>{
    private BST<Key, E> dict;
    
    public Dictionary(){
        dict = new BST<Key, E>();
    }
    
    public void clear(){
        dict.clear();
    }
    
    public void insert(Key k, E e){
        dict.insert(k, e);
    
    }
    
    public E remove(Key k){
        return dict.remove(k);
    
    }
    
    public E removeAny(){
       return dict.removeAny(); 
    }
    
    public E find(Key k) {
        return dict.find(k);
    }
    
    public int size(){
        return dict.size();
        
    }
    
    public void print(){
        dict.print();
    }
}