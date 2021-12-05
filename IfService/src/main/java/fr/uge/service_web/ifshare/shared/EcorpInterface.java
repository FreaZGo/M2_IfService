package fr.uge.service_web.ifshare.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EcorpInterface extends Remote{
	
	IProduct addProduct(String productID, String productName, String description) throws RemoteException;

    Set<? extends IProduct> getProducts() throws RemoteException;

    Map<? extends IProduct, ? extends IOffer> getOffers() throws RemoteException;

    IUser addUser(String id, String firstName, String lastName, String address, String mail) throws RemoteException;

    IUser getUser(String id) throws RemoteException;

    Set<? extends IUser> getUsers() throws RemoteException;
	
	public void addoffer(String idpoduit,String iduser,ProductState state,int price,int stock) throws RemoteException;
	public List<IOffer> getoffersbyuser(String iduser) throws RemoteException;
	public List<IOffer> getoffersbyproduct(String idproduct) throws RemoteException;
	public IOffer getofferbyid(int id) throws RemoteException;
	
	public IUser connect(String email, String passwd) throws RemoteException;
	public void addPasswd(String iduser,String passwd) throws RemoteException;
	public String getid() throws RemoteException;
	
	public void addpurshase(String iduser,int idoffre,int qt) throws RemoteException;
	public List<IPurchase> getpurshasebyuser(String iduser) throws RemoteException;
	
}
