interface IProtoType {
  clone(): this;
}

class MyClass implements IProtoType {
  field: number[];

  constructor(field: number[]) {
    this.field = field; // any value of any type
  }

  clone() {
    return Object.assign({}, this); // shallow copy
    // return JSON.parse(JSON.stringify(this))
  }
}

// The Client
// Create an object containing an array
const OBJECT1 = new MyClass([1, 2, 3, 4]);
console.log(`OBJECT1: ${JSON.stringify(OBJECT1)}`);

const OBJECT2 = OBJECT1.clone(); // Clone
console.log(`OBJECT2: ${JSON.stringify(OBJECT2)}`);
OBJECT2.field[1] = 101;

// Comparing OBJECT1 and OBJECT2
console.log(`OBJECT2: ${JSON.stringify(OBJECT2)}`);
console.log(`OBJECT1: ${JSON.stringify(OBJECT1)}`);
