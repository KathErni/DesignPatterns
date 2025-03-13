package Structural.Proxy;

import java.util.HashMap;
import java.util.Map;

public class DIY {
    public static void main(String[] args) {
        var playlist = new Playlist();
        String [] songs = {"The one that got away", "My Tears Rocochet", "Belly Ache"};
        for (var song : songs){
            playlist.add(new SongProxy(song));
        }
        playlist.openSong("The one that got away");
    }
}

//Real Object
class RealSong implements Song{
private String song;

    public RealSong(String song) {
        this.song = song;
        load();
    }
   private void load(){
        System.out.println("Buffering...");
   }

    @Override
    public void show() {
        System.out.println("Playing song: " + song);
    }

    @Override
    public String getSong() {
        return song;
    }
}

//Proxy - substitute for the real object
class SongProxy implements Song{
    private RealSong realSong;
    private String song;

    public SongProxy(String song) {
        this.song = song;
    }

    @Override
    public void show() {
        if (realSong == null){
        realSong = new RealSong(song);
        }

        realSong.show();
    }

    @Override
    public String getSong() {
      return song;
    }

}
//Library 

class Playlist {
    private Map<String,Song> songs = new HashMap<>();
    public void add(Song song){
        songs.put(song.getSong(), song);
    }
    public void openSong(String song){
        songs.get(song).show();
    }

    
}
interface Song{
    void show();
    String getSong();
}