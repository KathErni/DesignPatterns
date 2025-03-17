// Abstract Factory Concept Sample Code
interface IProduct extends IProductA, IProductB {}

class AbstractFactory {
  // The Abstract Factory Concrete Class

  static createObject(factory: string): IProduct | undefined {
    try {
      if (["aa", "ab", "ac"].indexOf(factory) > -1) {
        return FactoryA.getObject(factory[1]);
      }
      if (["ba", "bb", "bc"].indexOf(factory) > -1) {
        return FactoryB.getObject(factory[1]);
      }
      throw new Error("No Factory Found");
    } catch (e) {
      console.log(e);
    }
  }
}

// The Client
let PRODUCT = AbstractFactory.createObject("ab");
console.log(PRODUCT);

PRODUCT = AbstractFactory.createObject("bc");
console.log(PRODUCT);

interface IProductA {
  name: string;
}

class ConcreteProductA implements IProductA {
  name = "";
}

class ConcreteProductAFactoryA extends ConcreteProductA {
  constructor() {
    super();
    this.name = "FactoryA:ConcreteProductA";
  }
}

class ConcreteProductBFactoryA extends ConcreteProductA {
  constructor() {
    super();
    this.name = "FactoryA:ConcreteProductB";
  }
}

class ConcreteProductCFactoryA extends ConcreteProductA {
  constructor() {
    super();
    this.name = "FactoryA:ConcreteProductC";
  }
}

export class FactoryA {
  static getObject(some_property: string): IProductA {
    try {
      if (some_property === "a") {
        return new ConcreteProductAFactoryA();
      } else if (some_property === "b") {
        return new ConcreteProductBFactoryA();
      } else if (some_property === "c") {
        return new ConcreteProductCFactoryA();
      } else {
        throw new Error("Class Not Found");
      }
    } catch (e) {
      console.log(e);
    }
    return new ConcreteProductA();
  }
}

// FactoryB Sample Code

export interface IProductB {
  name: string;
}

class ConcreteProductB implements IProductB {
  name = "";
}

class ConcreteProductAFactoryB extends ConcreteProductB {
  constructor() {
    super();
    this.name = "FactoryB:ConcreteProductA";
  }
}

class ConcreteProductBFactoryB extends ConcreteProductB {
  constructor() {
    super();
    this.name = "FactoryB:ConcreteProductB";
  }
}

class ConcreteProductCFactoryB extends ConcreteProductB {
  constructor() {
    super();
    this.name = "FactoryB:ConcreteProductC";
  }
}

export class FactoryB {
  static getObject(some_property: string): IProductB {
    try {
      if (some_property === "a") {
        return new ConcreteProductBFactoryA();
      } else if (some_property === "b") {
        return new ConcreteProductBFactoryB();
      } else if (some_property === "c") {
        return new ConcreteProductCFactoryB();
      } else {
        throw new Error("Class Not Found");
      }
    } catch (e) {
      console.log(e);
    }
    return new ConcreteProductB();
  }
}
