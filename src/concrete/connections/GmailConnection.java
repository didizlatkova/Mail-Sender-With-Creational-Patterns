package concrete.connections;

import abstracts.VendorConnection;
import concrete.pools.GmailConnectionPool;

public class GmailConnection extends VendorConnection {

	public GmailConnection(int connectionId) {
		super(connectionId);
	}
	
	@Override
	public void sendData(String data){
		System.out.println("Sending the data on Gmail connection.");		
		super.sendData(data);
		GmailConnectionPool.getInstance().releaseConnection(this);
	}
	
	@Override
	public void receiveData(String data){
		System.out.println("Receiving the data on Gmail connection.");		
		super.receiveData(data);
		GmailConnectionPool.getInstance().releaseConnection(this);
	}
}
