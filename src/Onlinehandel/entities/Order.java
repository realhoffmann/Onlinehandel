package Onlinehandel.entities;

import java.util.HashSet;
import java.util.Set;

import Onlinehandel.provided.*;


public abstract class Order implements Comparable<Order> {

	private long id; //Unique id of this order.
	private DateTime collected; //The date and time when this order is collected from the sender. A null value means this delivery has not been collected yet.
	private DateTime delivered; //The date and time when this order is delivered to the recipient. A null value means this delivery has not been delivered yet.
	private java.util.Set<Item> goods = new HashSet<>(); //The set of items this order contains.
	private Costumer costumer; //The costumer having placed this order.

	public Order(long id, Costumer c, Iterable<Item> items){
		if(id == 0){
			throw new IllegalArgumentException();
		}else{
			this.id = id;
		}
		if(costumer == null){
			throw new IllegalArgumentException();
		}else{
			this.costumer = c;
		}

		if(goods.size() == 0){
			throw new IllegalArgumentException();
		}else{
			for(Item i : items)
			goods.add(i);
		}

	}
	public Order(Order orig){
		this.id = orig.id;
		this.goods = orig.goods;
		this.costumer = new Costumer(orig.costumer);
		this.collected = new DateTime(orig.collected);
		this.delivered = new DateTime(orig.delivered);
	}
	public abstract int getTotal();

	public boolean isCollected(){
		if(collected == null){
			return false;
		}else{
			return true;
		}
	}
	public boolean isDelivered(){
		if(delivered == null){
			return false;
		}else{
			return true;
		}
	}

	public final boolean addItems(Item item){
		if(!isCollected() && !isDelivered()){
			goods.add(item);
			return true;
		}else{
			return false;
		}
	}
	public final boolean addItems(Iterable<Item> items){
		if(!isCollected() && !isDelivered()){
			for(Item i : items){
				if(!goods.contains(i)){
					goods.add(i);
					return true;
				}
			}
		}
		return false;
	}
	public java.util.Set<Item> getItems(){
		return new HashSet<>(goods);
	}
	public final boolean collect(DateTime toc){
		if(!isCollected()){
			collected = new DateTime(toc);
			return true;
		}else{
			return false;
		}
	}
	public final boolean deliver(DateTime tod){
		if(isCollected()== true && !isDelivered()){
			delivered = new DateTime(tod);
			return true;
		}else {
			return false;
		}
	}
	private final String ensureNonNullNonEmpty(String str){
		if(str.isEmpty() || str == null){
			throw new IllegalArgumentException();
		}
		return str;
	}

	public int compareTo(Order arg0){
		return Long.compare(id, arg0.id);
	}
	public Costumer getCostumer(){
		return new Costumer(costumer);
	}


	@Override
	public String toString() {
		return String.format("%d " + "[%scollected, %sdelivered] (EUR %.2f)\n" + "%s", //
				id, isCollected() ? "" : "not ", isDelivered() ? "" : "not ", getTotal() / 100.,
				goods == null ? "no stock" : goods);
	}

}
