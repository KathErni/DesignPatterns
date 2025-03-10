package State;


public class DIY {
    public static void main(String[] args) {
        var pc = new PlayerController();
        pc.setCurrentTool(new Walking());
        pc.keyUp();
        pc.keyDown();
        pc.keyLeft();
        pc.keyRight(); 
    }
}


class PlayerController {
    private Keys currentTool;

    public void keyUp() {
        currentTool.keyUp();
    }

    public void keyDown() {
        currentTool.keyDown();
    }

    public void keyLeft() {
        currentTool.keyLeft();
    }

    public void keyRight() {
        currentTool.keyRight();
    }

    public Keys getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Keys currentTool) {
        this.currentTool = currentTool;
    }
}

interface Keys {
    void keyUp();
    void keyDown();
    void keyLeft();
    void keyRight();
}

class Walking implements Keys {
    @Override
    public void keyUp() {
        System.out.println("Player is jumping.");
    }

    @Override
    public void keyDown() {
        System.out.println("Player is rolling.");
    }

    @Override
    public void keyLeft() {
        System.out.println("Player is walking left.");
    }

    @Override
    public void keyRight() {
        System.out.println("Player is walking right.");
    }
}

class Inventory implements Keys {
    @Override
    public void keyUp() {
        System.out.println("Move highlighted box up");
    }

    @Override
    public void keyDown() {
        System.out.println("Move highlighted box down");
    }

    @Override
    public void keyLeft() {
        System.out.println("Move highlighted box left");
    }

    @Override
    public void keyRight() {
        System.out.println("Move highlighted box right");
    }
}

