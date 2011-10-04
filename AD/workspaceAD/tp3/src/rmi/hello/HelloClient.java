package rmi.hello;

import java.rmi.Naming;

public class HelloClient {

	public static void main(String args[]) {
		try {
			Hello client = (Hello) Naming.lookup(HelloServer.NAME);
			String message = client.sayHello();
			System.out.println("Message: " + message);
		} catch(Exception e) {
			System.out.println("An exception has occurred!");
			e.printStackTrace();
		}
	}
}
