interface PaymentMethod {
    void makePayment(double amount);
}


class CreditCardPayment implements PaymentMethod {
    String cardNumber;
    String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid INR " + amount + " using Credit Card: " + cardHolder + " [" + cardNumber + "]");
    }
}

class PayPalPayment implements PaymentMethod {
    String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid INR " + amount + " using PayPal: " + email);
    }
}



class PaymentService {
    private PaymentMethod method;

    public void setPaymentMethod(PaymentMethod method) {
        this.method = method;
    }

    public void process(double amount) {
        if (method == null) {
            System.out.println("Payment method not selected!");
        } else {
            method.makePayment(amount);
        }
    }
}


public class StrategyPattern{
    public static void main(String[] args) {
        PaymentService payment = new PaymentService();

        
        payment.setPaymentMethod(new CreditCardPayment("1234-5678-9101-1121", "Aman Verma"));
        payment.process(2500);

        
        payment.setPaymentMethod(new PayPalPayment("aman@example.com"));
        payment.process(1800);
    }
}
