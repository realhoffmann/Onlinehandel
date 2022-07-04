package Onlinehandel.entities;

public class Item {
    private String description; //The common description of the single items in this shipping item
    private int amount; //The number of single items in this shipping item. Defaults to 1.
    private int value; //The value of a single item in this shipping item in EUR cents.

    public Item(String description, int amount, int value){
        this.description = description;
        if(amount <= 0){
            throw new IllegalArgumentException();
        }else{
            this.amount = amount;
        }
        if(value <= 0){
            throw new IllegalArgumentException();
        }else{
            this.value = value;
        }
    }
    public int totalValue(){
        return value * amount;
    }
    @Override
    public String toString() {
        return "Item{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
