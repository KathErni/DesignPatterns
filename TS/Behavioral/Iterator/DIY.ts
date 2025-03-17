interface DIYIterator {
  hasNext(): boolean;
  current(): string;
  next(): void;
}

class MusicPlaylist {
  public songs: string[] = [];

  push(song: string): void {
    this.songs.push(song);
  }

  pop(): string {
    const lastIndex = this.songs.length - 1;
    const lastSong = this.songs[lastIndex];
    this.songs.splice(lastIndex, 1);
    return lastSong;
  }

  createIterator(): DIYIterator {
    return new SongListIterator(this);
  }
}

class SongListIterator implements DIYIterator {
  private playlist: MusicPlaylist;
  private index: number = 0;

  constructor(playlist: MusicPlaylist) {
    this.playlist = playlist;
  }

  hasNext(): boolean {
    return this.index < this.playlist.songs.length - 1;
  }

  current(): string {
    return this.playlist.songs[this.index];
  }

  next(): void {
    if (this.hasNext()) {
      this.index++;
    }
  }
}

// The Client
const playlist = new MusicPlaylist();

// songs
playlist.push("Enemies by Imagine Dragons");
playlist.push("Mambo no 5 by Lou Bega");
playlist.push("Call Me Maybe by Carly Rae Jepsen");
playlist.pop();

const iterator = playlist.createIterator();

console.log("Currently Playing: " + iterator.current());

while (iterator.hasNext()) {
  iterator.next();
  console.log("Next song: " + iterator.current());
}
