package Playlist;

import java.util.Scanner;

public class PlaylistMenu {

    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nPlaylist Menu:");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Current Song");
            System.out.println("4. Next Song");
            System.out.println("5. Previous Song");
            System.out.println("6. Print Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String songTitle = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    myPlaylist.addSong(songTitle, artist);
                    break;

                case 2:
                    System.out.print("Enter the song title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    myPlaylist.removeSong(titleToRemove);
                    break;

                case 3:
                    myPlaylist.playCurrentSong();
                    break;

                case 4:
                    myPlaylist.NextSong();
                    myPlaylist.playCurrentSong();
                    break;

                case 5:
                    myPlaylist.PreviousSong();
                    myPlaylist.playCurrentSong();
                    break;

                case 6:
                    myPlaylist.printPlaylist();
                    break;

                case 0:
                    System.out.println("Exiting the Playlist. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
