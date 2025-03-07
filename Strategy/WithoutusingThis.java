package Strategy;

public class WithoutusingThis {
   public static void main(String[] args) {
    //Another way
    var imageStorage = new ImageStorage();
    imageStorage.store("a", new JpegCompressor(), new BlackandWhiteFilter());
   }
  
}


class ImageStorage {
   
   public void store(String fileName, Compressor compressor, Filter filter){
        //We need to set 2 algo
        //To compress picture files into JPG,PNG, etc. 
        //To filter picture for black and white, colored and high contrast
        compressor.compress(fileName);
        filter.apply(fileName);
    }

    
}

interface Compressor{
    void compress(String fileName);
}

class JpegCompressor implements Compressor{

    @Override
    public void compress(String fileName) {
       System.out.println("Compressing using JPEG");
    }

}

class PngCompressor implements Compressor{

    @Override
    public void compress(String fileName) {
        System.out.println("Compressing using PNG");
       }

}

interface Filter{
    void apply(String fileName);
}

class BlackandWhiteFilter implements Filter{

    @Override
    public void apply(String fileName) {
        System.out.println("Applying B&W filter");

}
}


