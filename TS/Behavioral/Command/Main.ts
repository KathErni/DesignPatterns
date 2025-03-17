interface ICommand {
  execute(): void;
}

class Invoker {
  #commands: { [id: string]: ICommand };

  constructor() {
    this.#commands = {};
  }

  register(commandName: string, command: ICommand) {
    this.#commands[commandName] = command;
  }

  execute(commandName: string) {
    if (commandName in this.#commands) {
      this.#commands[commandName].execute();
    } else {
      console.log(`Command [${commandName}] not recognised`);
    }
  }
}

class Receiver {
  runCommand1() {
    console.log("Executing Command 1");
  }

  runCommand2() {
    console.log("Executing Command 2");
  }
}

class Command1 implements ICommand {
  #receiver: Receiver;

  constructor(receiver: Receiver) {
    this.#receiver = receiver;
  }

  execute() {
    this.#receiver.runCommand1();
  }
}

class Command2 implements ICommand {
  #receiver: Receiver;

  constructor(receiver: Receiver) {
    this.#receiver = receiver;
  }

  execute() {
    this.#receiver.runCommand2();
  }
}

const RECEIVER = new Receiver();

const COMMAND1 = new Command1(RECEIVER);
const COMMAND2 = new Command2(RECEIVER);

const INVOKER = new Invoker();
INVOKER.register("1", COMMAND1);
INVOKER.register("2", COMMAND2);

INVOKER.execute("1");
INVOKER.execute("2");
INVOKER.execute("1");
INVOKER.execute("2");
