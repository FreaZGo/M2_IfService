package fr.uge.sw.application;

import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import fr.uge.service_web.project.shared.IOffer;
import fr.uge.service_web.project.shared.IPurchase;
import fr.uge.service_web.project.shared.IUser;
import fr.uge.sw.marketplace.MarketPlace;
import fr.uge.sw.user.User;

public class Application {
	private MarketPlace marketplace;
	private User user;

	private void init() throws MalformedURLException, RemoteException, NotBoundException {
		marketplace = new MarketPlace();
		marketplace.updateMarket();
	}

	public void run() throws MalformedURLException, RemoteException, NotBoundException {
		boolean onApp = true;

		init();


		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextLong() && onApp) {
				String line = sc.nextLine();

				String[] lineSplit = line.split(" ", 2);

				switch (lineSplit[0]) {
				case "/quit" :
					onApp = false;
					break;

				case "/marketDisplay":
					marketDisplay();
					break;

				case "/userDisplay":
					userDisplay();
					break;

				case "/addCart":
					addCart(lineSplit[1]);
					break;

				case "/connect":
					connect(lineSplit[1]);
					break;

				case "/addUser":
					addUser(lineSplit[1]);
					break;

				case "/priceDisplay":
					userDisplay();
					break;

				case "/purchase":
					purchase();
					break;
					
				case "/purchaseDisplay":
					purchaseDisplay();
					break;
					
				case "/myCartDisplay" :
					myCartDisplay();
					break;

				default:
					System.out.println("Unknow command");
					break;
				}

			}
			sc.close();
		}
	}

	private void myCartDisplay() {
		if (user == null) {
			System.out.println("User is not connecting");
			return;
		}
		System.out.println(user.toStringCart());
		
	}

	private void purchaseDisplay() throws RemoteException {
		if (user == null) {
			System.out.println("User is not connecting");
			return;
		}
		StringJoiner sj = new StringJoiner("\n---------------", "---------------\n", "---------------");
		
		List<IPurchase> purchaselist = marketplace.getEcInterface().getpurshasebyuser(user.getIduser());
		
		for (IPurchase p : purchaselist) {
			StringJoiner sj2 = new StringJoiner("\n");
			sj2.add("Name : " + p.getOffer().getProduct().getName());
			sj2.add("Description : " + p.getOffer().getProduct().getDescription());
			sj2.add("Price : " + Float.toString(p.getOffer().getPrice()));
			sj2.add("Qty : " + Integer.toString(p.getQuantity()));
			sj.add(sj2.toString());
		}
		
					
		System.out.println("My purchase : \n" + sj.toString());
		
	}

	private void purchase() {
		if (user == null) {
			System.out.println("User is not connecting");
			return;
		}
		user.sendCommand(marketplace.getEcInterface());

		// TODO Retrait de l'argent du compte en banque

	}

	private void addUser(String linesplit) throws RemoteException {
		String idUser = marketplace.getEcInterface().getid();
		String[] userLog = linesplit.split(" ");

		if (userLog.length != 5) {
			System.out.println("usage /addUser firstname lastname address mail passwd");
			return;
		}

		String firstname = userLog[0];
		String lastname = userLog[1];
		String address = userLog[2];
		String mail = userLog[3];
		String passwd = userLog[4];

		marketplace.getEcInterface().addUser(idUser, firstname, lastname, address, mail);
		marketplace.getEcInterface().addPasswd(idUser, passwd);

	}

	private void connect(String linesplit) throws RemoteException {
		String[] userLog = linesplit.split(" ");

		if (userLog.length != 2) {
			System.out.println("usage /connect mail passwd");
			return;
		}
		String mail = userLog[0];
		String passwd = userLog[1];

		IUser iuser = marketplace.getEcInterface().connect(mail, passwd);
		user = new User(iuser.getId(), iuser.getFirstName(), iuser.getLastName(), iuser.getAddress(), iuser.getMail());
	}

	private void addCart(String linesplit) throws RemoteException {
		if (user == null) {
			System.out.println("User is not connecting");
			return;
		}
		
		String[] productline = linesplit.split(" ");

		if (productline.length != 2) {
			System.out.println("usage /addCart idOffer qty");
		}
		
		IOffer offer = marketplace.getOffer(Integer.parseInt(productline[0]));
		int qty = Integer.parseInt(productline[1]);
		
		user.putToCartOffer(offer, qty);

	}

	private void userDisplay() {
		if (user == null) {
			System.out.println("User is not connecting");
			return;
		}
		System.out.println(user);

	}

	private void marketDisplay() {
		System.out.println(marketplace);
	}
}
