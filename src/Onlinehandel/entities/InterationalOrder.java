package Onlinehandel.entities;

import Onlinehandel.provided.Costumer;

public class InterationalOrder extends Order{
    private float custom; //The custom factor. Defaults to 1.


    public InterationalOrder(long id, Costumer c, Iterable<Item> items) {
        super(id, c, items);
    }
    public InterationalOrder(long id, Costumer c, Iterable<Item> items, float custom){
        super(id, c, items);
        if(custom == 0){
            this.custom = 1;
        }else{
            this.custom = custom;
        }

    }

    @Override
    public int getTotal() {
        return getTotal() * (int) custom;
    }
}
