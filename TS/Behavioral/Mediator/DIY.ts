interface DIYMediator {
  send(message: string, user: User): void;
  addUser(user: User): void;
}

class UsersImplementsMediator implements DIYMediator {
  private users: User[] = [];

  send(message: string, user: User): void {
    for (const u of this.users) {
      if (u !== user) {
        u.receive(message);
      }
    }
  }

  addUser(user: User): void {
    this.users.push(user);
  }
}

abstract class User {
  protected diymediator: DIYMediator;
  protected name: string;

  constructor(diymediator: DIYMediator, name: string) {
    this.diymediator = diymediator;
    this.name = name;
    diymediator.addUser(this);
  }

  abstract send(message: string): void;
  abstract receive(message: string): void;
}

class UserMessages extends User {
  constructor(diymediator: DIYMediator, name: string) {
    super(diymediator, name);
  }

  send(message: string): void {
    console.log(`${this.name}: Sending Messages- ${message}`);
    this.diymediator.send(message, this);
  }

  receive(message: string): void {
    console.log(`${this.name}: Receiving Messages- ${message}`);
  }
}

// The Client
const userMediator = new UsersImplementsMediator();
const david = new UserMessages(userMediator, "Martin");
const monteza = new UserMessages(userMediator, "Monteza");
const messy = new UserMessages(userMediator, "Messy");

monteza.send("Meeting Started.");
