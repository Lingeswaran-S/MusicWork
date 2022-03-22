package com.te.assesment.java;

import java.util.LinkedList;
import java.util.Scanner;

public class Process {
	static Scanner input;

	Process(Scanner input) {
		this.input = input;
	}

	public void displayAllSongs(LinkedList<Music> songList) {
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		for (Music music : songList) {
			System.out.println("SongID: " + music.getSongID());
			System.out.println("SongTitle: " + music.getSongTitle());
			System.out.println("Artist Name: " + music.getArtistName());
			System.out.println("Album Name: " + music.getAlbumName());
			System.out.println("Song Location: " + music.getSongLocation());
			System.out.println("Description: " + music.getSongDescription());
			System.out.println(
					"------------------------------------------------------------------------------------------------");
		}

	}

	public void playAllSong(LinkedList<Music> songList) throws InterruptedException {
		for (Music music : songList) {
			System.out.print("Playing[" + music.getSongTitle());
			for (int i = 0; i < 15; i++) {
				Thread.sleep(250);
				System.out.print(".");
			}
			System.out.println("(Ended)] ");

		}
		System.out.println(".....Thank You.....");
	}

	public void songSearch(LinkedList<Music> songList) throws InterruptedException {

		playAllSong(search(songList, 1));

	}

	public LinkedList<Music> search(LinkedList<Music> songList, int pt) {
		String sTitle;
		boolean ps = true;
		do {
			System.out.println("Enter Song Title or Name More Than 3 Letters");
			sTitle = input.next();

			if (sTitle.length() >= 3) {
				ps = false;
			}

		} while (ps);

		sTitle = sTitle.trim().substring(0, 3).toLowerCase();

		LinkedList<Music> temp = new LinkedList<Music>();
		int c = 0;
		if (pt == 1) {
			for (Music music : songList) {// Search specified song

				if (((music.getSongTitle().toLowerCase()).substring(0, 3)).equalsIgnoreCase(sTitle)) {
					temp.add(music);
					c = 1;
				}

			}
		} else if (pt == 2) {
			for (Music music : songList) {
				if ((music.getSongTitle().toLowerCase()).contains(sTitle)) {
					temp.add(music);
					c = 1;
				}
			}
			System.out.println("********* " + temp.size() + " Matches Founded *********");
		}

		if (c == 0) {
			System.out.println("OPPs!.......No Match");
		}
		return temp;

	}

	public void songSearchDisplay(LinkedList<Music> m) {
		for (Music music : m) {
			System.out.println("----------------------------------" + "\nFile Name   :\n" + music.getSongLocation()
					+ "\\" + music.getSongTitle() + "\n----------------------------------");
			System.out.println("Attributes.....\n" + "Title       :" + music.getSongTitle() + "\n" + "Artist Name :"
					+ music.getArtistName() + "\n" + "Album       :" + music.getArtistName()
					+ "\n----------------------------------");
			System.out
					.println("Play.....\nSong-ID      :" + music.getSongID() + "\n----------------------------------");
		}

	}

	public void arrangeID(LinkedList<Music> songList) {
		int point = 101;
		for (Music music : songList) {
			music.setSongID(point);
			point++;
		}

	}

}
