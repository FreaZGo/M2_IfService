/**
 * Compte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.sw.banque;

public interface Compte extends java.rmi.Remote {
    public int valeurDuSolde() throws java.rmi.RemoteException;
    public void depotDe(int depot) throws java.rmi.RemoteException;
    public boolean retraitDe(int retrait) throws java.rmi.RemoteException;
}
