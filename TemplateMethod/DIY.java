package TemplateMethod;

public class DIY {
    public static void main(String[] args) {
        var sendFile = new SendFile();
        sendFile.execute();
        var receiveFile = new ReceiveFile();
        receiveFile.execute();
    }
    
}

class SendFile extends Task{

    @Override
    public void doExecute() {
        System.out.println("File Sent!");
     }

}

class ReceiveFile extends Task{

    @Override
    public void doExecute() {
        System.out.println("File Received!");
     }

}

class Notification{
    public void sendNotification(){
        System.out.println("Message: Hello");
    }

}

abstract class Task{
    private Notification notification;
    public Task(){
        notification = new Notification();
    }
    public Task (Notification notfication){
        this.notification = notification;
    }

    public void execute(){
       notification.sendNotification();
       doExecute();
        
    }

    public abstract void doExecute();


}
