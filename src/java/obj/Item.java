package obj;

import java.io.Serializable;

public class Item implements Serializable {

    private String ref;
    private int qty;

    public Item(String ref, int qty) {
        this.ref = ref;
        this.qty = qty;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public void changeQty( int qty) {
        this.qty+= qty;
    }
}
