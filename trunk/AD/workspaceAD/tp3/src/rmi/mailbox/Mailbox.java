package rmi.mailbox;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mailbox extends Remote {

	void send(String message) throws RemoteException;
	String getMessage() throws RemoteException;
	
}

