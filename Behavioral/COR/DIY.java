package COR;

public class DIY {
    public static void main(String[] args) {
        var receipt = new Receipt(null);
        var production = new Production(receipt);
        var supply = new Supply(production,10);
        var invoice = new Invoice(supply);

        var delivery = new DeliveryProcess(invoice);
        delivery.handle(new Order("Soup Can",2));
        delivery.handle(new Order("Soap Bar",2));
        delivery.handle(new Order("Soap Bar",10));

    }
    
}

class DeliveryProcess{
    private Handler handler;

    public DeliveryProcess(Handler handler){
        this.handler = handler;
    }
        public void handle(Order order){
        handler.handle(order);
        }
    }



class Order{
    private String prodName;
    private int quantity;

    public Order(String prodName, int quantity){
        this.prodName = prodName;
        this.quantity = quantity;
    }

    public String getProdname(){
        return prodName;
    }

    public int getQuantity(){
        return quantity;
    }
}

class Receipt extends Handler{

    public Receipt(Handler nextProcess) {
            super(nextProcess);
        }
    
        @Override
    boolean doHandle(Order order) {
        System.out.println("Receipt: Printing Receipt...");
        System.out.println("Receipt done. Delivery Process executed properly.");
       return false;
    }
    

}
class Production extends Handler{

    public Production(Handler nextProcess) {
            super(nextProcess);
            
        }
    
        @Override
    boolean doHandle(Order order) {
        System.out.println("Production: Producing " + order.getProdname() + "...");
        System.out.println("Item added for Deliver.");
        return false;

    }

}

class Supply extends Handler{
    private int stock;

    public Supply(Handler nextProcess, int stock) {
            super(nextProcess);
            this.stock=stock;
            }
    
        @Override
    boolean doHandle(Order order) {
     System.out.println("Supply: Supplier checking stocks...");
     if(order.getQuantity()> stock){
        System.out.println("Supply: No stocks available.");
        return true;
     }
     stock -= order.getQuantity();
     System.out.println("Supply: Stocks available. Remaining stock: " + stock + ".");
    return false;
    }

}

class Invoice extends Handler{

    public Invoice(Handler nextProcess) {
            super(nextProcess);
        }
    
        @Override
    boolean doHandle(Order order) {
       System.out.println("Invoice: Preparing for invoice of " + order.getProdname() + "..." );
       System.out.println("Invoice Sent.");


       return false;
    }

}

abstract class Handler{
    private Handler nextProcess;
    public Handler(Handler nextProcess){
        this.nextProcess = nextProcess;
    }
    public void handle(Order order){
        if(doHandle(order)){
            return;
        }
        if(nextProcess !=null){
            nextProcess.handle(order);
        }
    }

    abstract boolean doHandle(Order order);
}