package fr.uge.sw.marketplace;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import fr.uge.service_web.ifshare.shared.*;

public class MarketPlace {
	private final HashMap<Integer, IOffer> mapOffers = new HashMap<>();
	private Ecorpsharedinterface ecInterface;
	
	public MarketPlace() throws MalformedURLException, RemoteException, NotBoundException {
		this.ecInterface = (Ecorpsharedinterface) Naming.lookup("rmi://localhost:1201/EcorpSharedService");	
	}
	
	public void updateMarket() throws MalformedURLException, RemoteException, NotBoundException {
		Set<? extends IOffer> set = ecInterface.getOffers();
		 
		mapOffers.clear();
		set.forEach((offer) -> {
			 try {
				mapOffers.put(offer.getId(), offer);
			} catch (RemoteException e) {
				System.err.println("import offer failed. In updatemarket");
			}
		 });
	}
	
	public IOffer getOffer(int idOffer) {
		return mapOffers.get(idOffer);	
	}
	

	public Ecorpsharedinterface getEcInterface() {
		return ecInterface;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n---------------\n", "\n---------------\n", "\n---------------\n");
		
		mapOffers.forEach((k, v) -> {
			
			try {
				StringJoiner sj2 = new StringJoiner("\n");
				sj2.add("Id : " + k.toString());
				sj2.add("Name : " + v.getProduct().getName());
				sj2.add("Description : " + v.getProduct().getDescription());
				sj2.add("Price : " + Float.toString(v.getPrice()));
				sj2.add("Stock : " + Integer.toString(v.getStock()));
				sj2.add("State : " + v.getProductState().toString());
				sj2.add("Seller : " + v.getSeller().getFirstName() + " " + v.getSeller().getLastName());
				sj.add(sj2.toString());
				
			} catch (RemoteException e) {
				System.err.println("import offer failed. In marketplace.toString");
			}			
		});
					
		return sj.toString();
	}
	
	
}

/*
	
	public void fillOffersList(Set<IOffer> offers) {
		for (IOffer offer : offers) {
			int id = offer.hashCode();
			
			while (mapOffers.containsKey(id)) {
				id++;
			}
			
			mapOffers.put(id, offer);
			
		}
	}
	
	public IOffer getOfferById(int id) {
		return mapOffers.get(id);
	}
 */