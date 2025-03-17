class ImageDIY {
  // Image class implementation
}

interface Filter {
  apply(imageDiy: ImageDIY): void;
}

class VividFilter implements Filter {
  apply(imageDiy: ImageDIY): void {
    console.log("Applying Vivid Filter");
  }
}

class Caramel {
  init(): void {
    // Initialization code
  }

  render(imageDiy: ImageDIY): void {
    console.log("Applying caramel filter");
  }
}

class CaramelFilter implements Filter {
  private caramel: Caramel;

  constructor(caramel: Caramel) {
    this.caramel = caramel;
  }

  apply(imageDiy: ImageDIY): void {
    this.caramel.init();
    this.caramel.render(imageDiy);
  }
}

// Using inheritance
class CaramelAdapter extends Caramel implements Filter {
  apply(imageDiy: ImageDIY): void {
    this.init();
    this.render(imageDiy);
  }
}

class ImageView {
  private imageDiy: ImageDIY;

  constructor(imageDiy: ImageDIY) {
    this.imageDiy = imageDiy;
  }

  apply(filter: Filter): void {
    filter.apply(this.imageDiy);
  }
}

class UsingInheritance {
  public static main(): void {
    const imageView = new ImageView(new ImageDIY());
    // The interface of the Caramel doesn't have the Filter interface
    imageView.apply(new CaramelFilter(new Caramel()));
  }
}

UsingInheritance.main();
