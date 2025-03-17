// Memento pattern concept
class Memento {
    state: string;
    constructor(state: string) {
      this.state = state;
    }
  }
  
  class Originator {
    private _state: string;
  
    constructor() {
      this._state = "";
    }
  
    public get state(): string {
      return this._state;
    }
  
    public set state(value: string) {
      this._state = value;
      console.log(`Originator: Set state to '${value}'`);
    }
  
    public get memento(): Memento {
      console.log("Originator: Providing Memento of state to caretaker.");
      return new Memento(this._state);
    }
  
    public set memento(value: Memento) {
      this._state = value.state;
      console.log(
        `Originator: State after restoring from Memento: '${this._state}'`
      );
    }
  }
  
  class CareTaker {
    private originator: Originator;
    private mementos: Memento[];
  
    constructor(originator: Originator) {
      this.originator = originator;
      this.mementos = [];
    }
  
    create() {
      console.log("CareTaker: Getting a copy of Originators current state");
      const memento = this.originator.memento;
      this.mementos.push(memento);
    }
  
    restore(index: number) {
      console.log("CareTaker: Restoring Originators state from Memento");
      const memento = this.mementos[index];
      this.originator.memento = memento;
    }
  }
  
  // The Client
  const ORIGINATOR = new Originator();
  const CARETAKER = new CareTaker(ORIGINATOR);
  
  ORIGINATOR.state = "State #1";
  ORIGINATOR.state = "State #2";
  
  // lets backup the originators
  CARETAKER.create();
  
  ORIGINATOR.state = "State #3";
  CARETAKER.create();
  
  ORIGINATOR.state = "State #4";
  console.log(ORIGINATOR.state);
  
  CARETAKER.restore(0);
  console.log(ORIGINATOR.state);
  
  CARETAKER.restore(1);
  console.log(ORIGINATOR.state);
  