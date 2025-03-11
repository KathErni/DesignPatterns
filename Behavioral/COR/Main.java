package COR;

public class Main {
    //authenticator -> loger -> compressor -> encyptor
    public static void main(String[] args) {
        var encryptor = new Encryptor(null);
        var compressor = new Compressor(encryptor);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator (logger);

        var server = new WebServer(authenticator);
        server.handle(new HttpRequest("admin", "1234"));
    }
    
}

class WebServer{
    private Handler handler;

    public WebServer(Handler handler){
        this.handler = handler;
    }
    public void handle(HttpRequest request){
        handler.handle(request);
    }

    }

class HttpRequest{
    private String username;
    private String password;

    public HttpRequest(String username, String password){
        this.username = username;
        this.password = password;
    }
   

    public String getUsername(){
            return username;
    }

    public String getPassword(){
            return password;
    }


}

class Authenticator extends Handler{

    public Authenticator(Handler next) {
            super(next);
    }
    
        @Override
    boolean doHandle(HttpRequest request) {

            var isValid = (request.getUsername() == "admin" &&
                           request.getPassword() == "1234");
        System.out.println("Authentication");
                     return !isValid; 
        }
    }


class Compressor extends Handler{
    
    public Compressor(Handler next) {
            super(next);
                }
    
        @Override
    public boolean doHandle(HttpRequest request) {
            System.out.println("Compressed");
             return false;
     }
}

class Logger extends Handler{
    public Logger(Handler next) {
            super(next);
           
        }
    
        @Override
    boolean doHandle(HttpRequest request) {
        System.out.println("Log");
    
        return false;
     }
}

class Encryptor extends Handler {

    public Encryptor(Handler next) {
            super(next);
        }
    
        @Override
    boolean doHandle(HttpRequest request) {
        System.out.println("Encryption");

        return false;
    }
    
    


}
abstract class Handler{
    private Handler next;

    public Handler(Handler next){
        this.next=next;
    }

    public void handle(HttpRequest request){
       if( doHandle(request))
       return;
        if (next!=null)
       next.handle(request);
    }
    abstract boolean doHandle(HttpRequest request);
}
