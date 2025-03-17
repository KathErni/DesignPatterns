class Song {
  private song: string;

  constructor(song: string) {
    this.song = song;
  }

  getSong(): string {
    return this.song;
  }
}

class Artist {
  private artist: string;

  constructor(artist: string) {
    this.artist = artist;
  }

  getArtist(): string {
    return this.artist;
  }
}

class MusicPlaylist {
  connect(id: number): Connection {
    return new Connection();
  }

  play(song: Song, artist: Artist): void {
    console.log(`Playing: ${song.getSong()} by ${artist.getArtist()}`);
  }

  recent(song: Song, artist: Artist): void {
    console.log(`Recently Played: ${song.getSong()} by ${artist.getArtist()}`);
  }
}

class Connection {
  stopPlaying(): void {
    console.log("Playlist stopped.");
  }
}

class PlaylistService {
  send(song: string, artist: string): void {
    const server = new MusicPlaylist();
    const connection = server.connect(12);
    server.connect(1);
    server.play(new Song(song), new Artist(artist));
    connection.stopPlaying();
  }
}

class DIYFacade {
  public static main(): void {
    const service = new PlaylistService();
    service.send("My Tears Ricochet", "Taylor Swift");
  }
}

DIYFacade.main();
