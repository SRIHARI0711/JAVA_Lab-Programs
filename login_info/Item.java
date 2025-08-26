package login_info;

public class Item {
    String name,id;
    int price;
    public Item(String id,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public String toString() {
        return "ItemID: " + id + "\nItemName: " + name + "\nItemPrice: " + price + "\n";
    }
    
}