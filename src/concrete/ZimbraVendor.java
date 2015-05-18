package concrete;

import abstracts.Vendor;

public class ZimbraVendor extends Vendor {

	@Override
	public void sendEmail(Email email) {
		try {
			ZimbraConnectionPool.getInstance().getConnection()
					.sendData(email.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
