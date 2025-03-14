package Creational.AbstractFactory;

public class Main{
    public static void main(String[] args) {
        new ContactForm().render(new MaterialWidgetFactory());
    }
}

interface Widget{
    void render();
}

interface Button extends Widget{
    
}

interface TextBox extends Widget{

}

//Package - Material

class MaterialButton implements Button{

    @Override
    public void render() {
      System.out.println("Material Button");
    }
    
}

class MaterialTextBox implements TextBox{

    @Override
    public void render() {
        System.out.println("Material TextBox");
    }

}

//Ant

class AntButton implements Button{

    @Override
    public void render() {
      System.out.println("AntButton");
    }
    
}

class AntTextBox implements TextBox{

    @Override
    public void render() {
        System.out.println("AntTextBox");
    }

}

//app

class ContactForm{
    void render(WidgetFactory factory){

        factory.createButton().render();
        factory.createTextBox().render();

    }
}

interface WidgetFactory{
    Button createButton();
    TextBox createTextBox();
}

class MaterialWidgetFactory implements WidgetFactory{

    @Override
    public Button createButton() {
       return new MaterialButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MaterialTextBox();
    }
    

}

class AntWidgetFactory implements WidgetFactory{

    @Override
    public Button createButton() {
       return new AntButton();
    }

    @Override
    public TextBox createTextBox() {
        return new AntTextBox();
    }
    

}