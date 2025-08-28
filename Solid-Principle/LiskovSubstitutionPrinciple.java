interface PaymentMethod {
    void pay();
}

class CreditCard implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}

class DebitCard implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Processing debit card payment");
    }
}

class PaymentProcessor {
    void process(PaymentMethod paymentMethod) {
        paymentMethod.pay();
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod credit = new CreditCard();
        PaymentMethod debit = new DebitCard();

        processor.process(credit); 
        processor.process(debit);  
    }
}
