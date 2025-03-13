package Structural.Bridge;

public class DIY {
    public static void main(String[] args) {
    //Can be separated
        var remoteControl = new BasicRemoteControl(new TV());
        testDevice(new TV());
        remoteControl.changeChannel();
        testDevice(new Radio());
    }
    //Can be put together
    public static void testDevice(Device device){
        System.out.println("Testing with the Basic Remote Control");
        BasicRemoteControl basicRemote = new BasicRemoteControl(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Testing with the Advanced Remote Control");
        AdvancedRemoteControl advanceRemote = new AdvancedRemoteControl(device);
        advanceRemote.power();
        advanceRemote.mute();
        device.printStatus();
    }

    
}

class BasicRemoteControl{
protected Device device;

public BasicRemoteControl(Device device) {
    this.device = device;
}

  void power(){
    System.out.println("Remote: Device is toggled on.");
    if(device.isEnabled()){
        device.disable();
      
    }
    device.enable();
  }

  void volumeDown(){
  
    System.out.println("Lowering volume...");
  }

  void volumeUp(){
    System.out.println("Extending volume...");
  }
  void changeChannel(){
    System.out.println("Changing channel...");
  }


}

class AdvancedRemoteControl extends BasicRemoteControl{
    public AdvancedRemoteControl(Device device){
        super(device);
    }
    public void mute(){
        System.out.println("Volume Muted");
    }
}

interface Device{
    boolean isEnabled();
    
    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(double channel);

    void printStatus();

}

class TV implements Device{
    private boolean on = false;
    private int volume= 30;
    private double channel=7;

    
    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
            this.volume=volume;
    }

    @Override
    public int getChannel() {
        return (int)channel;
    }

    @Override
    public void setChannel(double channel) {
      this.channel = Math.round(channel);
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Model: TV-Panasonic W0ODQ123");
        System.out.println("| Status: " + (on? "enabled" : "disabled"));
        System.out.println("| Volume level: " + getVolume() + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
       on = true;
    }

    @Override
    public void disable() {
       on = false;
    }

    

}

class Radio implements Device{
    private boolean on = false;
    private int volume=20;
    private double channel=91.9;

    @Override
    public boolean isEnabled() {
        return on;
        
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
        
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
       this.volume = volume;
    }

    @Override
    public int getChannel() {
       return (int)channel;
    }

    @Override
    public void setChannel(double channel) {
       this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Model: RADIO1XQ45");
        System.out.println("| Status:  " + (on? "enabled" : "disabled"));
        System.out.println("| Volume level: " + getVolume() + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}


