package concrete.vendors;

import concrete.Email;
import concrete.pools.GmailConnectionPool;
import abstracts.Vendor;

public class GmailVendor extends Vendor {

	@Override
	public void sendEmail(Email email) {
		try {
			GmailConnectionPool.getInstance().getConnection()
					.sendData(email.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void receiveEmail(Email email) {
		try {
			GmailConnectionPool.getInstance().getConnection()
					.receiveData(email.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
