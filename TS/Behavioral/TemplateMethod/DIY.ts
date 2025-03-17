interface INotification {
  sendNotification(): void;
}

class DIYNotification implements INotification {
  sendNotification(): void {
    console.log("Message: Hello");
  }
}

abstract class Task {
  private notification: INotification;

  constructor(notification?: INotification) {
    this.notification = notification || new DIYNotification();
  }

  execute(): void {
    this.notification.sendNotification();
    this.doExecute();
  }

  protected abstract doExecute(): void;
}

class SendFile extends Task {
  protected doExecute(): void {
    console.log("File Sent!");
  }
}

class ReceiveFile extends Task {
  protected doExecute(): void {
    console.log("File Received!");
  }
}

// The Client
const sendFile = new SendFile();
sendFile.execute();

const receiveFile = new ReceiveFile();
receiveFile.execute();
