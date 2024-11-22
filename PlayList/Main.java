import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Album> albums = new ArrayList<>();

		Album album = new Album("Stormbringer", "Deep Purple");
		album.addSong("Stormbringer", 4.6);
		album.addSong("Love don't mean a thing", 4.22);
		album.addSong("Holy man", 4.3);
		album.addSong("Hold on", 5.6);
		album.addSong("Lady double dealer", 3.21);
		album.addSong("You can't do it right", 6.23);
		album.addSong("High ball shooter", 4.27);
		album.addSong("The gypsy", 4.2);
		album.addSong("Soldier of fortune", 3.13);
		albums.add(album);

		album = new Album("For those about to rock", "AC/DC");
		album.addSong("For those about to rock", 5.44);
		album.addSong("I put the finger on you", 3.25);
		album.addSong("Lets go", 3.45);
		album.addSong("Inject the venom", 3.33);
		album.addSong("Snowballed", 4.51);
		album.addSong("Evil walks", 3.45);
		album.addSong("C.O.D.", 5.25);
		album.addSong("Breaking the rules", 5.32);
		album.addSong("Night of the long knives", 5.12);
		albums.add(album);

		LinkedList<Song> playList = new LinkedList<Song>();
		albums.get(0).addToPlayList("You can't do it right", playList);
		albums.get(0).addToPlayList("Holy man", playList);
		albums.get(0).addToPlayList("Speed king", playList); // Does not exist
		albums.get(0).addToPlayList(9, playList);
		albums.get(1).addToPlayList(3, playList);
		albums.get(1).addToPlayList(2, playList);
		albums.get(1).addToPlayList(24, playList); // There is no track 24

		System.out.println("Playlist:");
		for (Song song : playList) {
			System.out.println(song);
		}
	}
}

class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}

	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
			return true;
		}
		return false;
	}

	private Song findSong(String title) {
		for (Song song : songs) {
			if (song.getTitle().equals(title)) {
				return song;
			}
		}
		return null;
	}

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
		// Номера треков начинаются с 1, но индексация в ArrayList начинается с 0
		int index = trackNumber - 1;
		if (index >= 0 && index < songs.size()) {
			playList.add(songs.get(index));
			return true;
		}
		return false;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		Song song = findSong(title);
		if (song != null) {
			playList.add(song);
			return true;
		}
		return false;
	}
}

class Song {
	private String title;
	private double duration;

	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return title + ": " + duration;
	}
}
