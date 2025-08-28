
class Order {
    private String orderDetails;

    public void setOrderDetails(String details) {
        this.orderDetails = details;
    }

    public String getOrderDetails() {
        return orderDetails;
    }
}


class OrderProcessor {
    public void processOrder(Order order) {
        System.out.println("Processing Order: " + order.getOrderDetails());
    }
}


public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderDetails("Order details here");
        
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);
    }
}
