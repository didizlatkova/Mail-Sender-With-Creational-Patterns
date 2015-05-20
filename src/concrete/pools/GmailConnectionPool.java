package concrete.pools;

import java.util.ArrayList;
import java.util.List;

import abstracts.VendorConnection;
import abstracts.VendorConnectionPool;
import concrete.VendorType;
import concrete.connections.GmailConnection;

public class GmailConnectionPool extends VendorConnectionPool {	

	private static GmailConnectionPool instance;
	
	protected static VendorType connectionType = VendorType.Gmail;
	
	protected static List<VendorConnection> available = new ArrayList<VendorConnection>();
	protected static List<VendorConnection> inUse = new ArrayList<VendorConnection>();
	
	public GmailConnectionPool() {
		super(available, inUse, connectionType);
	}

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