package Visitor;

import java.util.ArrayList;
import java.util.List;

public class DIY {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.add(new Layer1());
        canvas.add (new Layer2());

        canvas.execute(new ColorOperation());
    }
    
}
class Layer1 implements LayerNodes {

    @Override
    public void execute(Operation operation) {
       operation.apply(this);
        }

}

class Layer2 implements LayerNodes{

    @Override
    public void execute(Operation operation) {
    operation.apply(this);
    }

}

class Canvas{
    private List<LayerNodes> nodes = new ArrayList<>();

    public void add(LayerNodes node){
        nodes.add(node);
    }

    public void execute(Operation operation){
        for (var node: nodes){
            node.execute(operation);
        }
    }
}

interface LayerNodes{
    void execute(Operation operation);

}
interface Operation{

    void apply(Layer1 sketch);
    void apply(Layer2 line);

}

class ColorOperation implements Operation{

    @Override
    public void apply(Layer1 sketch) {
        System.out.println("Colored layer 1");
    }

    @Override
    public void apply(Layer2 line) {
        System.out.println("Colored layer 2");
    }
    
}

class ResizeOperation implements Operation{

    @Override
    public void apply(Layer1 sketch) {
        System.out.println("Resized layer 1");
    }

    @Override
    public void apply(Layer2 line) {
       System.out.println("Resized layer 2");
    }
    
}