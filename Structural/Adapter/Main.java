package Structural.Adapter;

public class Main {
    public static void main(String[] args) {
        var imageView = new ImageView(new Image());
//The interface of the Caramel doesn't have the Filter interface
        imageView.apply(new CaramelFilter(new Caramel()));
    }
}

class Image{
  
    }

interface Filter{
    void apply(Image image);
}

class VividFilter implements Filter{

    @Override
    public void apply(Image image) {
       System.out.println("Applying Vivid Filter");
    }

}

class CaramelFilter implements Filter{
    //this model uses Composition
private Caramel caramel;

    public CaramelFilter(Caramel caramel){
        this.caramel = caramel;
    }
    @Override
    public void apply(Image image) {
       caramel.init();
       caramel.render(image);
    }

    

}

class ImageView{
    private Image image;

    public ImageView(Image image){
        this.image=image;
    }

    public void apply(Filter filter){
        filter.apply(image);
    }
}

//3rd Party Library - AvaFilters
class Caramel{
    public void init(){

    }
    public void render(Image image){
        System.out.println("Applying caramel filter");
    }
}