package concrete;

import abstracts.Vendor;

public class ZimbraVendor extends Vendor {

	@Override
	public void sendEmail() {
		System.out.println("Sending mail from Zimbra");		
	}

}
