package Structural.Facade;

public class DIY {
    public static void main(String[] args) {
        var service = new PlaylistService();
        service.send("My Tears Ricochet", "Taylor Swift");
    
    }
    
}

class Song{
    private String song;
    public Song(String song) {
            this.song = song;
    }

    public String getSong() {
        return song;
    }

}

class Artist{
    private String artist;
    public Artist(String artist){
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }
}

class Playlist{

    public Connection connect(int Id){
            return new Connection();
        
    }
    public void play(Song song, Artist artist){
        System.out.println("Playing: " + song.getSong() + " by " + artist.getArtist());
    }

    public void recent(Song song, Artist artist){
        System.out.println("Recently Played: " + song.getSong() + " by " + artist.getArtist());
    }



}

class Connection{
    public void stopPlaying(){
        System.out.println("Playlist stopped.");
    }
}


class PlaylistService{
    public void send(String song, String artist){
        var server = new Playlist();
        var connection = server.connect(12);
        server.connect(1);
        server.play(new Song(song),new Artist(artist));
        connection.stopPlaying();
       
    }

}