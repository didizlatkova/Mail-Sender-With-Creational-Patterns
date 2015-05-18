package abstracts;

import concrete.Email;

public abstract class Vendor {
		
	public abstract void sendEmail(Email email);
	
	public abstract void receiveEmail(Email email);

}
