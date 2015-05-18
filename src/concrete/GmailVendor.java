package concrete;

import abstracts.Vendor;

public class GmailVendor extends Vendor {

	@Override
	public void sendEmail() {
		System.out.println("Sending mail from Gmail");		
	}

}
