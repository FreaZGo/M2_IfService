package fr.uge.sw.user;

import java.rmi.RemoteException;
import java.util.HashMap;

import fr.uge.service_web.ifshare.shared.*;


public class User {
	private String iduser;

	private String firstName;
	private String lastName;
	private String address;
	private String email;
	
	private final Cart cart = new Cart();
	
	public User(String iduser, String firstName, String lastName, String address, String email) {
		this.iduser = iduser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public void putToCartOffer(IOffer offer, int qty) throws RemoteException {
		if (qty > offer.getStock()) {
			System.out.println("You cannot put qty > offer.stock");
			return;
		}
		cart.putToCartOffer(offer, qty);
	}
	
	public void removeOffer(IOffer offer, int qty) throws RemoteException {
		cart.removeOffer(offer, 0);
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void clearCart() {
		cart.clearCart();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toStringCart() {
		return cart.toString();
	}

	public void sendCommand(Ecorpsharedinterface ecInteface) {
		HashMap<IOffer, Integer> cartContent = cart.getCartContent();
		
		cartContent.forEach((offer, qty) -> {
			try {
				ecInteface.addpurshase(iduser, offer.getId(), qty);
			} catch (RemoteException e) {
				System.err.println("import offer failed. In user.sendCommand");
			}
		});
	}

	@Override
	public String toString() {
		return "FirstName = " + firstName + ", lastName = " + lastName + ", address = " + address + ", email = " + email;
	}
	
	public String getIduser() {
		return iduser;
	}
	
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	
}
