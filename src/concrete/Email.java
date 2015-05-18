package concrete;

public class Email {

	private VendorType vendor;

	private String from;

	private String to;

	private String[] cc;

	private String subject;

	private String content;

	private String[] attachments;

	public VendorType getVendor() {
		return vendor;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String[] getCc() {
		return cc;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String[] getAttachments() {
		return attachments;
	}

	public Email(VendorType vendor, String from, String to, String[] cc,
			String subject, String content, String[] attachments) {
		this.attachments = attachments;
		this.cc = cc;
		this.content = content;
		this.from = from;
		this.subject = subject;
		this.to = to;
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return String
				.format("Email [From: %s, To: %s, CC: %s, Subject: %s, Content: %s, Attachments: %s]",
						this.from,
						this.to,
						this.cc == null ? "no cc" : String.join("; ", this.cc),
						this.subject,
						this.content,
						this.attachments == null ? "no attachments" : String
								.join("; ", this.attachments));
	}

	public void send() {
		VendorFactory.getVendor(this.vendor).sendEmail(this);
	}

}
