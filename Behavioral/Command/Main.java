package Command;

public class Main {
    public static void main(String[] args) {
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}

class Button{
 private Command command;

   public Button(Command command){
      this.command = command;
   }


 public void click(){
    command.execute();

 }

}
//fx
class CustomerService{

   public void addCustomer(){
   System.out.println("Add customer");
   }
}
//app
class AddCustomerCommand implements Command{
   private CustomerService service;
   
   public AddCustomerCommand (CustomerService service){
      this.service = service;
   }
   @Override
   public void execute() {
      service.addCustomer();
   }
   
}

interface Command{
   void execute();
}
