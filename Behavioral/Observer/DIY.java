package Observer;

import java.util.ArrayList;
import java.util.List;

public class DIY {
    public static void main(String[] args) {
        var data = new DataSource();
        var canvas1 = new Canvas(data);
        var canvas2= new Canvas(data);
        var canvas3 = new Canvas(data);

        data.addObserver(canvas1);
        data.addObserver(canvas2);
        data.removeObserver(canvas3);

        data.setValue(
            "Drawing"
        );;
    }
    
}

class DataSource extends Subject{
    private String value;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value=value;
        notifyObservers();
    }
}

class Subject{
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(var observer: observers){
           observer.update(); 
        }
    } 
}

class Canvas implements Observer{
    private DataSource data;
    public Canvas(DataSource data){
        this.data=data;
    }
    @Override
    public void update() {
      System.out.println("Canvas got updated:" + data.getValue() );
    }
    
}
interface Observer{
    void update();
}
