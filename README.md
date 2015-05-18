# Mail-Sender-With-Creational-Patterns
1. Create a system which can work(send emails) with different kind of email vendors (Microsoft exchange, Lotus Domino, Zimbra, etc ). 
2. System should have an ability to extend the number of vendors and has to be transparent against them. 
3. Each vendor should be unique and loaded only once and reused.
4. Different vendors should be able to used simultaneously.
5. System should be able to deal easy with the fact that each email has a lot of different options we can setup while creating them (mail vendor to be used, from, to, cc, subject, content, attachments and etc..). 
6. System should be able to support up to 5 internet connections per vendor by default that can be used to send or receive emails but can extend the list with connections to up to 10 max per vendor if hi traffic. 

And as usually in practice happen in the latest possible moment, we have additional requirements, but optional for you:
The system should be able to receive emails, and reply them back fast and easy.
