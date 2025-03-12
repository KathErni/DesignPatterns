package Structural.Decorator;

public class DIY {
    public static void main(String[] args) {
        storeCredentials(new hashData(new CompressedData(new Register())) );
    }

    public static void storeCredentials(Credentials credentials){
            credentials.write("Kathlynne Joy Moraga", "1234");

    }
    
}

class Register implements Credentials {
    public void write(String username, String password){
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

class addData implements Credentials{
    private Credentials credentials;
    public addData(Credentials credentials) {
        this.credentials = credentials;
    }
    @Override
    public void write(String username, String password) {
       credentials.write(username,password);
    }
    

}

class hashData implements Credentials{
    private Credentials credentials;
    public hashData(Credentials credentials) {
        this.credentials = credentials;
    }
    @Override
    public void write(String username, String password) {
        var encrypted = encrypt(password);
        credentials.write(username, encrypted);
        
    }
    private String encrypt(String password){
        return "@#)@(_)$(___@#)()!@$";
    }

}

class CompressedData implements Credentials{
    private Credentials credentials;
    public CompressedData(Credentials credentials) {
        this.credentials = credentials;
    }
    @Override
    public void write(String username, String password) {
      var compressedUsername = compressUsername(username);
      var compressedPassword = compressPassword(password);
      credentials.write(compressedUsername,compressedPassword);
    }
   private String compressUsername(String username){
    return username.substring(0,3);
    
   } 

   private String compressPassword(String password){
    return password.substring(0,5);
   }
}

interface Credentials{
    void write(String username, String password);
    
}
