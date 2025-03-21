package Memento;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    
    var editor = new Editor();
    var history = new History();
    
    editor.setContent("a");
    history.push(editor.createState());
    editor.setContent("b");
    history.push(editor.createState());
    editor.setContent("c");
    editor.restore(history.pop());
    
    System.out.println(editor.getContent());
    
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

class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
  
 //History
 class History {
     private List<EditorState> states = new ArrayList<>();
     
     public void push(EditorState state){
         states.add(state);
     }
     public EditorState pop(){
         var lastIndex = states.size() -1;
         var lastState = states.get(lastIndex);
         states.remove(lastState);
         
         return lastState;
     }
 }
 