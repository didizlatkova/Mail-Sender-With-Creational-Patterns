package abstracts;

public abstract class VendorConnection {

	private int connectionId;

	public int getConnectionId() {
		return connectionId;
	}

	protected void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	
	public VendorConnection(int connectionId){
		this.setConnectionId(connectionId);
	}
	
}
