package Structural.Decorator;

public class Main {
    public static void main(String[] args) {
        //Cloudstream -> Encrypted -> Compressed 
       storeCreditCard(new EncryptedCloudStream(new CompressedCloudStream(new CloudStream())));
    }
    public static void storeCreditCard(Stream stream){
        stream.write("1234-1234-1234-1234");
    }
    
}

class CloudStream implements Stream{
    public void write(String data){
        System.out.println("Storing " + data);
    }
   
}

//Decorator
class EncryptedCloudStream implements Stream{
    private Stream stream;

    public EncryptedCloudStream(Stream stream) {
        this.stream = stream;
    } {
        this.stream = stream;
    }
    @Override
    public void write(String data) {
        var encrypted = encrypt(data);
        stream.write(encrypted);
    }

    private String encrypt(String data){
        return "#()$@(*$)@!__~!#";
    }
}

//Decorator
class CompressedCloudStream implements Stream{
    private Stream stream;
    public CompressedCloudStream(Stream stream) {
        this.stream = stream;
    }
    @Override
    public void write(String data) {
        var compressed = compress(data);
        stream.write(compressed);
        
    }
    private String compress(String data){
        return data.substring(0,5);
    }
}

interface Stream{
    void write(String data);
}