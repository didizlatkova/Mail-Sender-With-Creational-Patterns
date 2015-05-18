package concrete;

import abstracts.Vendor;

public class GmailVendor extends Vendor {

	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending mail from Gmail");		
		System.out.println(email.toString());	
	}

}
