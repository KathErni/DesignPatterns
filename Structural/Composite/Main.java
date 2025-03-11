package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var group1 = new Group();
        group1.add(new Shape()); //square
        group1.add(new Shape()); // square

        var group2 = new Group();
        group2.add(new Shape()); //circle
        group2.add(new Shape()); //circle

        
        var group = new Group();
        group.add(group1);
        group.add(group2);
        group.render();
        group.move();
    }
    
}

class Shape implements Component{
    @Override
    public void render(){
        System.out.println("Render shape");
    }

    @Override
    public void move() {
        System.out.println("Move shape");
    }
}

class Group implements Component{
    private List<Component> components = new ArrayList<>();
    public void add(Component component){
        components.add(component);
    }
    @Override
    public void render(){
        for(var component:components){
        component.render();
        }
    }
    @Override
    public void move() {
        for(var component:components){
            component.move();
    }
}   
}

//interface that has the similirarities with the leaf and group
interface Component{
    void render();
    void move();
}


