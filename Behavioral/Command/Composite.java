package Command;

import java.util.ArrayList;
import java.util.List;

public class Composite{
    public static void main(String[] args) {
        var composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add (new BlackandWhiteCommand());
        composite.execute();
    }
}

class ResizeCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Resize");
    }

}

class BlackandWhiteCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Black and white");
    }

}

class CompositeCommand implements Command{
    private List<Command> commands = new ArrayList<>();

    public void add(Command command){
        commands.add(command);
    }
     @Override
    public void execute() {
        for(var command:commands){
            command.execute();
        }
     }

}

interface Command{
    void execute();
}