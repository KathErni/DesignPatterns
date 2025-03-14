

public class DIY {
    public static void main(String[] args) {
        System.out.println("Windows OS");
        new Application().add(new WindowFactory());
        System.out.println("Mac OS");
        new Application().add(new MacFactory());
    }
}

interface GUITools{
    void add();

}

//object 1
interface Button extends GUITools {

}

//object 2
interface TextField extends GUITools{


}

interface Title extends GUITools{

} 

//family 1
//class 1

class WindowsOSBtn implements Button {
    @Override
    public void add(){
        System.out.println("<button> Windows Button </button>");
    }
}

//object2 

class WindwOSText implements TextField {
    @Override
    public void add(){
        System.out.println("Windows: Hello, Windows");
    }

}

class WindowOSTitle implements Title{

    @Override
    public void add() {
        System.out.println("Title (Windows)");
    }
    
}

//family 2 
//class 2 

class MacOSBtn implements Button{
    @Override
    public void add(){
        System.out.println("<button> Mac Button </button>");
    }
}

//object2 

class MacOSText implements TextField  {
    @Override
    public void add(){
        System.out.println("Mac: Hello, Mac");
    }

}

class MacOSTitle implements Title{

    @Override
    public void add() {
       System.out.println("Title (Mac)");
    }
    
}
//app 
class Application{
    void add(ToolFactory factory){
        System.out.println("-----------------------");
        factory.creaTitle().add();
        factory.createText().add();
        factory.createButton().add();
        System.out.println("-----------------------\n");
       
        
    }
}

//interface for the objects 

interface ToolFactory {

    Button createButton();
    TextField createText();
    Title creaTitle();

}

//factory for class 1
class WindowFactory implements ToolFactory{
    @Override
    public Button createButton() {
       return new WindowsOSBtn();
    }
    @Override
    public TextField createText() {
       return new WindwOSText();
    }
    @Override
    public Title creaTitle() {
        return new WindowOSTitle();
    }
}


//factory for class 2
class MacFactory implements ToolFactory{
    @Override
    public Button createButton() {
        return new MacOSBtn();
    }
    @Override
    public TextField createText() {
       return new MacOSText();
    }
    @Override
    public Title creaTitle() {
        return new MacOSTitle();
    }
}



