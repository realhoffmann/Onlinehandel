package Onlinehandel.util;

import Onlinehandel.entities.Order;
import Onlinehandel.provided.Matcher;

public class OnRouteMatcher implements Matcher<Order> {

    @Override
    public boolean matches(Order t) {
        if(t.isCollected() && !t.isDelivered()){
            return true;
        }else {
            return false;
        }
    }
}
