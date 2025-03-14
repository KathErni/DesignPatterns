package Creational.Singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConfigManager manager = ConfigManager.getInstance();
        manager.set("name","Mosh");

        ConfigManager other= ConfigManager.getInstance();
        System.out.println(other.get("name"));
    }
}

class ConfigManager{
    private Map<String, Object> settings = new HashMap<>();
    //Declaring the instance variable as volatile to ensure 
    //MultipleThreading
    private static volatile ConfigManager instance = new ConfigManager();

    private ConfigManager(){};

    public static ConfigManager getInstance() {
        if(instance ==null){
    //If instance is null it enters a sychnization to ensure
    //One thread can enter the instance
            synchronized (ConfigManager.class){
                //checks it's null before creating another config manager.
                if (instance == null){
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public void set(String key, Object value){
        settings.put(key,value);
    }
    public Object get(String key){
        return settings.get(key);
    }
}
