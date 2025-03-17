interface IObservableDIY {
  addObserver(observerDIY: ObserverDIY): void;
  removeObserver(observerDIY: ObserverDIY): void;
  notify(...args: unknown[]): void;
}

interface ObserverDIY {
  update(): void;
  notify(...args: unknown[]): void;
}

class ObserverSubject implements IObservableDIY {
  private observers: ObserverDIY[] = [];

  addObserver(observerDIY: ObserverDIY): void {
    this.observers.push(observerDIY);
  }

  removeObserver(observerDIY: ObserverDIY): void {
    const index = this.observers.indexOf(observerDIY);
    if (index > -1) {
      this.observers.splice(index, 1);
    }
  }

  notify(...args: unknown[]): void {
    this.observers.forEach((observerDIY) => {
      observerDIY.notify(...args);
      observerDIY.update();
    });
  }
}

class DataSource extends ObserverSubject {
  private value: string;

  getValue(): string {
    return this.value;
  }

  setValue(value: string): void {
    this.value = value;
    this.notify(value);
  }
}
class Canvas implements ObserverDIY {
  private data: DataSource;

  constructor(data: DataSource) {
    this.data = data;
  }
  update(): void {
    console.log("Canvas got updated: " + this.data.getValue());
  }
  notify(...args: unknown[]): void {
    console.log(`Canvas set: ${JSON.stringify(args)}`);
  }
}

// The Client
const data = new DataSource();
const canvas1 = new Canvas(data);
const canvas2 = new Canvas(data);
const canvas3 = new Canvas(data);

data.addObserver(canvas1);
data.addObserver(canvas2);
data.removeObserver(canvas3);

data.setValue("Drawing");
