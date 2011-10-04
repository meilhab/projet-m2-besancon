package rmi.mailbox;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;


public class MailboxServer implements Mailbox {
	private String message = "";
	private static Semaphore empty;
	private static Semaphore full;

	public String getMessage() throws RemoteException {
		try {
			empty.acquire(1);
			String tmp = message;
			full.release(1);
			return message;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void send(String message) throws RemoteException {
		try {
			full.acquire(5);
			this.message = message;
			empty.release(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final String NAME = "Mailbox";

	public static void main(String args[]) {
		try {
			empty = new Semaphore(0);
			full = new Semaphore(5);
			MailboxServer server = new MailboxServer();
			Remote stub = UnicastRemoteObject.exportObject(server, 0);
			Naming.rebind(NAME, stub);
			System.out.println("Server ready!");
		} catch (Exception e) {
			System.out.println("An exception has occurred!");
			e.printStackTrace();
		}
	}

}

