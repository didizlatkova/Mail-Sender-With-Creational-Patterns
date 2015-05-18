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
	
	public void sendData(String data){
		System.out.printf("Sending the data on connection %d. \n", this.connectionId);
		System.out.println("The data is: " + data);
	}
	
}
