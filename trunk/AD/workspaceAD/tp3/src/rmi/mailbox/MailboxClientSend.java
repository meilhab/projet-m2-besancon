package rmi.mailbox;

import java.rmi.Naming;

public class MailboxClientSend {

	public static void main(String args[]) {
		try {
			Mailbox client = (Mailbox) Naming.lookup(MailboxServer.NAME);
			String message = "Yo !";
			client.send(message);
		} catch(Exception e) {
			System.out.println("An exception has occurred!");
			e.printStackTrace();
		}
	}
}

