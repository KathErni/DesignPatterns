package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class DIY {
    public static void main(String[] args) {
        var playlist1 = new Group();
        playlist1.add(new Music("You Belong with Me"));
        playlist1.add(new Music("Teardrops on my Guitar"));

        var playlist2 = new Group();
        playlist2.add(new Music("Bad Guy"));
        playlist2.add(new Music("Ocean Eyes"));

        var group = new Group();
        group.add(playlist1);
        group.add(playlist2);

        
        playlist2.change();
        playlist2.stop();
        playlist1.play();
        group.stop();

    }


    
}
class Music implements Component {
private String name;

    public Music (String name){
        this.name=name;
    }
    @Override
    public void change() {
       System.out.println("Change music: " + name);
    }

    @Override
    public void play() {
       System.out.println("Play music: " + name);
    }

    @Override
    public void stop() {
       System.out.println("Stop music: " + name);
    }


}
class Group implements Component{
    private List<Component> components = new ArrayList<>();

    public void add(Component component){
        components.add(component);

    }
    @Override
    public void change() {
        for(var component: components){
            component.change();
        }
      
    }

    @Override
    public void play() {
        for(var component: components){
            component.play();
        }
    }

    @Override
    public void stop() {
      for(var component: components){
        component.stop();

      }
    }
   

}

interface Component{
    void change();
    void play();
    void stop();
}
