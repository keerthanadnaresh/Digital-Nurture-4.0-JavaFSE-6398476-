
interface PaymentGateway {
    void executePayment(double amount);
}


class PaymateService {
    public void payWithPaymate(double amount) {
        System.out.println("Processing INR " + amount + " through Paymate.");
    }
}


class QuickStripeAPI {
    public void sendPayment(double usdAmount) {
        System.out.println("Processing $" + usdAmount + " through QuickStripe.");
    }
}


class PaymateAdapter implements PaymentGateway {
    PaymateService paymate;

    public PaymateAdapter(PaymateService paymate) {
        this.paymate = paymate;
    }

    @Override
    public void executePayment(double amount) {
        paymate.payWithPaymate(amount);
    }
}


class QuickStripeAdapter implements PaymentGateway {
    QuickStripeAPI stripe;

    public QuickStripeAdapter(QuickStripeAPI stripe) {
        this.stripe = stripe;
    }

    @Override
    public void executePayment(double amount) {
        stripe.sendPayment(amount); 
    }
}


public class AdapterPattern {
    public static void main(String[] args) {
        PaymentGateway indianGateway = new PaymateAdapter(new PaymateService());
        indianGateway.executePayment(2500);

        System.out.println();

        PaymentGateway internationalGateway = new QuickStripeAdapter(new QuickStripeAPI());
        internationalGateway.executePayment(40); 
    }
}
