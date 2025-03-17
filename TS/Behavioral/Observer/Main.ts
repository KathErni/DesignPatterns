//Modified

interface IObservable {
  subscribe(observer: IObserver): void;
  unsubscribe(observer: IObserver): void;
  notify(...args: unknown[]): void;
}

class Subject implements IObservable {
  private observers: IObserver[];

  constructor() {
    this.observers = [];
  }

  subscribe(observer: IObserver) {
    this.observers.push(observer);
  }

  unsubscribe(observer: IObserver) {
    this.observers = this.observers.filter((obs) => obs !== observer);
  }

  notify(...args: unknown[]) {
    this.observers.forEach((observer) => {
      observer.notify(...args);
    });
  }
}

interface IObserver {
  update(): unknown;
  notify(...args: unknown[]): void;
}

class Observer implements IObserver {
  private id: number;

  constructor(observable: IObservable) {
    this.id = COUNTER++;
    observable.subscribe(this);
  }

  update(): unknown {
    throw new Error("Method not implemented.");
  }

  notify(...args: unknown[]) {
    console.log(`OBSERVER_${this.id} received ${JSON.stringify(args)}`);
  }
}

let COUNTER = 1;

const SUBJECT = new Subject();
const OBSERVER_1 = new Observer(SUBJECT);
const OBSERVER_2 = new Observer(SUBJECT);

SUBJECT.notify("First Notification", [1, 2, 3]);

SUBJECT.unsubscribe(OBSERVER_2);

SUBJECT.notify("Second Notification", { A: 1, B: 2, C: 3 });
