package Structural.Proxy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var library = new Library();
        String[] fileNames = {"a", "b", "c"};
        for (var filename : fileNames) {
            library.add(new LoggingEbookProxy(filename));
            
   
        }
        library.openEbook("a");
        }
    }


class RealEbook implements Ebook{
    private String fileName;

    public RealEbook(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load(){
        System.out.println("Loading the ebook " + fileName);
    }

    public void show(){
        System.out.println("Showing the ebook "+ fileName);
    }
    public String getFilename(){
        return fileName;
    
    }
}

class EbookProxy implements Ebook{
    private String fileName;
    private RealEbook ebook;

    public EbookProxy(String fileName) {
        this.fileName = fileName;

    }

    
    @Override
    public void show() {
       if(ebook == null)
       ebook = new RealEbook(fileName);
       ebook.show();
    }

    @Override
    public String getFilename() {
      return fileName;
    }
    
}

class LoggingEbookProxy implements Ebook{
 private String fileName;
 private RealEbook ebook;

    public LoggingEbookProxy(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void show() {
        if(ebook == null)
       ebook = new RealEbook(fileName);

       System.out.println("Logging");
       ebook.show();
    }

    @Override
    public String getFilename() {
       return fileName;
    }
    
}

class Library{
    private Map<String,Ebook> ebooks = new HashMap<>();
    public void add(Ebook ebook){
        ebooks.put(ebook.getFilename(),ebook);
    }

    public void openEbook(String fileName){
        ebooks.get(fileName).show();
    }
}

interface Ebook{
    void show();
    String getFilename();
}
