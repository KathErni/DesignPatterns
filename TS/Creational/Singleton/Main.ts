export class Singleton {
  static instance: Singleton;
  id: number;

  constructor(id: number) {
    this.id = id;
    if (Singleton.instance) {
      return Singleton.instance;
    }
    Singleton.instance = this;
  }
}

// The Client

const OBJECT1 = new Singleton(1);
const OBJECT2 = new Singleton(2);

console.log(OBJECT1 === OBJECT2);
console.log(OBJECT1.id);
console.log(OBJECT2.id);
