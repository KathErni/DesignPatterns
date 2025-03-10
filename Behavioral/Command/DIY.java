package Command;

import java.util.ArrayDeque;
import java.util.Deque;

public class DIY {
    public static void main(String[] args) {
        var history = new History();
        var document = new WordProcessor();
        document.setContent("Hi!");

        var bold = new MakeBold(document, history);
        bold.execute();
        System.out.println(document.getContent());

        var italic = new MakeItalic(document, history);
        italic.execute();
        System.out.println(document.getContent());

        var underline = new MakeUnderline(document, history);
        underline.execute();
        System.out.println(document.getContent());

        var undo = new UndoCommand(history);
        undo.execute();
        undo.execute();
        undo.execute();
        System.out.println(document.getContent());

      
    }
}

class WordProcessor {
    private String content;

    public void makeItalic() {
        content = "<i>" + content + "</i>";
    }

    public void makeBold() {
        content = "<b>" + content + "</b>";
    }

    public void makeUnderline() {
        content = "<u>" + content + "</u>";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class MakeItalic implements UndoableCommand {
    private String prevContent;
    private WordProcessor document;
    private History history;

    public MakeItalic(WordProcessor document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeItalic();
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.setContent(prevContent);
    }
}

class MakeBold implements UndoableCommand {
    private String prevContent;
    private WordProcessor document;
    private History history;

    public MakeBold(WordProcessor document, History history) {
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

class MakeUnderline implements UndoableCommand {
    private String prevContent;
    private WordProcessor document;
    private History history;

    public MakeUnderline(WordProcessor document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeUnderline();
        history.push(this);
    }

    @Override
    public void unexecute() {
        document.setContent(prevContent);
    }
}

class UndoCommand implements Command {
    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (history.size() > 0) {
            history.pop().unexecute();
        }
    }
}

class History {
    Deque<UndoableCommand> commands = new ArrayDeque<>();

    public void push(UndoableCommand command) {
        commands.add(command);
    }

    public UndoableCommand pop() {
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }
}

interface Command {
    void execute();
}

interface UndoableCommand extends Command {
    void unexecute();
}