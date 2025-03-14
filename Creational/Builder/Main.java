package Builder;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    var presentation = new Presentation();
    presentation.addSlide(new Slide("Slide 1"));
    presentation.addSlide(new Slide("Slide 1"));

    var builder=  new PdfDocumentBuilder();
    presentation.export(builder);
    builder.getPdfDocument();
  }

    
}

class Slide{
    private String text;

    public Slide(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}

class Presentation {
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide){
        slides.add(slide);
    }

    public void export(PresentationBuilder builder){
        builder.addSlide(new Slide("Copyright"));
        for(Slide slide:slides)
        builder.addSlide(slide);

    }
}

class PDFDocument{
    public void addPage(String text){
        System.out.println("Adding page to PDF");

    }
}

class Movie{
    public void addFrame (String text, int duration){
        System.out.println("Adding a frame to the movie");
    }
}

//interface that communicates with the concrete class
interface PresentationBuilder{
    void addSlide (Slide slide);
}

class PdfDocumentBuilder implements PresentationBuilder{
    private PDFDocument document = new PDFDocument();
    @Override
    public void addSlide(Slide slide) {
        document.addPage(slide.getText());
    }
    //added a method to get the pdf since in the addslide you're simply adding the slide 
    //if this is not stated in the builder it'll result a null value in the main class
    public PDFDocument getPdfDocument(){
        return document;
    }
    
}

class MovieBuilder implements PresentationBuilder{
    private Movie movie = new Movie();
    @Override
    public void addSlide(Slide slide) {
       movie.addFrame(slide.getText(),3);
    }
    public Movie getMovie(){
        return movie;
    }
}