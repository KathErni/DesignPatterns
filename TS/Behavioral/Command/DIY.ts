interface Command {
  execute(): void;
}

interface UndoableCommand extends Command {
  unexecute(): void;
}

class WordProcessor {
  private content: string;

  constructor() {
    this.content = "";
  }

  makeItalic(): void {
    this.content = `<i>${this.content}</i>`;
  }

  makeBold(): void {
    this.content = `<b>${this.content}</b>`;
  }

  makeUnderline(): void {
    this.content = `<u>${this.content}</u>`;
  }

  setContent(content: string): void {
    this.content = content;
  }

  getContent(): string {
    return this.content;
  }
}

class MakeItalic implements UndoableCommand {
  private prevContent: string;
  private document: WordProcessor;
  private commandhistory: CommandHistory;

  constructor(document: WordProcessor, commandhistory: CommandHistory) {
    this.document = document;
    this.commandhistory = commandhistory;
  }

  execute(): void {
    this.prevContent = this.document.getContent();
    this.document.makeItalic();
    this.commandhistory.push(this);
  }

  unexecute(): void {
    this.document.setContent(this.prevContent);
  }
}

class MakeBold implements UndoableCommand {
  private prevContent: string;
  private document: WordProcessor;
  private commandhistory: CommandHistory;

  constructor(document: WordProcessor, commandhistory: CommandHistory) {
    this.document = document;
    this.commandhistory = commandhistory;
  }

  execute(): void {
    this.prevContent = this.document.getContent();
    this.document.makeBold();
    this.commandhistory.push(this);
  }

  unexecute(): void {
    this.document.setContent(this.prevContent);
  }
}

class MakeUnderline implements UndoableCommand {
  private prevContent: string;
  private document: WordProcessor;
  private commandhistory: CommandHistory;

  constructor(document: WordProcessor, commandhistory: CommandHistory) {
    this.document = document;
    this.commandhistory = commandhistory;
  }

  execute(): void {
    this.prevContent = this.document.getContent();
    this.document.makeUnderline();
    this.commandhistory.push(this);
  }

  unexecute(): void {
    this.document.setContent(this.prevContent);
  }
}

class UndoCommand implements Command {
  private commandhistory: CommandHistory;

  constructor(commandhistory: CommandHistory) {
    this.commandhistory = commandhistory;
  }

  execute(): void {
    if (this.commandhistory.size() > 0) {
      const command = this.commandhistory.pop();
      if (command) {
        command.unexecute();
      }
    }
  }
}

class CommandHistory {
  private commands: UndoableCommand[] = [];
  // Deque<UndoableCommand> commands = new ArrayDeque<>();
  // const deque = new Deque<UndoableCommand>();

  push(command: UndoableCommand): void {
    this.commands.push(command);
  }

  pop(): UndoableCommand | undefined {
    return this.commands.pop();
  }

  size(): number {
    return this.commands.length;
  }
}

// The Client
const commandhistory = new CommandHistory();
const wordProcessor = new WordProcessor();
wordProcessor.setContent("Hi!");

const bold = new MakeBold(wordProcessor, commandhistory);
bold.execute();
console.log(wordProcessor.getContent());

const italic = new MakeItalic(wordProcessor, commandhistory);
italic.execute();
console.log(wordProcessor.getContent());

const underline = new MakeUnderline(wordProcessor, commandhistory);
underline.execute();
console.log(wordProcessor.getContent());

const undo = new UndoCommand(commandhistory);
undo.execute();
undo.execute();
undo.execute();
console.log(wordProcessor.getContent());
