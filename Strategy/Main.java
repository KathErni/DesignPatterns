package Strategy;

public class Main {
   public static void main(String[] args) {

    var imageStorage = new ImageStorage(new JpegCompressor(),new BlackandWhiteFilter());
    System.out.println("Filename:A");
    imageStorage.store("a");
}
}

class ImageStorage {
    private Compressor compressor;
    private Filter filter;

    public ImageStorage(Compressor compressor, Filter filter){
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileName){
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


