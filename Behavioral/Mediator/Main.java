package Mediator;

public class Main {
    public static void main(String[] args) {
        var dialog = new ArticledDialogBox();
        dialog.simulateUserIntercation();

        

        
    }
}



class ListBox extends UIControl{
    
    public ListBox(DialogBox owner) {
            super(owner);
            
        }
        private String selection;

    public String getSelection(){
        return selection;
    }
    public void setSelection(String selection){
        this.selection = selection;
        owner.changed(this);
    }
}

class TextBox extends UIControl{

    public TextBox(DialogBox owner) {
            super(owner);
            
        }
    
        private String content;

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
        owner.changed(this);
    }
}

class Button extends UIControl{
    public Button(DialogBox owner) {
            super(owner);
           
        }
    
        private Boolean isEnabled;

    public boolean isEnabled(){
       return isEnabled;
    }

    public void setEnabled(boolean enabled){
        isEnabled = enabled;
        owner.changed(this);
    }
}

class UIControl{
    protected DialogBox owner;
    public UIControl(DialogBox owner){
        this.owner=owner;
    }

}

//acts as the mediator
abstract class DialogBox{
    public abstract void changed(UIControl control);
}

class ArticledDialogBox extends DialogBox{
private ListBox articlesListBox = new ListBox(this);
private TextBox titlTextBox = new TextBox(this);
private Button saveButton = new Button(this);
public void simulateUserIntercation(){
    articlesListBox.setSelection("Article 1");
    System.out.println("TextBox" + titlTextBox.getContent());
    System.out.println("Button: " + saveButton.isEnabled());
}
    @Override
    public void changed(UIControl control) {
       if(control == articlesListBox)
       articleSelected();
       else if (control == titlTextBox)
       titleChanged();
    }

    private void articleSelected(){
        titlTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }

    private void titleChanged(){
        var content = titlTextBox.getContent();
        var isEmpty = (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }
    
}