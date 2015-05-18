package concrete;

import abstracts.VendorConnectionPool;

public class ZimbraConnectionPool extends VendorConnectionPool {

	private static ZimbraConnectionPool instance;

	public static synchronized ZimbraConnectionPool getInstance() {

		if (instance == null) {
			instance = new ZimbraConnectionPool();

			for (int i = 1; i <= VendorConnectionPool.MIN_CONNECTION_COUNT; i++) {
				available.add(new ZimbraConnection(i));
			}
		}

		return instance;
	}

	@Override
	protected void addConnectionToPool() {
		available.add(new ZimbraConnection(inUse.size()));		
	}
}
