package Creational.Prototype;

public class Main {
    public static void main(String[] args) {
        var menu = new ContextMenu();
        menu.duplicate(new Circle());
        
    }
}

//Acts as the prototype
interface Component{
   void render();
   Component clone();
}

class Circle implements Component{
    private int radius;

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public void render() {
       System.out.println("Rendering a Circle"); 
     }

     public Component clone(){
        Circle newCircle = new Circle();
        newCircle.setRadius(radius);
        return newCircle;
     }
}

class ContextMenu{
    
 public void duplicate(Component component){
        Component newComponent = component.clone();
        System.out.println("Original component:");
        component.render();
        System.out.println("Duplicated component:");
        newComponent.render();
        
    }
 }
