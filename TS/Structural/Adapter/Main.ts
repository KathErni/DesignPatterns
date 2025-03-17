interface IA {
  methodA(): void;
}

class ClassA implements IA {
  methodA() {
    console.log("method A");
  }
}

interface IB {
  methodB(): void;
}

class ClassB implements IB {
  methodB() {
    console.log("method B");
  }
}

class ClassBAdapter implements IA {
  #classB: ClassB;

  constructor() {
    this.#classB = new ClassB();
  }

  methodA() {
    "calls the class b method_b instead";
    this.#classB.methodB();
  }
}

const ITEMS = [new ClassA(), new ClassB()];
ITEMS.forEach((item) => {
  if (item instanceof ClassB) {
    item.methodB();
  } else {
    item.methodA();
  }
});

const ADAPTED = [new ClassA(), new ClassBAdapter()];
ADAPTED.forEach((item) => {
  item.methodA();
});
