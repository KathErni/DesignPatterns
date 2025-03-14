package Creational.Factory;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new ProductsController().listProducts();
    }
    
}
//Uses Default Implementation..

//Controller
class Controller{
    public void render(String viewName, Map<String,Object> context){
        var engine = creatViewEngine();
        var html = engine.render(viewName, context);
        System.out.println(html);
    }
    //Protected to ensure you can override the method in another class that extends this controller
    protected ViewEngine creatViewEngine(){
        return new MatchaViewEngine();
    }
}


//Uses inheritence and polymorphism
//You can either extend Sharpcontroller or Controller to change the Output of the superclass
class ProductsController extends SharpController{
    public void listProducts(){
        //Get products from database
        Map <String,Object> context = new HashMap<>();
        
        render("products.html", context);
    }

}

class SharpController extends Controller{
  @Override
  protected ViewEngine creatViewEngine() {
      return new SharpViewEngine();
  }

}
//frame work - Matcha
class Matcha{

}

class MatchaViewEngine implements ViewEngine{
    public String render(String viewName, Map<String,Object> context){
        return "View rendered by Matcha";
    }
    
}
//framework - SharpView
class SharpViewEngine implements ViewEngine{

    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "View rendered by Sharp";
    }
    
}



interface ViewEngine{
    String render(String viewName, Map<String,Object> context);
}