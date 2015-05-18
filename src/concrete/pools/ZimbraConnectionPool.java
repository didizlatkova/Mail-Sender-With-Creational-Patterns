package concrete.pools;

import java.util.ArrayList;
import java.util.List;

import concrete.connections.ZimbraConnection;
import abstracts.VendorConnection;
import abstracts.VendorConnectionPool;

public class ZimbraConnectionPool extends VendorConnectionPool {

	private static ZimbraConnectionPool instance;
	
	protected static List<VendorConnection> available = new ArrayList<VendorConnection>();
	protected static List<VendorConnection> inUse = new ArrayList<VendorConnection>();
	
	public ZimbraConnectionPool() {
		super(available, inUse);
	}

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
		available.add(new ZimbraConnection(inUse.size() + 1));		
	}
}
