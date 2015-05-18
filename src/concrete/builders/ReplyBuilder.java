package concrete.builders;

import concrete.Email;
import abstracts.EmailBuilder;

public class ReplyBuilder extends EmailBuilder {

	public ReplyBuilder(Email email) {
		this.vendor(email.getVendor());
		this.from(email.getTo());
		this.to(email.getFrom());
		this.subject("Re: " + this.subject);
	}
	
}
