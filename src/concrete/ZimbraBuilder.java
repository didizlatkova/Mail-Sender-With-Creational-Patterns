package concrete;

import abstracts.EmailBuilder;

public class ZimbraBuilder extends EmailBuilder {

	public ZimbraBuilder() {
		this.vendor(VendorType.Zimbra);
	}
	
}
