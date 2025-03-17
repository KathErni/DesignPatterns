abstract class ControllerMods {
  public add(fileName: string): void {
    const file = this.createFiles();
    file.render("GameofLife.exe");
  }

  // Factory method
  protected abstract createFiles(): Files;
}

class HairController extends ControllerMods {
  protected createFiles(): Files {
    return new DiffHairMod();
  }
}
// Product controller
class ProductController extends HairController {
  public listProducts(): void {
    this.add("mods.exe");
  }
}

// Libraries
class DiffHairMod implements Files {
  public render(fileName: string): void {
    console.log("256 hairstyles added");
  }
}
class WingsController extends ControllerMods {
  protected createFiles(): Files {
    return new AddWingsMod();
  }
}

// Another library
class AddWingsMod implements Files {
  public render(fileName: string): void {
    console.log("Wings added");
  }
}

interface Files {
  render(fileName: string): void;
}

// Main function
function DIYFactory(): void {
  new ProductController().listProducts();
}

DIYFactory();
