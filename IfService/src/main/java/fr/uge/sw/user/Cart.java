package fr.uge.sw.user;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringJoiner;

import fr.uge.service_web.ifshare.shared.IOffer;


public class Cart {
	private HashMap<IOffer, Integer> mapOffers = new HashMap<>();
	private float totalPrice = 0f;

	public void putToCartOffer(IOffer offer, int qty) throws RemoteException {
		Objects.requireNonNull(offer);
		
		if (mapOffers.containsKey(offer)) {
			mapOffers.put(offer, mapOffers.get(offer) + qty);
		} else {
			mapOffers.put(offer, qty);			
		}
		
		totalPrice = totalPrice + (offer.getPrice() * qty);
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n---------------\n", "","");
		
		mapOffers.forEach((k, v) -> {
			
			try {
				StringJoiner sj2 = new StringJoiner("\n");
				sj2.add("Id : " + k.getId());
				sj2.add("Name : " + k.getProduct().getName());
				sj2.add("Description : " + k.getProduct().getDescription());
				sj2.add("Price : " + Float.toString(k.getPrice()));
				sj2.add("Stock : " + Integer.toString(k.getStock()));
				sj2.add("State : " + k.getProductState().toString());
				sj2.add("Seller : " + k.getSeller().getFirstName() + " " + k.getSeller().getLastName());
				sj2.add("Qty : " + Integer.toString(v));
				sj.add(sj2.toString());
				
			} catch (RemoteException e) {
				System.err.println("import offer failed. In cart.toString");
			}			
		});
					
		return "My cart : \n" + sj.toString();
		
	}

	public void clearCart() {
		mapOffers.clear();
	}

	public float getTotalPrice() {
		return totalPrice;
	}
	
	public HashMap<IOffer, Integer> getCartContent() {
		return mapOffers;
	}

	public boolean removeOffer(IOffer offer, int qty) throws RemoteException {
		Objects.requireNonNull(offer);
		
		if (!mapOffers.containsKey(offer)) {
			return false;
		}
		
		if (mapOffers.get(offer) < qty) {
			return false;
		}
		
		mapOffers.put(offer, mapOffers.get(offer) - qty);
		totalPrice = totalPrice - (offer.getPrice() * qty);
		
		return true;
	}
}
