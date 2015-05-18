package test;

import java.util.ArrayList;
import java.util.List;

import concrete.Email;
import concrete.builders.*;

public class Demo {

	public static void main(String[] args) {
		Email email1 = new GmailBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("The design patterns course is great!")
				.attachments(new String[] { "smile", "wave" }).build();		
		Email email2 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 2")
				.attachments(new String[] { "smile", "wave" }).build();		
		Email email3 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 3")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email4 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 4")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email5 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 5")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email6 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 6")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email7 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 7")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email8 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 8")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email9 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 9")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email10 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 10")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email11 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 11")
				.attachments(new String[] { "smile", "wave" }).build();
		Email email12 = new ZimbraBuilder().from("didi.zlatkova")
				.to("mnknowledge").subject("important message")
				.content("Email 12")
				.attachments(new String[] { "smile", "wave" }).build();
		
		List<Email> emails = new ArrayList<Email>();
		emails.add(email1);
		emails.add(email2);
		emails.add(email3);
		emails.add(email4);
		emails.add(email5);
		emails.add(email6);
		emails.add(email7);
		emails.add(email8);
		emails.add(email9);
		emails.add(email10);
		emails.add(email11);
		emails.add(email12);
		
		for (Email email : emails) {
			EmailRunnable runnable = new EmailRunnable(email);
			Thread t = new Thread(runnable);
			t.start();
		}		
		
	}

}
