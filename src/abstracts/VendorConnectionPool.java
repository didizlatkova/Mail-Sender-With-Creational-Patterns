package abstracts;

import java.util.List;

public abstract class VendorConnectionPool {

	protected static final int MIN_CONNECTION_COUNT = 5;

	protected static final int MAX_CONNECTION_COUNT = 10;

	final List<VendorConnection> available;
	final List<VendorConnection> inUse;

	public VendorConnectionPool(List<VendorConnection> available,
			List<VendorConnection> inUse) {
		this.available = available;
		this.inUse = inUse;
	}

	public VendorConnection getConnection() throws Exception {
		synchronized (available) {
			if (available.size() == 0) {
				if (inUse.size() < MAX_CONNECTION_COUNT) {
					this.addConnectionToPool();
					System.out.println("Debug: Added new connection to "
							+ this.getClass().getSimpleName());
				} else {
					System.out.println("Debug: Maximum connections reached in "
							+ this.getClass().getSimpleName());
				}

			}

			if (available.size() != 0) {
				VendorConnection connection = available.get(0);
				inUse.add(connection);
				available.remove(0);

				System.out.println("Debug: Connections left in "
						+ this.getClass().getSimpleName() + ": "
						+ available.size());
				return connection;
			} else {
				throw new Exception("No connections available in "
						+ this.getClass().getSimpleName());
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
							+ this.getClass().getSimpleName() + ": "
							+ available.size());
		}
	}

	private void reset(VendorConnection connection) {
		connection = null;
	}

	protected abstract void addConnectionToPool();

}
