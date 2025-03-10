package Observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var dataSource = new DataSource();
        var sheet1 = new SpreadSheet();
        var sheet2 = new SpreadSheet();
        var chart = new Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(2);
    }
    
}

 class DataSource extends Subject{
    private int value;

    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
        notifyObservers();
    }
    
}

//Observable
class Subject{
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(var observer: observers)
        observer.update();
    }
    
}

class SpreadSheet implements Observer{

    @Override
    public void update() {
       System.out.println("Spreadsheet got notified");
    }

}

class Chart implements Observer{

    @Override
    public void update() {
      System.out.println("Chart got updated");
    }
    
}

interface Observer{
    void update();
}