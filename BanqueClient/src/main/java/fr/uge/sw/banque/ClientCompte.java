package fr.uge.sw.banque;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ClientCompte {
	public static void main(String[] args) throws ServiceException, RemoteException {
        Compte service = new CompteServiceLocator().getCompte();
        ((CompteSoapBindingStub) service).setMaintainSession(true);
        service.depotDe(500);
        service.retraitDe(200);
        System.out.println(service.valeurDuSolde());
        
    }

}
