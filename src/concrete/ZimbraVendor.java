package concrete;

import abstracts.Vendor;

public class ZimbraVendor extends Vendor {

	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending mail from Zimbra");
		System.out.println(email.toString());	
	}

}
