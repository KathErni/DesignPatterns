interface ProxySong {
  show(): void;
  getSong(): string;
}

// Real Object
class RealSong implements ProxySong {
  private song: string;

  constructor(song: string) {
    this.song = song;
    this.load();
  }

  private load(): void {
    console.log("Buffering...");
  }

  show(): void {
    console.log("Playing song: " + this.song);
  }

  getSong(): string {
    return this.song;
  }
}

// Proxy - substitute for the real object
class SongProxy implements ProxySong {
  private realSong: RealSong | null = null;
  private song: string;

  constructor(song: string) {
    this.song = song;
  }

  show(): void {
    if (this.realSong === null) {
      this.realSong = new RealSong(this.song);
    }
    this.realSong.show();
  }

  getSong(): string {
    return this.song;
  }
}

// Library
class Playlist {
  private songs: ProxySong[] = [];

  add(song: ProxySong): void {
    this.songs.push(song);
  }

  openSong(song: string): void {
    const foundSong = this.songs.find((s) => s.getSong() === song);
    foundSong?.show();
  }
}

class DIYProxy {
  public static main(): void {
    const playlist = new Playlist();
    const songs = ["The one that got away", "My Tears Ricochet", "Belly Ache"];
    for (const song of songs) {
      playlist.add(new SongProxy(song));
    }
    playlist.openSong("The one that got away");
  }
}

DIYProxy.main();
