package Iterator;

public class WithList {
   public static void main(String[] args) {
    var history = new BrowseHistory();

    history.push("a");
    history.push("b");
    history.push("c");
    history.push("d");
    history.pop();
    
    Iterator iterator = history.createIterator();
    while (iterator.hasNext()){
        var url = iterator.current();
        System.out.println(url);
        iterator.next();
    }

   }

    
}

class BrowseHistory{
    private String [] urls = new String[10];
    private int count; 

    public void push(String url){
        urls[count++] = url;
    }
    public String pop(){
        return urls[--count];

    }

    public Iterator createIterator(){
            return new ArrayIterator(this);
        
    }

    class ArrayIterator implements Iterator{
        private BrowseHistory history;
        private int index;

        public ArrayIterator(BrowseHistory history){
            this.history = history;
        }

        @Override
        public boolean hasNext() {
           return (index < history.count);
        }

        @Override
        public String current() {
            return history.urls[index];
        }

        @Override
        public void next() {
            index++;
        }
        
    }
}

interface Iterator{
    boolean hasNext();
    String current();
    void next();
}
