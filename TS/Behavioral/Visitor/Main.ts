//Modified
interface IVisitor {
  visit(part: Part): void;
}

interface IVisitable {
  accept(visitor: IVisitor): void;
}

class Part implements IVisitable {
  name: string;
  value: number;
  parts: Part[];

  constructor(name: string, value: number, parent?: Part) {
    this.name = name;
    this.value = value;
    this.parts = [];
    if (parent) {
      parent.parts.push(this);
    }
  }

  accept(visitor: IVisitor) {
    this.parts.forEach((part) => {
      part.accept(visitor);
    });
    visitor.visit(this);
  }
}

const Part_A = new Part("A", 101);
const Part_B = new Part("B", 305, Part_A);
const Part_C = new Part("C", 185, Part_A);
const Part_D = new Part("D", -30, Part_B);

class PrintPartNamesVisitor implements IVisitor {
  visit(part: Part) {
    console.log(part.name);
  }
}

Part_A.accept(new PrintPartNamesVisitor());

class CalculatePartTotalsVisitor implements IVisitor {
  totalValue = 0;

  visit(part: Part) {
    this.totalValue += part.value;
  }
}

const CALC_TOTALS_VISITOR = new CalculatePartTotalsVisitor();
Part_A.accept(CALC_TOTALS_VISITOR);
console.log(CALC_TOTALS_VISITOR.totalValue);
