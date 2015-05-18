package test;

import concrete.Email;

public class EmailRunnable implements Runnable {

	private Email email;
	
	public EmailRunnable(Email email){
		this.email = email;
	}
	
	@Override
	public void run() {
		this.email.send();
	}

}
