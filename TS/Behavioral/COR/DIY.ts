class Order {
  private prodName: string;
  private quantity: number;

  constructor(prodName: string, quantity: number) {
    this.prodName = prodName;
    this.quantity = quantity;
  }

  getProdName(): string {
    return this.prodName;
  }

  getQuantity(): number {
    return this.quantity;
  }
}

abstract class Handler {
  private nextProcess: Handler | undefined;

  constructor(nextProcess?: Handler) {
    this.nextProcess = nextProcess;
  }

  handle(order: Order): void {
    if (this.doHandle(order)) {
      return;
    }
    if (this.nextProcess != null) {
      this.nextProcess.handle(order);
    }
  }

  abstract doHandle(order: Order): boolean;
}

class Receipt extends Handler {
  constructor(nextProcess?: Handler) {
    super(nextProcess);
  }

  doHandle(order: Order): boolean {
    console.log("Receipt: Printing Receipt...");
    console.log("Receipt done. Delivery Process executed properly.");
    return false;
  }
}

class Production extends Handler {
  constructor(nextProcess: Handler) {
    super(nextProcess);
  }

  doHandle(order: Order): boolean {
    console.log("Production: Producing " + order.getProdName() + "...");
    console.log("Item added for Deliver.");
    return false;
  }
}

class Supply extends Handler {
  private stock: number;

  constructor(nextProcess: Handler, stock: number) {
    super(nextProcess);
    this.stock = stock;
  }

  doHandle(order: Order): boolean {
    console.log("Supply: Supplier checking stocks...");
    if (order.getQuantity() > this.stock) {
      console.log("Supply: No stocks available.");
      return true;
    }
    this.stock -= order.getQuantity();
    console.log(
      "Supply: Stocks available. Remaining stock: " + this.stock + "."
    );
    return false;
  }
}

class Invoice extends Handler {
  constructor(nextProcess: Handler) {
    super(nextProcess);
  }

  doHandle(order: Order): boolean {
    console.log(
      "Invoice: Preparing for invoice of " + order.getProdName() + "..."
    );
    console.log("Invoice Sent.");
    return false;
  }
}

class DeliveryProcess {
  private handler: Handler;

  constructor(handler: Handler) {
    this.handler = handler;
  }

  handle(order: Order): void {
    this.handler.handle(order);
  }
}

// The Client
const receipt = new Receipt();
const production = new Production(receipt);
const supply = new Supply(production, 10);
const invoice = new Invoice(supply);

const delivery = new DeliveryProcess(invoice);
delivery.handle(new Order("Soup Can", 2));
delivery.handle(new Order("Soap Bar", 2));
delivery.handle(new Order("Soap Bar", 10));
