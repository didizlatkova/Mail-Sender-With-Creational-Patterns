package concrete;

import abstracts.EmailBuilder;

public class GmailBuilder extends EmailBuilder {

	public GmailBuilder() {
		this.vendor(VendorType.Gmail);
	}
	
}
