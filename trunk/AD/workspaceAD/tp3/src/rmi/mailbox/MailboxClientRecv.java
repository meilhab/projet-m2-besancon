package rmi.mailbox;

import java.rmi.Naming;


public class MailboxClientRecv {

	public static void main(String[] args) {
		try {
			Mailbox client = (Mailbox) Naming.lookup(MailboxServer.NAME);
			String message = client.getMessage();
			System.out.println("Message récupéré : " + message);
		} catch(Exception e) {
			System.out.println("An exception has occurred!");
			e.printStackTrace();
		}
	}

}
