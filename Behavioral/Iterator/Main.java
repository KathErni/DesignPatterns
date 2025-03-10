package Iterator;

import java.util.ArrayList;
import java.util.List;;

public class Main {
public static void main(String[] args) {
    var history = new BrowseHistory();

    history.push("a");
    history.push("b");
    history.push("c");
    
    
    Iterator iterator = history.createIterator();
    while(iterator.hasNext()){
        var url = iterator.current();
        System.out.println(url);
        iterator.next();
    }
}    
}

class BrowseHistory{
    private List<String> urls = new ArrayList<>();
    int count;
    
    public void push(String url){
        urls.add(url);
        
    }
    
    public String pop(){
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);
        
        return lastUrl;

            }
    public Iterator createIterator(){
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator{
            private BrowseHistory history;
            private int index;
        public ListIterator(BrowseHistory history){
            this.history = history;
        }
        @Override
        public boolean hasNext() {
            return(index<history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
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
