package beans;

import obj.Item;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class beanPanier implements Serializable {

    HashMap<String, Item> map;
    
    public beanPanier() {
        this.map= new HashMap();
    }
    
    public void add( String ref) {
        if( this.map.containsKey(ref)) {
            Item i= this.map.get(ref);
//            i.setQty( i.getQty()+1);
            i.changeQty( +1);
        } else {
            Item i = new Item(ref, 1);
            this.map.put(ref, i);
        }
    }
    public void dec( String ref) {
       if( this.map.containsKey( ref)) {
           Item i = this.map.get(ref);
           i.changeQty( -1);
           if (i.getQty() < 1) {
               del(ref);
           }
       } 
    }
    public void del( String ref) {
        this.map.remove(ref);
    }
    public float getTotalHT() {
        return -1;
    } 
    public void clear() {
        this.map.clear();
    }
    public int size() {
        return this.map.size();
    }
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    public Collection<Item> list() {
        return this.map.values();
    }
    
}
