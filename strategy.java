import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");

        UPIPayment upiPayment = new UPIPayment();
        PayPalPayment payPalPayment = new PayPalPayment();

        PaymentManager paymentManager = new PaymentManager(upiPayment);
        paymentManager.pay(500l);

        paymentManager.setPaymentStrategy(payPalPayment);
        paymentManager.pay(1000l);
    }
}

interface PaymentStrategy{
    void pay(long amount);
}

class UPIPayment implements PaymentStrategy{
    @Override
    public void pay(long amount){
        System.out.println("Paid Rs." + amount + " using UPI");
    }
}

class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(long amount){
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

class PaymentManager{

    private PaymentStrategy paymentStrategy;

    PaymentManager(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy ;  
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(long amount){
        paymentStrategy.pay(amount);
    }

}

