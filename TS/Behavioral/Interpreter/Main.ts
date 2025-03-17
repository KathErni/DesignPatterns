
interface IAbstractExpression {
  interpret(): number;
}

class Numeral implements IAbstractExpression {

  value: number;

  constructor(value: string) {
    this.value = parseInt(value);
  }

  interpret(): number {
    return this.value;
  }
}

class Add implements IAbstractExpression {
  left: IAbstractExpression;
  right: IAbstractExpression;

  constructor(left: IAbstractExpression, right: IAbstractExpression) {
    this.left = left;
    this.right = right;
  }

  interpret() {
    return this.left.interpret() + this.right.interpret();
  }
}

class Subtract implements IAbstractExpression {
  left: IAbstractExpression;
  right: IAbstractExpression;

  constructor(left: IAbstractExpression, right: IAbstractExpression) {
    this.left = left;
    this.right = right;
  }

  interpret() {
    return this.left.interpret() - this.right.interpret();
  }
}

// The Client
const SENTENCE = "5 + 4 - 3 + 7 - 2";
console.log(SENTENCE);

const TOKENS = SENTENCE.split(" ");
console.log(JSON.stringify(TOKENS));

const AST: IAbstractExpression[] = []; // An array of AbstractExpressions
AST.push(new Add(new Numeral(TOKENS[0]), new Numeral(TOKENS[2]))); // 5 + 4
AST.push(new Subtract(AST[0], new Numeral(TOKENS[4]))); // ^ - 3
AST.push(new Add(AST[1], new Numeral(TOKENS[6]))); // ^ + 7
AST.push(new Subtract(AST[2], new Numeral(TOKENS[8]))); // ^ - 2

const AST_ROOT = AST.pop();

console.log((AST_ROOT as IAbstractExpression).interpret());

console.dir(AST_ROOT, { depth: null });
