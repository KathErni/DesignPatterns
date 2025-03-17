interface Credentials {
  write(username: string, password: string): void;
}

class Register implements Credentials {
  write(username: string, password: string): void {
    console.log("Username: " + username);
    console.log("Password: " + password);
  }
}

class AddData implements Credentials {
  private credentials: Credentials;

  constructor(credentials: Credentials) {
    this.credentials = credentials;
  }

  write(username: string, password: string): void {
    this.credentials.write(username, password);
  }
}

class HashData implements Credentials {
  private credentials: Credentials;

  constructor(credentials: Credentials) {
    this.credentials = credentials;
  }

  write(username: string, password: string): void {
    const encrypted = this.encrypt(password);
    this.credentials.write(username, encrypted);
  }

  private encrypt(password: string): string {
    return "@#)@(_)$(___@#)()!@$";
  }
}

class CompressedData implements Credentials {
  private credentials: Credentials;

  constructor(credentials: Credentials) {
    this.credentials = credentials;
  }

  write(username: string, password: string): void {
    const compressedUsername = this.compressUsername(username);
    const compressedPassword = this.compressPassword(password);
    this.credentials.write(compressedUsername, compressedPassword);
  }

  private compressUsername(username: string): string {
    return username.substring(0, 3);
  }

  private compressPassword(password: string): string {
    return password.substring(0, 5);
  }
}

class DIYDecorator {
  public static main(): void {
    DIYDecorator.storeCredentials(
      new HashData(new CompressedData(new Register()))
    );
  }

  public static storeCredentials(credentials: Credentials): void {
    credentials.write("Kathlynne Joy Moraga", "1234");
  }
}

DIYDecorator.main();
