interface SaveFile {
  add(): void;
  clone(): Save;
}

class Save implements SaveFile {
  private fileName: string;

  public getFileName(): string {
    return this.fileName;
  }

  public setFileName(fileName: string): void {
    this.fileName = fileName;
  }

  public add(): void {
    console.log("File saved!");
  }

  public clone(): Save {
    const newLoad = new Save();
    newLoad.setFileName(this.fileName);
    return newLoad;
  }
}

class Menu {
  public copy(file: SaveFile): void {
    const newFile = file.clone();
    console.log("Original Save File: ");
    file.add();
    console.log("Copied Save File: ");
    newFile.add();
  }
}

// Main function
function DIYPrototype(): void {
  const menu = new Menu();
  menu.copy(new Save());
}

DIYPrototype();
