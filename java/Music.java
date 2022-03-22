package com.te.assesment.java;

public class Music implements Comparable<Music> {
	private int songID;
	private String songTitle;
	private String artistName;
	private String albumName;
	private String songLocation;
	private String songDescription;

	public Music() {
		super();
	}

	public Music(int songID, String songTitle, String artistName, String albumName, String songLocation,
			String songDescription) {
		super();
		this.songID = songID;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumName = albumName;
		this.songLocation = songLocation;
		this.songDescription = songDescription;
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongLocation() {
		return songLocation;
	}

	public void setSongLocation(String songLocation) {
		this.songLocation = songLocation;
	}

	public String getSongDescription() {
		return songDescription;
	}

	public void setSongDescription(String songDescription) {
		this.songDescription = songDescription;
	}

	@Override
	public String toString() {
		return "Music [songID=" + songID + ", songTitle=" + songTitle + ", artistName=" + artistName + ", albumName="
				+ albumName + ", songLocation=" + songLocation + ", songDescription=" + songDescription + "]";
	}

	@Override
	public int compareTo(Music o) {
		if (this.songTitle.charAt(0) > o.songTitle.charAt(0))
			return 1;
		else if (this.songTitle.charAt(0) < o.songTitle.charAt(0))
			return -1;
		return 0;
	}

}
