interface LayerNodes {
  execute(operation: Operation): void;
}

interface Operation {
  applyResizeLayer1(layer1: Layer1): void;
  applyResizeLayer2(layer2: Layer2): void;
}

class Layer1 implements LayerNodes {
  execute(operation: Operation): void {
    operation.applyResizeLayer1(this);
  }
}

class Layer2 implements LayerNodes {
  execute(operation: Operation): void {
    operation.applyResizeLayer2(this);
  }
}

class DIYCanvas {
  private nodes: LayerNodes[] = [];

  add(node: LayerNodes): void {
    this.nodes.push(node);
  }

  execute(operation: Operation): void {
    for (const node of this.nodes) {
      node.execute(operation);
    }
  }
}

class ColorOperation implements Operation {
  applyResizeLayer1(layer1: Layer1): void {
    console.log("Colored layer 1");
  }

  applyResizeLayer2(layer2: Layer2): void {
    console.log("Colored layer 2");
  }
}

class ResizeOperation implements Operation {
  applyResizeLayer1(layer1: Layer1): void {
    console.log("Resized layer 1");
  }

  applyResizeLayer2(layer2: Layer2): void {
    console.log("Resized layer 2");
  }
}

// The Client
const canvas = new DIYCanvas();
canvas.add(new Layer1());
canvas.add(new Layer2());

canvas.execute(new ColorOperation());
