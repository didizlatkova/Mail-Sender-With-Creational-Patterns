package abstracts;

import concrete.Email;
import concrete.VendorType;

public abstract class EmailBuilder {

	protected VendorType vendor;

	protected String from;

	protected String to;

	protected String[] cc;

	protected String subject;

	protected String content;

	protected String[] attachments;

	public EmailBuilder vendor(VendorType vendor){
		this.vendor = vendor;
		return this;
	}
	
	public EmailBuilder from(String from){
		this.from = from;
		return this;
	}
	
	public EmailBuilder to(String to){
		this.to = to;
		return this;
	}
	
	public EmailBuilder cc(String[] cc){
		this.cc = cc;
		return this;
	}
	
	public EmailBuilder subject(String subject){
		this.subject = subject;
		return this;
	}
	
	public EmailBuilder content(String content){
		this.content = content;
		return this;
	}
	
	public EmailBuilder attachments(String[] attachments){
		this.attachments = attachments;
		return this;
	}
	
	public Email build(){
		return new Email(vendor, from, to, cc, subject, content, attachments);
	}
	
}
