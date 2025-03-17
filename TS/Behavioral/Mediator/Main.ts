
class Mediator {
  colleague1: Colleague1;  colleague2: Colleague2;

  constructor() {
    this.colleague1 = new Colleague1();
    this.colleague2 = new Colleague2();
  }

  colleague1Method() {
    return this.colleague1.method1();
  }

  colleague2Method() {
    return this.colleague2.method2();
  }
}

class Colleague1 {

  method1() {
    return "Here is the Colleague1 specific data you asked for";
  }
}

class Colleague2 {

  method2() {
    return "Here is the Colleague2 specific data you asked for";
  }
}

// The Client
const MEDIATOR = new Mediator();

let DATA = MEDIATOR.colleague2Method();
console.log(`COLLEAGUE1 <--> ${DATA}`);

DATA = MEDIATOR.colleague1Method();
console.log(`COLLEAGUE2 <--> ${DATA}`);
