
interface Notifier {
    void send(String message);
}


class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }
}


class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message: " + message);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }
}


public class NotificationSystem {
    public static void main(String[] args) {
        
        Notifier baseNotifier = new EmailNotifier();

        
        Notifier fullNotifier = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(baseNotifier));

       
        fullNotifier.send("Your appointment is scheduled at 4 PM today.");
    }
}
