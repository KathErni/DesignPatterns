package Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DIY {
    public static void main(String[] args) {
        
        var editor =  new Editor();
        var history = new History();

        Scanner scanner = new Scanner(System.in);
        List <String> inputs = new ArrayList<>();

        System.out.println("Enter a word then type 'exit' to finish:");

        while(true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
           inputs.add(input); 
           editor.setContent(input);
           history.push(editor.createState());

        }
        System.out.println("\nStored states:");
        for (String input: inputs){
            System.out.println(input);
        }
        System.out.println("\nRstoring States");
        editor.restore(history.pop());
            System.out.println("Last word Restored:" + editor.getContent());
                

            scanner.close();
                
            }
        }
        //Originator
        class Editor{
            private String content;
        
            public EditorState createState(){
                return new EditorState(content);
            }
        
            public void restore(EditorState state){
                content = state.getContent();
            }
        
            public String getContent(){
                return content;
            }
            public void setContent(String content){
                this.content = content;
            }
        
        }
        //Memento
        class EditorState{
            private final String content;
            
                public EditorState(String content){
                    this.content = content;
            }
        
            public String getContent(){
                return content;
            }
        }
        //History
        class History{
            private List<EditorState> states = new ArrayList<>();
        
            public void push(EditorState state){
                states.add(state);
            }
        
            public EditorState pop(){
                var lastIndex = states.size()-1;
                var lastState = states.get(lastIndex);
                 states.remove(lastIndex);
                return lastState;
    }
    
}
