package State;

public class Main {
    public static void main(String[] args) {
        
        var canvas = new Canvas();
        canvas.setCurrentTool(new EraserTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}

class Canvas{
    private Tool currentTool;
    public void mouseUp(){
            currentTool.mouseUp();
    }
    public void mouseDown(){
            currentTool.mouseDown();
    }

    public Tool getCurrentTool(){
            return currentTool;
    }

    public void setCurrentTool(Tool currentTool){
            this.currentTool = currentTool;
    }
}

interface Tool{
    void mouseDown();
    void mouseUp();
}
class SelectionTool implements Tool{

    @Override
    public void mouseDown() {
        System.out.println("Selection icon");}

    @Override
    public void mouseUp() {
        System.out.println("Draw a dashed rectangle");
    }

}

class BrushTool implements Tool{

    @Override
    public void mouseDown() {
    System.out.println("Brush icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");
    }
    
}

class EraserTool implements Tool{

    @Override
    public void mouseDown() {
       System.out.println("Erase icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Erase something");
    }

}
