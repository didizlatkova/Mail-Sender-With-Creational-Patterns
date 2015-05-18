package concrete;

import concrete.vendors.GmailVendor;
import concrete.vendors.ZimbraVendor;
import abstracts.Vendor;

public class VendorFactory {

	private static Vendor zimbraVendor = new ZimbraVendor();

	private static Vendor gmailVendor = new GmailVendor();

	public static Vendor getVendor(VendorType type) {
		if (type == VendorType.Zimbra) {
			return VendorFactory.zimbraVendor;
		}
		if (type == VendorType.Gmail) {
			return VendorFactory.gmailVendor;
		} else {
			return null;
		}
	}
}
