package Creational.Singleton;

import java.util.HashMap;
import java.util.Map;

public class DIY {

   public static void main(String[] args) {
    TaskManager task = TaskManager.getInstance();
    task.set("computer", "add task");

    TaskManager others = TaskManager.getInstance();
    System.out.println(others.get("computer"));
   }
    
}

class TaskManager{
    private Map<String, Object> settings = new HashMap<>();
    private static TaskManager instance= new TaskManager();

    TaskManager(){};


    public static TaskManager getInstance(){
        return instance;
    }

    public void set(String type, Object task){
        settings.put(type,task);
    }
        public Object get(String type){
            return settings.get(type);
}
}