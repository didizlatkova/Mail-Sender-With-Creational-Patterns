package concrete.pools;

import abstracts.VendorConnectionPool;
import concrete.connections.GmailConnection;

public class GmailConnectionPool extends VendorConnectionPool {

	private static GmailConnectionPool instance;

	public static synchronized GmailConnectionPool getInstance() {

		if (instance == null) {
			instance = new GmailConnectionPool();

			for (int i = 1; i <= VendorConnectionPool.MIN_CONNECTION_COUNT; i++) {
				available.add(new GmailConnection(i));
			}
		}

		return instance;
	}

	@Override
	protected void addConnectionToPool() {
		available.add(new GmailConnection(inUse.size() + 1));		
	}
}