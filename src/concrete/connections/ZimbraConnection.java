package concrete.connections;

import concrete.pools.ZimbraConnectionPool;
import abstracts.VendorConnection;

public class ZimbraConnection extends VendorConnection {

	public ZimbraConnection(int connectionId) {
		super(connectionId);
	}
	
	@Override
	public void sendData(String data){
		System.out.println("Sending the data on Zimbra connection.");		
		super.sendData(data);
		ZimbraConnectionPool.getInstance().releaseConnection(this);
	}
	
	public void receiveData(String data){
		System.out.println("Receiving the data on Zimbra connection.");		
		super.receiveData(data);
		ZimbraConnectionPool.getInstance().releaseConnection(this);
	}

}
