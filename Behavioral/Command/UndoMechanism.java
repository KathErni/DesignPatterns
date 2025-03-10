package Command;

import java.util.ArrayDeque;
import java.util.Deque;


public class UndoMechanism {
    public static void main(String[] args) {
        var history =new History();
        var document = new HtmlDoc();
        document.setContent("Hello World");

        var boldCommand = new BoldCommand(document, history);
        boldCommand.execute();
        System.out.println(document.getContent());   
        
        var undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());
    }
}

//editor - Used in HTML to create webpages

class HtmlDoc{
    private String content;

    public void makeBold(){
        content = "<b>" + content + "</b>";
    }

    public void setContent (String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }

}

class UndoCommand implements Command{
    private History history;
    public UndoCommand (History history){
        this.history = history;
       }
    @Override
    public void execute() {
       if(history.size() >0)
        history.pop().unexecute();
      
    }
    
}

class BoldCommand implements UndoableCommand{
    private String prevContent;
    private HtmlDoc document;
    private History history;

    public BoldCommand(HtmlDoc document, History history){
        this.document = document;
        this.history = history;
    }
    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.setContent(prevContent);
    }

}

class History{
    Deque<UndoableCommand> commands = new ArrayDeque<>(); 
    public void push(UndoableCommand command){
        commands.add(command);
    }

    public UndoableCommand pop(){
        return commands.pop();
    }

    public int size(){
        return commands.size();
    }
}


interface UndoableCommand extends Command{
    void unexecute();
}

interface Command{
    void execute();
}

