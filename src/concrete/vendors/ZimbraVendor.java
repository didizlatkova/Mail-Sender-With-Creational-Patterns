package concrete.vendors;

import concrete.Email;
import concrete.pools.ZimbraConnectionPool;
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

	@Override
	public void receiveEmail(Email email) {
		try {
			ZimbraConnectionPool.getInstance().getConnection()
					.receiveData(email.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
