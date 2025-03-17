interface Keys {
  keyUp(): void;
  keyDown(): void;
  keyLeft(): void;
  keyRight(): void;
}

class Walking implements Keys {
  keyUp(): void {
    console.log("Player is jumping.");
  }

  keyDown(): void {
    console.log("Player is rolling.");
  }

  keyLeft(): void {
    console.log("Player is walking left.");
  }

  keyRight(): void {
    console.log("Player is walking right.");
  }
}

class Inventory implements Keys {
  keyUp(): void {
    console.log("Move highlighted box up");
  }

  keyDown(): void {
    console.log("Move highlighted box down");
  }

  keyLeft(): void {
    console.log("Move highlighted box left");
  }

  keyRight(): void {
    console.log("Move highlighted box right");
  }
}

class PlayerController {
  private currentTool: Keys;

  keyUp(): void {
    this.currentTool.keyUp();
  }

  keyDown(): void {
    this.currentTool.keyDown();
  }

  keyLeft(): void {
    this.currentTool.keyLeft();
  }

  keyRight(): void {
    this.currentTool.keyRight();
  }

  getCurrentTool(): Keys {
    return this.currentTool;
  }

  setCurrentTool(currentTool: Keys): void {
    this.currentTool = currentTool;
  }
}

// The Client
const pc = new PlayerController();
pc.setCurrentTool(new Walking());
pc.keyUp();
pc.keyDown();
pc.keyLeft();
pc.keyRight();
