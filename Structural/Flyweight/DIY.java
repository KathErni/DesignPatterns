package Structural.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DIY {
public static void main(String[] args) {
    var service = new CoordsService(new MobIconFactory());
    for (var coord : service.getCoordinates())
    coord.track();

}
    
}

class Coords{
    private int x;
    private int y;
    private MobsIcon mob;

    
    public Coords(int x,int y, MobsIcon mob) {
        this.x = x;
        this.y = y;
        this.mob = mob;
    }

    public void track(){
        System.out.printf("%s spotted at (%d,%d) ", mob.getMob(),x,y);
        System.out.println();
    }
 
}


class MobsIcon{
    private Mobs mob;
    private byte[] icon;

    public MobsIcon(Mobs mob, byte[]icon) {
        this.mob = mob;
    }

    public Mobs getMob() {
        return mob;
    }

}


class MobIconFactory{
    private Map<Mobs,MobsIcon> icons = new HashMap<>();

    public MobsIcon getMobIcon(Mobs type){
        if(!icons.containsKey(type)){
            var icon = new MobsIcon(type, null);
            icons.put(type,icon);
        }
        return icons.get(type);
    }
}

class CoordsService{
    private MobIconFactory factory;

    public CoordsService(MobIconFactory factory){
        this.factory=factory;
    }
    public List<Coords> getCoordinates(){
        List<Coords> coordinates = new ArrayList<>();
        var field1 = new Coords(1, 2, factory.getMobIcon(Mobs.WIZARD));
        var field2 = new Coords(3, 5, factory.getMobIcon(Mobs.GOBLIN));
        coordinates.add(field1);
        coordinates.add(field2);


        return coordinates;
    }

   
}


enum Mobs{
    GOBLIN,
    SLIME,
    WIZARD,
    BANDIT,
}
