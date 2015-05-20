package abstracts;

import java.util.List;

import concrete.VendorType;

public abstract class VendorConnectionPool {

	protected static final int MIN_CONNECTION_COUNT = 5;

	protected static final int MAX_CONNECTION_COUNT = 10;

	final List<VendorConnection> available;
	final List<VendorConnection> inUse;
	final VendorType connectionType;

	public VendorConnectionPool(List<VendorConnection> available,
			List<VendorConnection> inUse, VendorType connectionType) {
		this.available = available;
		this.inUse = inUse;
		this.connectionType = connectionType;
	}

	public VendorConnection getConnection() throws Exception {
		synchronized (available) {
			if (available.size() == 0) {
				if (inUse.size() < MAX_CONNECTION_COUNT) {
					this.addConnectionToPool();
					System.out.println("Debug: Added new connection to "
							+ this.connectionType + " pool");
				} else {
					System.out.println("Debug: Maximum connections reached in "
							+ this.connectionType + " pool");
				}

			}

			if (available.size() != 0) {
				VendorConnection connection = available.get(0);
				inUse.add(connection);
				available.remove(0);

				System.out.println("Debug: Connections left in "
						+ this.connectionType + " pool" + ": "
						+ available.size());
				return connection;
			} else {
				throw new Exception("No connections available in "
						+ this.connectionType + " pool");
			}
		}
	}

	public void releaseConnection(VendorConnection connection) {
		reset(connection);

		synchronized (available) {
			available.add(connection);
			inUse.remove(connection);
			System.out
					.println("Debug: Connections Left in "
							+ this.connectionType + " pool" + ": "
							+ available.size());
		}
	}

	private void reset(VendorConnection connection) {
		connection = null;
	}

	protected abstract void addConnectionToPool();

}
