class Editor {
  private content: string;

  constructor() {
    this.content = "";
  }

  createState(): EditorState {
    return new EditorState(this.content);
  }

  restore(state: EditorState): void {
    this.content = state.getContent();
  }

  getContent(): string {
    return this.content;
  }

  setContent(content: string): void {
    this.content = content;
  }
}

class EditorState {
  private readonly content: string;

  constructor(content: string) {
    this.content = content;
  }

  getContent(): string {
    return this.content;
  }
}

class MementoHistory {
  private states: EditorState[] = [];

  push(state: EditorState): void {
    this.states.push(state);
  }

  pop(): EditorState {
    const lastIndex = this.states.length - 1;
    const lastState = this.states[lastIndex];
    this.states.splice(lastIndex, 1);
    return lastState;
  }
}

// Usage
const editor = new Editor();
const mementoHistory = new MementoHistory();

editor.setContent("State 1");
mementoHistory.push(editor.createState());

editor.setContent("State 2");
mementoHistory.push(editor.createState());

editor.setContent("State 3");

console.log(editor.getContent()); // Output: State 3

editor.restore(mementoHistory.pop());
console.log(editor.getContent()); // Output: State 2

editor.restore(mementoHistory.pop());
console.log(editor.getContent()); // Output: State 1
