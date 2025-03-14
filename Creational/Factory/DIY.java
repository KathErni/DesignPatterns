package Creational.Factory;


public class DIY {
    public static void main(String[] args) {
        new ProductControler().listProducts();
    }
}

abstract class ControllerMods{

    public void add( String fileName){
        
        var file = createFiles();
        file.render("GameofLife.exe");

    }
    //factory
    protected abstract Files createFiles();

}

//Product controller
class ProductControler extends HairController{
    public void listProducts(){
        add("mods.exe");
    }
    
    
}

//libraries
class diffHairMod implements Files{
    public void render(String fileName) {
        System.out.println("256 hairstyles added");
    }

}

 class HairController extends ControllerMods{
    @Override
    protected Files createFiles() {
        return new diffHairMod();
    }
}

//another library 

class addWingsMod implements Files{

    public void render(String fileName) {
        System.out.println("Wings added");
    }

}

class WingsController extends ControllerMods{

    @Override
    protected Files createFiles() {
      return new addWingsMod();
    }

}

interface Files{
   void render(String fileName);
}
