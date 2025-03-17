package Mediator;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        UsersImplementsMediator userMediator = new UsersImplementsMediator();
        User david =  new UserMessages(userMediator, "Martin");	
        User monteza = new UserMessages(userMediator, "Monteza");
        User messy = new UserMessages(userMediator, "Messy");

            monteza.send("Meeting Started.");
    }
    
}

interface Mediator {
    void send(String message, User user);
    void addUser(User user);    
}

class UsersImplementsMediator implements Mediator {
    private List<User> users;
    
    public UsersImplementsMediator() {
        this.users = new ArrayList<>();
    }
    
    @Override
    public void send(String message, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
    
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

abstract class User {
    protected Mediator mediator;
    protected String name;
    
    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.addUser(this);
    }
    
    public abstract void send(String message);
    
    public abstract void receive(String message);
}

class UserMessages extends User{
    public UserMessages(Mediator mediator, String name) {
        super(mediator, name);
    }
    @Override
    public void send(String message) {
        System.out.println(this.name + ": Sending Messages- " + message);
        mediator.send(message, this); 
    }

    @Override
    public void receive(String message) {
        {
            System.out.println(this.name + ": Receiving Messages- " + message);
        }
    }
}



