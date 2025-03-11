package Visitor;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        var document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.execute(new PlainTextoperation());

    }
    
}

interface HtmlNode{
    void execute(Operation operation);

}


class HeadingNode implements HtmlNode{

    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }

}

class AnchorNode implements HtmlNode{

    @Override
    public void execute(Operation operation) {
       operation.apply(this);
    }

}

class HtmlDocument{
    private List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node){
        nodes.add(node);

    }

    public void execute(Operation operation){
        for(var node: nodes)
        node.execute(operation);

    }
}

//visitor
interface Operation{
  void apply(HeadingNode heading);
  void apply(AnchorNode anchor);
}

class HighlightOperation implements Operation{

    @Override
    public void apply(HeadingNode heading) {
      System.out.println("Highlight heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
       System.out.println("Highlight anchor");
    }
    
}

class PlainTextoperation implements Operation{

    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Text-heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
      System.out.println("Text-anchor");
    }
    
}
