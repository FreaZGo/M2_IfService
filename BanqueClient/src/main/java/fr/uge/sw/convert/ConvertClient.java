package fr.uge.sw.convert;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

public class ConvertClient {
	public static double convert (double montant) throws RemoteException, ServiceException {
		CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap(); 
		
		return montant * (double) currencySystem.rate("", "EUR", "JPY", false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
	
	public static double convertFromTo (double montant, String from, String to) throws RemoteException, ServiceException {
		CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap(); 
		
		return montant * (double) currencySystem.rate("", from, to, false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
	}
	
	public static void main(String[] args) throws RemoteException, ServiceException {
		
		System.out.println(convert(100));
	}
}
