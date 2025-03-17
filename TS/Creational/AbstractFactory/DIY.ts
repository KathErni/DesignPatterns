interface GUITools {
  add(): void;
}

// Object 1
interface Button extends GUITools {}

// Object 2
interface TextField extends GUITools {}

// Object 3
interface Title extends GUITools {}

// Family 1
// Class 1
class WindowsOSBtn implements Button {
  add(): void {
    console.log("<button> Windows Button </button>");
  }
}

// Object 2
class WindowsOSText implements TextField {
  add(): void {
    console.log("Windows: Hello, Windows");
  }
}

// Object 3
class WindowsOSTitle implements Title {
  add(): void {
    console.log("Title (Windows)");
  }
}

// Family 2
// Class 2
class MacOSBtn implements Button {
  add(): void {
    console.log("<button> Mac Button </button>");
  }
}

// Object 2
class MacOSText implements TextField {
  add(): void {
    console.log("Mac: Hello, Mac");
  }
}

// Object 3
class MacOSTitle implements Title {
  add(): void {
    console.log("Title (Mac)");
  }
}

// Interface for the objects
interface ToolFactory {
  createButton(): Button;
  createText(): TextField;
  createTitle(): Title;
}

// Factory for class 1
class WindowFactory implements ToolFactory {
  createButton(): Button {
    return new WindowsOSBtn();
  }
  createText(): TextField {
    return new WindowsOSText();
  }
  createTitle(): Title {
    return new WindowsOSTitle();
  }
}

// Factory for class 2
class MacFactory implements ToolFactory {
  createButton(): Button {
    return new MacOSBtn();
  }
  createText(): TextField {
    return new MacOSText();
  }
  createTitle(): Title {
    return new MacOSTitle();
  }
}

// Application class
class Application {
  add(factory: ToolFactory): void {
    console.log("-----------------------");
    factory.createTitle().add();
    factory.createText().add();
    factory.createButton().add();
    console.log("-----------------------\n");
  }
}

// Main function
function DIYAbstract(): void {
  console.log("Windows OS");
  new Application().add(new WindowFactory());
  console.log("Mac OS");
  new Application().add(new MacFactory());
}

DIYAbstract();
