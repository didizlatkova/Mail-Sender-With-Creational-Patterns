package concrete.builders;

import concrete.VendorType;
import abstracts.EmailBuilder;

public class GmailBuilder extends EmailBuilder {

	public GmailBuilder() {
		this.vendor(VendorType.Gmail);
	}
	
}
