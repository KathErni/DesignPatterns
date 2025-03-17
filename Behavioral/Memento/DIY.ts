// Memento pattern concept
class Memento {
    constructor(state) {
      this.state = state;
    }
  }
  
  class Originator {
    constructor() {
      this._state = "";
    }
  
    get state() {
      return this._state;
    }
  
    set state(value) {
      this._state = value;
      console.log(`Originator: Set state to '${value}'`);
    }
  
    get memento() {
      console.log("Originator: Providing Memento of state to caretaker.");
      return new Memento(this._state);
    }
  
    set memento(value) {
      this._state = value.state;
      console.log(
        `Originator: State after restoring from Memento: '${this._state}'`
      );
    }
  }
  
  class CareTaker {
    constructor(originator) {
      this.originator = originator;
      this.mementos = [];
    }
  
    create() {
      console.log("CareTaker: Getting a copy of Originators current state");
      const memento = this.originator.memento;
      this.mementos.push(memento);
    }
  
    restore(index) {
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