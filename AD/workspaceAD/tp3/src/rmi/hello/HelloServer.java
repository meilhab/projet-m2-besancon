package rmi.hello;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer implements Hello {

	private static final long serialVersionUID = -7154892220277645811L;

	public String sayHello() throws RemoteException {
		return "Hello from " + Thread.currentThread().getName();
	}

	public static final String NAME = "Hello";
	
	public static void main(String args[]) {
		try {
			HelloServer server = new HelloServer();
			Remote stub = UnicastRemoteObject.exportObject(server, 0);
			Naming.rebind(NAME, stub);
			System.out.println("Server ready!");
		} catch (Exception e) {
			System.out.println("An exception has occurred!");
			e.printStackTrace();
		}		
	}
}
