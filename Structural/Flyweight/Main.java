package Structural.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        var service = new PointService(new PointIconFactory());
        for (var point: service.getPoints())
        point.draw();
    }
    
}

class Point{
    //In this area, the ram took to much storage as it is deligated to each. 
    //x and y can be combined as coordinates and so on. 
    private int x; //takes 4 bytes
    private int y; //takes 4 bytes
    private PointIcon icon;

    public Point(int x, int y, MobsIcon icon){
        this.x = x;
        this.y = y;
        this.icon=icon;
    }

    public void draw(){
        //Example of Format string
        System.out.printf("%s at (%d,%d))", icon.getType(),x,y);
        System.out.println();
    }
}

class PointIcon{
    private PointType type; //takes 4 bytes
    private byte[] icon; // takes 20KB -> 20MB

    public PointIcon(PointType type, byte[] icon){
        this.type = type;
        this.icon = icon;
    }

    public PointType getType() {
        return type;
    }
}


enum PointType{
    HOSPITAL,
    CAFE,
    RESTAURANT,
}

class PointService{
    private PointIconFactory iconFactory;

    public PointService(PointIconFactory iconFactory) {
        this.iconFactory = iconFactory;
    }
    public List<Point> getPoints(){
        List<Point> points = new ArrayList<>();
        var point = new Point(1, 2, iconFactory.getPointIcon(PointType.CAFE));
        points.add(point);

        return points;
    }
}

class PointIconFactory{
    //Hash to reuse pull up objects
    private Map<PointType,PointIcon> icons = new HashMap<>();
    public PointIcon getPointIcon(PointType type){
        //Hash Map where key -> value
        //PointType -> PointIcon
       if(!icons.containsKey(type)){
        var icon = new PointIcon(null, null);
        icons.put(type,icon);
       }

       return icons.get(type);
    }
}