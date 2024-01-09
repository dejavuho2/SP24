package Playlistnode;

public class PlaylistNode {
    public String songTitle;
    public String artist;
    public PlaylistNode next;

    // Constructor
    public PlaylistNode(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.next = null;
    }
}
