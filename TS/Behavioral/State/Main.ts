// The State Pattern Concept

class Context {
  private stateHandles: IState[];
  private handle: IState | undefined;

  constructor() {
    this.stateHandles = [
      new ConcreteStateA(),
      new ConcreteStateB(),
      new ConcreteStateC(),
    ];
    this.handle = undefined;
  }

  request() {
    this.handle = this.stateHandles[Math.floor(Math.random() * 3)];
    return this.handle.toString();
  }
}

interface IState {
  toString(): string;
}

class ConcreteStateA implements IState {
  toString() {
    return "I am ConcreteStateA";
  }
}

class ConcreteStateB implements IState {
  toString() {
    return "I am ConcreteStateB";
  }
}

class ConcreteStateC implements IState {
  toString() {
    return "I am ConcreteStateC";
  }
}

const CONTEXT = new Context();
console.log(CONTEXT.request());
console.log(CONTEXT.request());
console.log(CONTEXT.request());
console.log(CONTEXT.request());
console.log(CONTEXT.request());
