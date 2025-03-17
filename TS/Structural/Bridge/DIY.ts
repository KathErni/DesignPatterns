interface Device {
  isEnabled(): boolean;
  enable(): void;
  disable(): void;
  getVolume(): number;
  setVolume(percent: number): void;
  getChannel(): number;
  setChannel(channel: number): void;
  printStatus(): void;
}

class TV implements Device {
  private on: boolean = false;
  private volume: number = 30;
  private channel: number = 7;

  isEnabled(): boolean {
    return this.on;
  }

  enable(): void {
    this.on = true;
  }

  disable(): void {
    this.on = false;
  }

  getVolume(): number {
    return this.volume;
  }

  setVolume(volume: number): void {
    this.volume = volume;
  }

  getChannel(): number {
    return this.channel;
  }

  setChannel(channel: number): void {
    this.channel = Math.round(channel);
  }

  printStatus(): void {
    console.log("------------------------------------");
    console.log("| Model: TV-Panasonic W0ODQ123");
    console.log("| Status: " + (this.on ? "enabled" : "disabled"));
    console.log("| Volume level: " + this.getVolume() + "%");
    console.log("| Current channel is " + this.channel);
    console.log("------------------------------------\n");
  }
}

class Radio implements Device {
  private on: boolean = false;
  private volume: number = 20;
  private channel: number = 91.9;

  isEnabled(): boolean {
    return this.on;
  }

  enable(): void {
    this.on = true;
  }

  disable(): void {
    this.on = false;
  }

  getVolume(): number {
    return this.volume;
  }

  setVolume(volume: number): void {
    this.volume = volume;
  }

  getChannel(): number {
    return this.channel;
  }

  setChannel(channel: number): void {
    this.channel = channel;
  }

  printStatus(): void {
    console.log("------------------------------------");
    console.log("| Model: RADIO1XQ45");
    console.log("| Status:  " + (this.on ? "enabled" : "disabled"));
    console.log("| Volume level: " + this.getVolume() + "%");
    console.log("| Current channel is " + this.channel);
    console.log("------------------------------------\n");
  }
}

class BasicRemoteControl {
  protected device: Device;

  constructor(device: Device) {
    this.device = device;
  }

  power(): void {
    console.log("Remote: Device is toggled on.");
    if (this.device.isEnabled()) {
      this.device.disable();
    } else {
      this.device.enable();
    }
  }

  volumeDown(): void {
    console.log("Lowering volume...");
  }

  volumeUp(): void {
    console.log("Extending volume...");
  }

  changeChannel(): void {
    console.log("Changing channel...");
  }
}

class AdvancedRemoteControl extends BasicRemoteControl {
  constructor(device: Device) {
    super(device);
  }

  mute(): void {
    console.log("Volume Muted");
  }
}

class DIYBridge {
  public static main(): void {
    // Can be separated
    const remoteControl = new BasicRemoteControl(new TV());
    DIYBridge.testDevice(new TV());
    remoteControl.changeChannel();
    DIYBridge.testDevice(new Radio());
  }

  // Can be put together
  public static testDevice(device: Device): void {
    console.log("Testing with the Basic Remote Control");
    const basicRemote = new BasicRemoteControl(device);
    basicRemote.power();
    device.printStatus();

    console.log("Testing with the Advanced Remote Control");
    const advanceRemote = new AdvancedRemoteControl(device);
    advanceRemote.power();
    advanceRemote.mute();
    device.printStatus();
  }
}

DIYBridge.main();
