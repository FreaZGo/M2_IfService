package fr.uge.service_web.project.shared;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface EcorpInterface extends IfShareInterface{
	
	public void addoffer(String idpoduit,String iduser) throws RemoteException;
	public List<IOffer> getoffersbyuser(String iduser) throws RemoteException;
	public List<IOffer> getoffersbyproduct(String idproduct) throws RemoteException;
	
	public IUser connect(String email, String passwd) throws RemoteException;
	public void addPasswd(String iduser,String passwd) throws RemoteException;
	public String getid() throws RemoteException;
	
	public void addpushase(String iduser,String idoffre,int qt) throws RemoteException;
	public List<IPurchase> getpurshasebyuser(String iduser) throws RemoteException;
	
	public List<IPurchase> getpurshases() throws RemoteException;
	
}
