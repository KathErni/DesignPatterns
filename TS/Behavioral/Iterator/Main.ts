interface IIterator {
  next(): IAggregate;

  hasNext(): boolean;
}

class IteratorConcept implements IIterator {
  index: number;
  aggregates: IAggregate[];

  constructor(aggregates: IAggregate[]) {
    this.index = 0;
    this.aggregates = aggregates;
  }

  next() {
    if (this.index < this.aggregates.length) {
      const aggregate = this.aggregates[this.index];
      this.index += 1;
      return aggregate;
    }
    throw new Error("At End of Iterator");
  }

  hasNext() {
    return this.index < this.aggregates.length;
  }
}

interface IAggregate {
  method(): void;
}

class Aggregate implements IAggregate {
  method(): void {
    console.log("This method has been invoked");
  }
}

const AGGREGATES = [
  new Aggregate(),
  new Aggregate(),
  new Aggregate(),
  new Aggregate(),
];

const ITERABLE = new IteratorConcept(AGGREGATES);

while (ITERABLE.hasNext()) {
  ITERABLE.next().method();
}
