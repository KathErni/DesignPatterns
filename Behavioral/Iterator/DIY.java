package Iterator;

import java.util.ArrayList;
import java.util.List;

public class DIY {
    public static void main(String[] args) {
        var playlist = new MusicPlaylist();

        //songs
        playlist.push("Enemies by Imagine Dragons");
        playlist.push("Mambo no 5 by Lou Bega");
        playlist.push("Call Me Maybe by Carly Rae Jepsen");
        playlist.pop();
        
        

        Iterator iterator = playlist.createIterator();

        System.out.println("Currently Playing: " + iterator.current());
        
            while(iterator.hasNext()){
                iterator.next();
                System.out.println("Next song: " + iterator.current());  
        }
    }
       
}

//Playlist
class MusicPlaylist{
    public List<String> songs = new ArrayList<>();
    int count;

    public void push(String song ){
        songs.add(song);
    }

    public String pop(){
        var lastIndex = songs.size() -1;
        var lastSong = songs.get(lastIndex);
        songs.remove(lastSong);
        return lastSong;
    }

    public Iterator createIterator(){
        return new SongListIterator(this);
    }
//Iterator
    public class SongListIterator implements Iterator{
        private MusicPlaylist playlist;
        private int index;

        public SongListIterator (MusicPlaylist playlist){
            this.playlist=playlist;
        }

        @Override
        public boolean hasNext() {
          return(index < playlist.songs.size()-1);
        }

        @Override
        public String current() {
            return playlist.songs.get(index);
         }

        @Override
        public void next() {
            if(hasNext()){index++;}
        }

        
    }

}
//Interface
interface Iterator{
    boolean hasNext();
    String current();
    void next();
    
}
