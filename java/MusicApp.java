package com.te.assesment.java;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MusicApp {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		LinkedList<Music> songList = new LinkedList<Music>();
		songList.add(new Music(101, "Ransom", "David", "Attitude", "E:\\Songs",
				"ARESA, UMPI, UMPG Publishing, LatinAutor - UMPG, AMRA, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, BMI - Broadcast Music Inc., ASCAP, LatinAutor, CMRRA, LatinAutorPerf, and 13 Music Rights Societies"));
		songList.add(new Music(102, "Let-Me-Love", "Justin-Biber", "SurpriseLove", "E:\\Songs",
				"\"Let Me Love You\" is written in the key of C minor with a tempo of 100 beats per second common time"));
		songList.add(new Music(103, "Sia-Unstopable", "sia", "Motivational", "E:\\Songs",
				"The song was written by Sia and Christopher Braide, and produced by Jesse Shatkin. It was released as the album's final promotional single on 21 January 2016"));
		songList.add(new Music(104, "Dusk Till Down", "Zayn", "Broken", "E:\\Songs",
				"Dusk Till Dawn\" is a song recorded by English singer and songwriter Zayn featuring Australian singer and songwriter Sia. It was released on 8 September"));
		songList.add(new Music(105, "MeandMy", "Rixiton", "Face-It", "E:\\Songs",
				"In 2012, the band started as a four-piece called Relics and then became known as the band Rixton from 2013 onwards. Their debut single as Rixton, \"Me and My "));
		// displayAllSongs(songList);
		// playAllSong(songList);
		boolean bk = true;

		do {
			System.out.println(
					"Press.....\n1-Play a Song\n2-Search a Song\n3-Show All Songs\n4-Operate On Song Database \n5-Exit\n-----------------------------------------------------------");
			int option = input.nextInt();

			switch (option) {
			case 1: {
				System.out.println("Press.....\nA-Play All Songs\nB-Play Songs Randomly\nC-Play a Particular Song");
				String option1 = input.next().toLowerCase();
				switch (option1) {
				case "a": {
					LinkedList<Music> orderedSongs = (LinkedList<Music>) songList.clone();
					Collections.sort(orderedSongs);
					playAllSong(orderedSongs);
					break;
				}
				case "b": {
					playAllSong(songList);
					break;

				}
				case "c": {
					songSearch(songList);
					break;

				}
				case "d": {
					break;
				}
				default: {
					System.out.println("Invalid Option");
					break;
				}
				}
				break;

			}
			case 2: {
				songSearchDisplay(search(songList));
				break;

			}
			case 3: {
				displayAllSongs(songList);
				break;
			}
			case 4: {
				System.out.println("Press \nA-Add Song\nB-Edit Song\nC-Delete Song");
				String op = input.next();
				switch (op.toLowerCase().substring(0, 1)) {
				case "a": {
					int id = songList.size() + 100;
					System.out.println("Enter SongTitle ?");
					String sT = input.next();
					System.out.println("Enter ArtistName ?");
					String aN = input.next();
					System.out.println("Enter AlbumName ?");
					String alN = input.next();
					System.out.println("Enter SongLocation ?");
					String sL = input.next();
					System.out.println("Enter Song Description ?");
					String sD = input.next();
					id++;
					songList.add(new Music(id, sT, aN, alN, sL, sD));
					break;
				}
				case "b": {
					LinkedList<Integer> idCollect = new LinkedList<Integer>();
					LinkedList<Music> now = search(songList);
					for (Music music : now) {
						System.out.println("Successfully Founded a Song ::" + music.getSongTitle());
						System.out.println("Do you want to edit this song?\n1-Yes\n2-Exit or Go next");
						int eOP = input.nextInt();
						if (eOP == 1) {
							System.out.println("ReEnter SongTitle or NA ?");
							String sT = music.getSongTitle();
							String r1 = input.next();
							if (!(r1.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								sT = r1;
							}
							System.out.println("ReEnter ArtistName ?");
							String aN = music.getArtistName();
							String r2 = input.next();
							if (!(r2.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								aN = r2;

							}

							System.out.println("ReEnter AlbumName ?");
							String alN = music.getAlbumName();
							String r3 = input.next();
							if (!(r3.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								alN = r3;

							}

							System.out.println("ReEnter SongLocation ?");
							String sL = music.getSongLocation();
							String r4 = input.next();
							if (!(r4.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								sL = r4;

							}
							System.out.println("ReEnter Song Description ?");
							String sD = music.getSongDescription();
							String r5 = input.next();
							if (!(r5.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								sD = r5;

							}
							songList.add(new Music(music.getSongID(), sT, aN, alN, sL, sD));
							idCollect.add(music.getSongID());
						}
						Iterator<Music> it = songList.iterator();
						for (Integer integer : idCollect) {
							while (it.hasNext()) {
								if (it.next().getSongID() == integer) {
									it.remove();
									break;
								}
							}
						}

					}
					break;

				}
				case "c": {
					System.out.println("Enter Song ID for Delete.....");
					int dID = input.nextInt();
					Iterator<Music> it = songList.iterator();
					while (it.hasNext()) {
						if (it.next().getSongID() == dID) {
							it.remove();
							break;
						}
					}

					break;

				}
				}
				break;

			}
			case 5: {
				System.out.println("Bye........");
				bk = false;

			}
			}

		} while (bk);
	}

	static void displayAllSongs(LinkedList<Music> songList) {
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

	static void playAllSong(LinkedList<Music> songList) throws InterruptedException {
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

	static void songSearch(LinkedList<Music> songList) throws InterruptedException {

		playAllSong(search(songList));

	}

	static LinkedList<Music> search(LinkedList<Music> songList) {
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
		for (Music music : songList) {

			if (((music.getSongTitle().toLowerCase()).substring(0, 3)).equalsIgnoreCase(sTitle)) {
				temp.add(music);
				c = 1;
			}

		}
		if (c == 0) {
			System.out.println("OPPs!.......No Match");
		}
		return temp;

	}

	static void songSearchDisplay(LinkedList<Music> m) {
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

}
