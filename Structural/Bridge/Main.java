package Structural.Bridge;

public class Main {
    public static void main(String[] args) {
        var remoteControl = new RemoteControl(new SonyTV());
        remoteControl.turnOn();
    }
    
}
 
 class RemoteControl{
    protected Device device;
    public RemoteControl(Device device) {
        this.device = device;
    }
    public  void turnOn(){
        device.turnOn();
        
    }

    public  void turnOff(){
        device.turnOff();
    }

}

//additional setting
 class AdvancedRemoteControl extends RemoteControl{
    public AdvancedRemoteControl(Device device){
        super(device);
    }

    public void setChannel(int number){
        device.setChannel(number);
    }
   
}

//Remote Control
interface Device{
    void turnOn();
    void turnOff();
    void setChannel(int number);

}

class SonyTV implements Device{

    @Override
    public void turnOn() {
       System.out.println("Sony: Turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony: Turn Off");
    }

    public void setChannel(int number) {
        System.out.println("Sony: Set Channel");
    }
    
}

class SamsungTV implements Device{

    @Override
    public void turnOn() {
       System.out.println("Samsung: Turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung: Turn Off");
    }

    public void setChannel(int number) {
        System.out.println("Samsung: Set Channel");
    }
    
}