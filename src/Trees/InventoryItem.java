package Trees;

public class InventoryItem implements Comparable<InventoryItem> {
    public int itemNumber;
    public String type;
    public float price;

    public InventoryItem(int n, String t, float p){
        this.itemNumber = n;
        this.type = t;
        this.price = p;
    }

    @Override
    public String toString() {
        return "Inventory item: "+itemNumber +"\n is: "+type+"\nPrice: "+price+"\n\n";
    }

    @Override
    public int compareTo(InventoryItem o) {
        if(this.itemNumber == ( o).itemNumber) {
            return 0;
        }
        if(this.itemNumber < ( o).itemNumber) {
            return -1;
        }
        if(this.itemNumber > ( o).itemNumber) {
            return 1;
        }
        return 0;
    }
}
