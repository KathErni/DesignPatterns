// The Interpreter Pattern Example for Boolean Expressions

interface IBooleanExpression {
  interpret(context: { name: string; value: boolean }[]): boolean;
}

class VariableExpression implements IBooleanExpression {
  private name: string;

  constructor(name: string) {
    this.name = name;
  }

  interpret(context: { name: string; value: boolean }[]): boolean {
    const variable = context.find((v) => v.name === this.name);
    return variable ? variable.value : false;
  }
}

class AndExpression implements IBooleanExpression {
  private left: IBooleanExpression;
  private right: IBooleanExpression;

  constructor(left: IBooleanExpression, right: IBooleanExpression) {
    this.left = left;
    this.right = right;
  }

  interpret(context: { name: string; value: boolean }[]): boolean {
    return this.left.interpret(context) && this.right.interpret(context);
  }
}

class OrExpression implements IBooleanExpression {
  private left: IBooleanExpression;
  private right: IBooleanExpression;

  constructor(left: IBooleanExpression, right: IBooleanExpression) {
    this.left = left;
    this.right = right;
  }

  interpret(context: { name: string; value: boolean }[]): boolean {
    return this.left.interpret(context) || this.right.interpret(context);
  }
}

class NotExpression implements IBooleanExpression {
  private expression: IBooleanExpression;

  constructor(expression: IBooleanExpression) {
    this.expression = expression;
  }

  interpret(context: { name: string; value: boolean }[]): boolean {
    return !this.expression.interpret(context);
  }
}

// The Client
const context = [
  { name: "A", value: true },
  { name: "B", value: false },
  { name: "C", value: true },
];

// Constructing the expression: (A AND B) OR (C AND (NOT B))
const expression = new OrExpression(
  new AndExpression(new VariableExpression("A"), new VariableExpression("B")),
  new AndExpression(
    new VariableExpression("C"),
    new NotExpression(new VariableExpression("B"))
  )
);

console.log(
  `The result of the expression is: ${expression.interpret(context)}`
);
