package Playlist;

import Playlistnode.PlaylistNode;

public class Playlist {
    private PlaylistNode head;
    private PlaylistNode tail;
    private PlaylistNode currentSong;

    
    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentSong = null;
    }

    // Thêm một bài hát vào danh sách phát
    public void addSong(String songTitle, String artist) {
        PlaylistNode newNode = new PlaylistNode(songTitle, artist);
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentSong = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Xóa một bài hát khỏi danh sách phát
    public void removeSong(String songTitle) {
        PlaylistNode current = head;
        PlaylistNode previous = null;

        // Tìm bài hát cần xóa
        while (current != null && !current.songTitle.equals(songTitle)) {
            previous = current;
            current = current.next;
        }

        // Nếu bài hát được tìm thấy, xóa nó
        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }

            // Kiểm tra xem bài hát đang chơi có bị xóa không
            if (current == currentSong) {
                currentSong = currentSong.next;
            }

            // Nếu bài hát cuối cùng được xóa, cập nhật tail
            if (current == tail) {
                tail = previous;
            }
        }
    }

    // Phát một bài hát
    public void playCurrentSong() {
        if (currentSong != null) {
            System.out.println("Playing: " + currentSong.songTitle + " - " + currentSong.artist);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Chuyển sang bài hát tiếp theo
    public void NextSong() {
        if (currentSong != null) {
            currentSong = currentSong.next;
            if (currentSong == null) {
                currentSong = head; // Quay lại đầu danh sách nếu đã đến cuối
            }
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Chuyển đến bài hát trước đó
    public void PreviousSong() {
        if (currentSong != null) {
            PlaylistNode previous = null;
            PlaylistNode temp = head;

            while (temp != null && temp != currentSong) {
                previous = temp;
                temp = temp.next;
            }

            if (previous != null) {
                currentSong = previous;
            }
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // In ra danh sách phát
    public void printPlaylist() {
        PlaylistNode temp = head;
        while (temp != null) {
            System.out.println(temp.songTitle + " - " + temp.artist);
            temp = temp.next;
        }
    }
}
