package fr.uge.sw;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.uge.sw.application.Application;

public class Main {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Application app = new Application();
		app.run();
	}
}
