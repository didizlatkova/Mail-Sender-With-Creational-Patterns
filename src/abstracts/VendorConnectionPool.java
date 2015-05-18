package abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class VendorConnectionPool {

	protected static final int MIN_CONNECTION_COUNT = 5;

	protected static final int MAX_CONNECTION_COUNT = 10;

	protected static List<VendorConnection> available = new ArrayList<VendorConnection>();
	protected static List<VendorConnection> inUse = new ArrayList<VendorConnection>();

	public VendorConnection getConnection() throws Exception {
		synchronized (available) {
			if (available.size() == 0 && inUse.size() < MAX_CONNECTION_COUNT) {
				this.addConnectionToPool();
				System.out.println("Debug: Added new connection");
			}
			
			if (available.size() != 0) {
				VendorConnection connection = available.get(0);
				inUse.add(connection);
				available.remove(0);

				System.out.println("Debug: Connections left in the pool: "
						+ available.size());
				return connection;
			} else {
				throw new Exception("No connections are available");
			}
		}
	}

	public void releaseConnection(VendorConnection connection) {
		reset(connection);

		synchronized (available) {
			available.add(connection);
			inUse.remove(connection);
			System.out.println("Debug: Connections Left in the pool: "
					+ available.size());
		}
	}

	private void reset(VendorConnection connection) {
		connection = null;
	}

	protected abstract void addConnectionToPool();

}
