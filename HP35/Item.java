package HP35;

public class Item {
    private ItemType type;
    private int value = 0;

    // Constructor
    public Item(ItemType type, int value){
        this.type = type;
        this.value = value;
    }
    public Item(ItemType type){

        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public int getValue(){
        return value;
    }
}
