package Onlinehandel.entities;

import Onlinehandel.provided.Costumer;

public class RegionalOrder extends Order{
    private boolean express; //Flag value for express option. Defaults to false (no express).

    public RegionalOrder(long id, Costumer c, Iterable<Item> items) {
        super(id, c, items);
    }
    public RegionalOrder(long id, Costumer c, Iterable<Item> items, boolean express){
        super(id, c, items);
        this.express = express;

    }

    @Override
    public int getTotal() {
        return getTotal() + getTotal() / 100 * 20;
    }
}
