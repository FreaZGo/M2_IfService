package fr.uge.service_web.ifshare.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Ecorpsharedinterface extends Remote{
	
	public void addpurshase(String iduser,int idoffre,int qt) throws RemoteException;
	public List<IPurchase> getpurshasebyuser(String iduser) throws RemoteException;
	
	public IUser connect(String email, String passwd) throws RemoteException;
	public void addPasswd(String iduser,String passwd) throws RemoteException;
	public String getid() throws RemoteException;
	
	Set<? extends IProduct> getProducts() throws RemoteException;

    Set<? extends IOffer> getOffers() throws RemoteException;

    IUser addUser(String id, String firstName, String lastName, String address, String mail) throws RemoteException;
    public IOffer getofferbyid(int id) throws RemoteException;
}
